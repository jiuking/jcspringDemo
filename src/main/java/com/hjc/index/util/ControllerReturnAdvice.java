package com.hjc.index.util;

import com.hjc.index.entity.ValidateEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 * @Author: HJC
 * @Description: Controller切面
 * @param: null
 * @Date: 17:53 2018/4/27 0027
 * @return:
 * @throws:
 */
@ControllerAdvice
public class ControllerReturnAdvice {

    @ExceptionHandler(Exception.class)
    public Object returnErrorMsg(Exception e) {
        return "error";
    }

    @ModelAttribute
    public Object modelAttribute() {
        System.out.println("返回测试");
        return new ValidateEntity();
    }

    @InitBinder
    public Object initBiinder() {
        System.out.println("绑定测试");
        return null;
    }
}
