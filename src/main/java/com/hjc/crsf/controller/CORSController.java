package com.hjc.crsf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Administrator
 * @date : 2018/7/13 0013 16:55
 * @description : cors跨越controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cors")
public class CORSController {

    @RequestMapping("/index")
    public Object corsIndex() {
        Map<String, String> map = new HashMap<>(4);
        map.put("test", "test1111");
        return map;
    }
}
