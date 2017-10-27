package com.hjc.spring.test.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
@Accessors(chain = true)
@Getter
@Setter
public class PersonEntity {
    private String name;
    private String password;
}
