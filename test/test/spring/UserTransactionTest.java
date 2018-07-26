package test.spring;

import com.hjc.spring.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseJunit4Test;

/**
 * @author : Administrator
 * @date : 2018/7/26 0026 15:06
 * @description : 测试事务
 */
public class UserTransactionTest extends BaseJunit4Test {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception{
        userService.insertRequest();
    }
}
