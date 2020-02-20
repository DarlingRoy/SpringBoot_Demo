package com.example.demo.dao;

import com.example.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    public void saveUserTest(){
        User user=new User(4L,"dd",14);
        userMapper.saveUser(user);
        Assert.assertEquals(4,userMapper.findAllUser().size());
    }

    @Test
    @Transactional
    public void findAllUserTest(){
        Assert.assertEquals(3,userMapper.findAllUser().size());
    }

    @Test
    @Transactional
    public void findUserByIdTest(){
        Assert.assertEquals("aa",userMapper.findUserById(1L).getName());
    }

    @Test
    @Transactional
    public void updateUserTest(){
        User user=userMapper.findUserById(1L);
        user.setName("abc");
        userMapper.updateUser(user);
        Assert.assertEquals("abc",userMapper.findUserById(1L).getName());
    }

    @Test
    @Transactional
    public void deleteTest(){
        userMapper.deleteUser(3L);
        Assert.assertEquals(2,userMapper.findAllUser().size());
    }
}
