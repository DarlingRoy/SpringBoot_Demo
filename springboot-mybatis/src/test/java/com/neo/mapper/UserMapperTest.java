package com.neo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa", "a123456", "男"));
        userMapper.insert(new User("bb", "b123456", "男"));
        userMapper.insert(new User("cc", "b123456", "女"));

        Assert.assertEquals(3, userMapper.findAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.findAll();
        if(users==null || users.size()==0){
            System.out.println("is null");
        }else{
            System.out.println(users.toString());
        }
    }

    @Test
    public void testupdate(){
        User user = userMapper.findById(30);
        System.out.println(user);
        user.setUserName("小明");
        userMapper.update(user);
    }

}