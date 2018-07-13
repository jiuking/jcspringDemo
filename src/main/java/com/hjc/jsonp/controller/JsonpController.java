package com.hjc.jsonp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Administrator
 * @date : 2018/7/13 0013 17:23
 * @description : jsonp跨域
 */
@RestController
public class JsonpController {

    @RequestMapping("/jsonp1")
    public Object jsonp1() {
        Map<String, String> result = new HashMap<>(4);
        result.put("asdf", "as123");
        return result;
    }
}
