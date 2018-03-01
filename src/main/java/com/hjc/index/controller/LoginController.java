package com.hjc.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String index() {
        return "login";
    }

    @RequestMapping("/enter")
    public String enter(String username,String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "cooperate/list";
    }
}
