package com.hjc.common.precondition;

import com.hjc.common.util.SpringContextHolder;
import com.hjc.spring.persistence.dao.UserMapper;

import javax.annotation.PostConstruct;

public class InitAnnoBean {

    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

    @PostConstruct
    public void init() {
        System.out.println(userMapper.selectByPrimaryKey(1).getUserName());
    }
}
