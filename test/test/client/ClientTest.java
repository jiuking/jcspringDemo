package test.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class ClientTest {
    @Test
    public void test(){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://github.com/");
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            System.out.printf(response.getEntity().getContent().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
