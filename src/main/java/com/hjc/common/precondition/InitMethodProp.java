package com.hjc.common.precondition;

import com.hjc.common.util.SpringContextHolder;
import com.hjc.spring.persistence.dao.UserMapper;
import org.springframework.data.redis.core.RedisTemplate;

public class InitMethodProp {

    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

    private RedisTemplate redisTemplate = SpringContextHolder.getBean(RedisTemplate.class);
    public void init() {
        System.out.println("启动时初始化："+userMapper.selectByPrimaryKey(1).getUserName());
        System.out.println("test:"+redisTemplate.boundValueOps("a").get());
    }
}
