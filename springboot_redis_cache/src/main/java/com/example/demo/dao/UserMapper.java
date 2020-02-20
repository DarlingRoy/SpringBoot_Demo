package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 插入数据
     * @param user
     */
    void saveUser(User user);

    /**
     * 根据id查找User
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 查找所有User
     * @return
     */
    List<User> findAllUser();

    /**
     * 更新User
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除一条User
     * @param id
     */
    void deleteUser(Long id);
}
