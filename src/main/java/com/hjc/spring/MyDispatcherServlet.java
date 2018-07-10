package com.hjc.spring;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : Administrator
 * @date : 2018/7/5 0005 17:21
 * @description : DispatcherServlet
 */
public class MyDispatcherServlet extends DispatcherServlet {

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doService(request, response);
        System.out.println("asdfasdfsd");
    }
}
