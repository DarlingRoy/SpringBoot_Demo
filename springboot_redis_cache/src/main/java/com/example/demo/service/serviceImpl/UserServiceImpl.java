package com.example.demo.service.serviceImpl;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig注解使用了application.yml配置的Redis-cache名字，
// 如果不使用该注解的话就需要在下面那些cache注解表明缓存名称了。
@CacheConfig(cacheNames = "c1")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @CachePut(key = "#user.getId()")
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    //@Cacheable一般用于read方法
    @Cacheable
//    默认情况下缓存的key是方法参数，value是方法返回值
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
//    @CachePut一般用于update方法
//    默认情况下缓存的key是方法参数，
// 缓存的value是方法返回值。如果不想使用默认的key，
// 还可以使用蹩脚的SpEL ( Spring Experssion Language ) 语法来指定。
// 类似在@CachePut中使用方法参数user的getId() 方法来获取id作为缓存的key。
    @CachePut(key = "#user.getId()")
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return userMapper.findUserById(user.getId());
    }

    @Override
//    @CacheEvict一般用于delete方法
    @CacheEvict
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }
}
