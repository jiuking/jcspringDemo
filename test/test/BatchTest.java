package test;

import com.hjc.cooperation.medical.persistence.dao.CooperativeBaseInfoMapper;
import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-dao.xml","classpath*:spring-mvc.xml"})
public class BatchTest{

    private static final Logger log = LoggerFactory.getLogger(BatchTest.class);

    @Autowired
    private CooperativeBaseInfoMapper cooperativeBaseInfoMapper;

    @Test
    public void test(){
        CooperativeBaseInfo c1 = new CooperativeBaseInfo();
        c1.setId("1");
        c1.setName("张三");
        c1.setAge(12);
        c1.setCompensateAmount(new BigDecimal(4.5));
        c1.setCooperativeNo("sdfas12");
        c1.setGender(1);
        c1.setInvoiceNo("12asd");
        c1.setVisitorDate("2017-01-01");
        CooperativeBaseInfo c2 = new CooperativeBaseInfo();
        c2.setId("2");
        c2.setName("张三");
        c2.setAge(12);
        c2.setCompensateAmount(new BigDecimal(4.5));
        c2.setCooperativeNo("sdfas12");
        c2.setGender(1);
        c2.setInvoiceNo("12asd");
        c2.setVisitorDate("2017-01-01");
        List<CooperativeBaseInfo> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        cooperativeBaseInfoMapper.batchBindCooperativeBaseInfos(list);
        log.info("asd");
    }

}
