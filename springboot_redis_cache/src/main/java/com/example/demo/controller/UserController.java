package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
//    不用实现类，直接用接口？
    private UserService userService;

    @RequestMapping("/save")
    public void saveUser(User user){
        userService.saveUser(user);
    }

    @RequestMapping("/findAll")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping("/findById")
    public User findById(Long id){
        return userService.findUserById(id);
    }

    @RequestMapping("/update")
    public User updateUser(User user){
        return userService.updateUser(user);
    }

    @RequestMapping("/delete")
    public void deleteUser(Long id){
        userService.deleteUser(id);
    }
}
