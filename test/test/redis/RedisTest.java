package test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;

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
}
