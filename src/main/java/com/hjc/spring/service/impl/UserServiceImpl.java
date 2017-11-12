package com.hjc.spring.service.impl;

import com.hjc.spring.persistence.dao.UserMapper;
import com.hjc.spring.persistence.entity.User;
import com.hjc.spring.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional
    public void test() throws Exception{
        User user = new User();
        user.setId(2);
        user.setAge(12);
        user.setUserName("函数");
        user.setPassword("124");
        insert(user);

        User userUp = new User();
        userUp.setId(1);
        userUp.setAge(12);
        update(userUp);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User get() {
        return userMapper.selectByPrimaryKey(1);
    }
}
