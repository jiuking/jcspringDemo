package com.hjc.spring.service.impl;

import com.hjc.spring.persistence.dao.UserMapper;
import com.hjc.spring.persistence.entity.User;
import com.hjc.spring.service.UserService;
import com.hjc.spring.service.UserServiceCopy;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImplCopy implements UserServiceCopy {

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertRequest() {
        User user = new User();
        user.setId(4);
        user.setAge(14);
        user.setUserName("函数4");
        user.setPassword("124");
        userMapper.insert(user);
        /*try {
            ((UserService) AopContext.currentProxy()).insertRequires_New();
        } catch (Exception e) {
            System.out.println("error:算法错误");
            e.printStackTrace();
        }*/
        int a = 1 /0;
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insertRequires_New() {
        User user = new User();
        user.setId(5);
        user.setAge(15);
        user.setUserName("函数new");
        user.setPassword("124");
        userMapper.insert(user);
        return 0;
    }
}
