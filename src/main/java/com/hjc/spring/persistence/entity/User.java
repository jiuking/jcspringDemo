package com.hjc.spring.persistence.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;

    private String userName;

    private String password;

    private Integer age;

}