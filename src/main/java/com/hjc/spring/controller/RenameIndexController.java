package com.hjc.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.hjc.spring.persistence.entity.User;
import com.hjc.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RenameIndexController {

    @Resource
    private UserService userService;

    @RequestMapping("/demo")
    public String index(Model model){
        User user = userService.get();
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("json")
    @ResponseBody
    public Object castJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Tom");
        jsonObject.put("age","12");
        return jsonObject.toString();
    }
}


