package test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml","classpath:spring-redis.xml","classpath:spring-mvc.xml"})
//@ContextConfiguration(locations = {"classpath:spring-*.xml"}) “*”有问题
public class RedisTest {

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    @Test
    public void test() {
        System.out.println("test:"+redisTemplate.boundValueOps("a").get());
    }

    @Test
    public void test1() {
        Class clazz = String.class;
        System.out.println(clazz);
        System.out.println(clazz.getClass());
//        clazz.cast(String.class);
    }

    @Test
    public void test2() {
        ListOperations list = redisTemplate.opsForList();
        list.leftPushAll("key", new ArrayList());
    }
}
