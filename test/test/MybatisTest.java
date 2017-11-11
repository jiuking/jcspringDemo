package test;

import com.hjc.spring.persistence.dao.UserMapper;
import com.hjc.spring.persistence.entity.User;
import com.hjc.spring.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/10 0010.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-dao.xml"})
public class MybatisTest {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;
    private static final Logger logger = Logger.getLogger(MybatisTest.class);

    @Test
    public void test() throws Exception{
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUserName());
        logger.info(user.getPassword());

        userService.test();

    }

}
