package com.neo.web;

import com.neo.mapper.UserMapper;
import com.neo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @RequestMapping("/findById")
    public User findById(long id){
        return userMapper.findById(id);
    }

    @RequestMapping("/insert")
    public void insert(User user){
        userMapper.insert(user);
    }

    @RequestMapping("/update")
    public void update(User user){
        userMapper.update(user);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        userMapper.delete(id);
    }
}
