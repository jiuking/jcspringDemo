import com.hjc.datasource.DataSourceSwitcher;
import com.hjc.datasource.persistence.dao.UserMapper1;
import com.hjc.spring.persistence.dao.UserMapper;
import com.hjc.spring.persistence.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Administrator
 * @date : 2018/7/12 0012 17:31
 * @description : 多重数据源测试
 */
public class MultipleDataSourceTest extends BaseJunit4Test {

    @Autowired
    private UserMapper userSpringMapper;

    @Autowired
    private UserMapper1 userDataSourceMapper;

    @Test
    public void test() {
        DataSourceSwitcher.setDataSourceKey("ds1");
        User user = new User();
        user.setId(3);
        user.setAge(23);
        user.setUserName("张三");
        user.setPassword("123");
        userSpringMapper.insert(user);

        DataSourceSwitcher.setDataSourceKey("ds2");
        com.hjc.datasource.persistence.entity.User user1 = new com.hjc.datasource.persistence.entity.User();
        user1.setId(4);
        user1.setAge(24);
        user1.setUserName("李四");
        user1.setPassword("sadf1");
        userDataSourceMapper.insert(user1);
    }
}
