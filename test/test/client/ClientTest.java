package test.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.MapMaker;
import com.hjc.common.util.StringUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class ClientTest {
    @Test
    public void test(){
        String uri = "http://github.com";
        System.out.println(doGet(uri));
    }

    @Test
    public void testHttpClientGetJson(){
        String uri = "http://localhost:8081/hjcspring/json";
        String result = doGet(uri);
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject.toJSONString());
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

    private String doGet(String uri){
        if (StringUtil.isEmpty(uri)){
            throw new IllegalArgumentException("输入参数非法！"+uri);
        }
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpClient client = HttpClients.createDefault();
        String result = null;
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return result;

    }
}
