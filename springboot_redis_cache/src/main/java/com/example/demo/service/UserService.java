package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findUserById(Long id);

    List<User> findAllUser();

    User updateUser(User user);

    void deleteUser(Long id);
}
