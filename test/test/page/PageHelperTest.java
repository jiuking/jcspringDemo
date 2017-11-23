package test.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjc.common.util.page.Page;
import com.hjc.common.util.page.PageEntity;
import com.hjc.cooperation.medical.persistence.dao.CooperativeBaseInfoMapper;
import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import com.hjc.cooperation.medical.service.CooperateService;
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
@ContextConfiguration(locations = {"classpath*:spring-dao.xml","classpath*:spring-mvc.xml","classpath*:spring-redis.xml"})
public class PageHelperTest {

    private final static Logger log = LoggerFactory.getLogger(PageHelperTest.class);

    @Autowired
    private CooperativeBaseInfoMapper cooperativeBaseInfoMapper;

    @Autowired
    private CooperateService cooperateService;

    @Test
    public void test() {
        PageHelper.startPage(20, 10);
        List<CooperativeBaseInfo> list = cooperativeBaseInfoMapper.listCooperativeBaseInfo(new HashMap<String, String>());
        for (CooperativeBaseInfo temp : list) {
            log.info(temp.getName());
        }
    }

    @Test
    public void testHelper() {
        PageEntity pageEntity = new PageEntity();
        pageEntity.setPageSize(10);
        pageEntity.setPageNum(1);
        PageInfo<CooperativeBaseInfo> list =  cooperateService.list(new HashMap<String, String>(),pageEntity );
        for (CooperativeBaseInfo temp : list.getList() ) {
            System.out.println(temp.getName());
        }
    }

    @Test
    public void alig() {
        System.out.println(40%10);
    }
}
