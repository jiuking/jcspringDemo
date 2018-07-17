package test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/11/1 0001.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-redis.xml","classpath:applicationContext.xml","classpath:spring-httpclient.xml",
        "classpath:spring-dao.xml","classpath:ActiveMQ.xml"})
public class BaseJunit4Test {

}
