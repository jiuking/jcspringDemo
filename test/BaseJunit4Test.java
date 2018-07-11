import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : Administrator
 * @date : 2018/7/10 0010 17:47
 * @description : base基础Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-redis.xml","classpath:spring-dao.xml","classpath:spring-mvc.xml","classpath:ActiveMQ.xml"}) //加载配置文件
public class BaseJunit4Test {
}
