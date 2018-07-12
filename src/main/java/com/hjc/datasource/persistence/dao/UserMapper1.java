package com.hjc.datasource.persistence.dao;


import com.hjc.datasource.persistence.entity.User;

public interface UserMapper1 {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}