package test;

import com.hjc.common.util.http.HttpClientOperate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @author : Administrator
 * @date : 2018/7/17 0017 14:35
 * @description : 测试http pool
 */
public class MyHttpTest extends BaseJunit4Test {

    @Autowired
    private HttpClientOperate httpClientOperate;

    @Test
    public void test() {
        try {
            System.out.println(httpClientOperate.doGet("http://www.baidu.com"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
