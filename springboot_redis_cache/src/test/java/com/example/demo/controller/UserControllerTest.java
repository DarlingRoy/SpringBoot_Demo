package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvc注解，该注解用于自动配置MockMvc，使用@Autowired就可以开箱即用
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    MockMvc的使用流程是:
//  发起url请求(perform) –> 打印( andDo(print()) ) –>断言(andExpect)，
//  在andExpect中使用jsonPath来获取key对应的value来进行断言。


    @Test
    @Transactional
    public void saveUserTest() throws Exception {
        mockMvc.perform(post("/user/save")
                .param("name","dd")
                .param("age","14")
            )
                .andExpect(status().isOk())
                .andDo(print());

//        检测
        mockMvc.perform(get("/user/findAll"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("dd")));
    }
}
