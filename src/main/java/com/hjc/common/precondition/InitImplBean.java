package com.hjc.common.precondition;

import com.hjc.common.util.SpringContextHolder;
import com.hjc.spring.persistence.dao.UserMapper;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class InitImplBean implements ApplicationListener{

    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("bean初始化完成后："+userMapper.selectByPrimaryKey(1).getUserName());
    }
}
