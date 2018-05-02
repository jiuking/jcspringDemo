package com.hjc.index.controller;

import com.hjc.index.annotation.LogAdvice;
import com.hjc.index.entity.ValidateEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: HJC
 * @Description: 校验参数类测试
 * @param: null
 * @Date: 14:22 2018/4/27 0027
 * @return:
 * @throws:
 */
@RestController
public class TestController {

    @RequestMapping("/validateTest")
    public Object validatedTest(@Validated @RequestBody ValidateEntity validateEntity, BindingResult bindingResult) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("msg", "成功！");
        StringBuffer sb = new StringBuffer();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError err : errors) {
                sb.append(err.getDefaultMessage() + ";  ");
            }
            map.put("msg", sb.toString());
        }
        map.put("data", bindingResult.getAllErrors());
        return map;
    }

    @RequestMapping("/AopTest")
    @LogAdvice(type = LogAdvice.Type.SECOND)
    public Object aopTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "success");
        map.put("msg", "成功！");
        return map;
    }
}
