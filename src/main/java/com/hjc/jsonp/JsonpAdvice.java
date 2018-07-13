package com.hjc.jsonp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * @author : Administrator
 * @date : 2018/7/13 0013 17:35
 * @description : jsonp controller advice
 */
@ControllerAdvice(basePackages = "com.hjc.jsonp.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {
        super("callback", "jsonp");
    }
}
