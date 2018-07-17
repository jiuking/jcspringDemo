package com.hjc.crsf.controller;

import com.hjc.common.util.http.HttpClientOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Administrator
 * @date : 2018/7/13 0013 16:55
 * @description : cors跨越controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
@Controller
@RequestMapping("/cors")
public class CORSController {

    @Autowired
    private HttpClientOperate httpClientOperate;

    @RequestMapping("/index")
    public Object corsIndex(HttpServletResponse response) throws IOException {
        Map<String, String> map = new HashMap<>(4);
        map.put("test", "test1111");
//        return map;
        return "index";
    }

    @RequestMapping("/index1")
    public void corsIndex1(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(httpClientOperate.doGet("http://www.360.com"));
    }
}
