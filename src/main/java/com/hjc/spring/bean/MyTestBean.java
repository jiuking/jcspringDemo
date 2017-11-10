package com.hjc.spring.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/11/1 0001.
 */
public class MyTestBean {
    @Getter
    @Setter
    private String testStr = "testStr";

    @Setter
    @Getter
    private NestedBean netsted;
}
