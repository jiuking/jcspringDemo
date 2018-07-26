package com.hjc.spring.service;

import com.hjc.spring.persistence.entity.User;

public interface UserServiceCopy {
    int update(User user);
    int insert(User user);
    void test() throws Exception;
    User get();

    int insertRequest();

    int insertRequires_New();
}
