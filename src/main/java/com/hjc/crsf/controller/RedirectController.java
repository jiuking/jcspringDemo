package com.hjc.crsf.controller;

import com.hjc.crsf.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Administrator
 * @date : 2018/7/16 0016 10:20
 * @description : 重定向页面
 */
@Controller
public class RedirectController {

    @Autowired
    private RedirectService redirectService;

    @RequestMapping("redirect")
    public String redirect() {
        String url = "http://www.baidu.com";
        System.out.println("转发");
        redirectService.redirectUrlContent(url);
        return "redirect111:"+url;
    }

}
