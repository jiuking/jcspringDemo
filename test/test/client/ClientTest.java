package test.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class ClientTest {
    @Test
    public void test(){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://github.com/");
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJson(){
        Map map = new HashMap();
        map.put("A","1A");
        map.put("B","1B");
        JSONObject jsonObject1 = new JSONObject();
        String json = JSON.toJSONString(map);
        JSONObject object = JSONObject.parseObject(json);
        System.out.println(object.toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sd","asdf");
        jsonObject.put("sa","23");
        System.out.println(jsonObject.toJSONString());
    }
}
