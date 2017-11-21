package test.page;

import com.hjc.cooperation.medical.persistence.dao.CooperativeBaseInfoMapper;
import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-dao.xml","classpath*:spring-mvc.xml"})
public class PageTest {
    @Autowired
    private CooperativeBaseInfoMapper cooperativeBaseInfoMapper;

    @Test
    public void listTest(){
        Map<String, String> map = new HashMap<>();
        map.put("id","54d1ce590568429286fbd3b6c005cce7");
        List<CooperativeBaseInfo> list = cooperativeBaseInfoMapper.listCooperativeBaseInfo(map);
        Pageable pageable = new PageRequest(0,10);
        for (CooperativeBaseInfo temp : list) {
            System.out.println(temp.getName());
        }
    }
}
