package com.hjc.spring.controller;

import com.hjc.spring.persistence.entity.User;
import com.hjc.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping("/demo")
    public String index(Model model){
        User user = userService.get();
        model.addAttribute("user",user);
        return "index";
    }
}
