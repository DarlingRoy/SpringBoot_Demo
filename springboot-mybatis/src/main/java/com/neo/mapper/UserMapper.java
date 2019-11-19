package com.neo.mapper;

import com.neo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAll();

    User findById(long id);

    void insert(User user);

    void update(User user);

    void delete(long id);
}
