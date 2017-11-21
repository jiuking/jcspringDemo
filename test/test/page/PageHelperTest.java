package test.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjc.cooperation.medical.persistence.dao.CooperativeBaseInfoMapper;
import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-dao.xml","classpath*:spring-mvc.xml"})
public class PageHelperTest {

    private final static Logger log = LoggerFactory.getLogger(PageHelperTest.class);

    @Autowired
    private CooperativeBaseInfoMapper cooperativeBaseInfoMapper;

    @Test
    public void test() {
        PageHelper.startPage(10, 10);
        List<CooperativeBaseInfo> list = cooperativeBaseInfoMapper.listCooperativeBaseInfo(new HashMap<String, String>());
        for (CooperativeBaseInfo temp : list) {
            log.info(temp.getName());
        }
    }
}
