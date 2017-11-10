package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/11/10 0010.
 */
@ContextConfiguration({"classpath:/conf/log4j.properties"})
public class FastJsonTest {
    private static final Logger logger = Logger.getLogger(FastJsonTest.class);
    @Test
    public void fastJsonTest(){
        HashMap<String,String> map = new HashMap<>();
        map.put("name","Tom");
        map.put("age","18");
        map.put("gender",null);
        String json = JSON.toJSONString(map,SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(json);
        FastJsonTestBean fastJsonTestBean = new FastJsonTestBean();
        fastJsonTestBean.setName("Jerry");
        fastJsonTestBean.setAge("18");
        System.out.println(JSON.toJSONString(fastJsonTestBean,SerializerFeature.WriteNullStringAsEmpty));
        logger.info("asdf");
    }
}
