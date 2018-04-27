package com.hjc.index.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @Author: HJC
 * @Description: 测试validate参数校验类Entity
 * @param: null
 * @Date: 14:20 2018/4/27 0027
 * @return:
 * @throws:
 */
public class ValidateEntity {

    @Getter
    @Setter
    @Size(min = 1,max = 3,message = "长度必须在1和3之间")
    private String msg;

    @Getter
    @Setter
    @NotNull(message = "status不能为NULL。")
    private String status;

    @Getter
    @Setter
    private String body;
}
