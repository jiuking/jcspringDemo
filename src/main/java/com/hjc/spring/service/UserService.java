package com.hjc.spring.service;

import com.hjc.spring.persistence.entity.User;

public interface UserService {
    int update(User user);
    int insert(User user);
    void test() throws Exception;
}
