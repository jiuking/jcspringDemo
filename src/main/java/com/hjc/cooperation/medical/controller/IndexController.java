package com.hjc.cooperation.medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
@Controller
@RequestMapping("/cooperate")
public class IndexController {


    @RequestMapping("/index")
    public String index(){
        return "cooperate/index";
    }

    @RequestMapping("/upload")
    public void upload(MultipartFile uploadFile) throws Exception{
    }
}
