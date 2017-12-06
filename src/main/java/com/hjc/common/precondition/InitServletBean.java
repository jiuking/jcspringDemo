package com.hjc.common.precondition;

import com.hjc.common.util.SpringContextHolder;
import com.hjc.spring.persistence.dao.UserMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;

public class InitServletBean implements InitializingBean {
    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private RedisTemplate redisTemplate = SpringContextHolder.getBean(RedisTemplate.class);
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("启动时查询数据库数据并存储至redis中：" + userMapper.selectByPrimaryKey(1).getUserName());
        redisTemplate.opsForValue().set("a", "张三");
        System.out.println(redisTemplate.boundValueOps("a").get());
    }

}
