package com.hjc.common.precondition;

import com.hjc.common.util.SpringContextHolder;
import com.hjc.spring.persistence.dao.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitWebServlet extends HttpServlet {

    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("web servlet启动时"+userMapper.selectByPrimaryKey(1).getUserName());
    }
}
