package com.hjc.common.util.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("httpClientOperate")
public class HttpClientOperate implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Autowired(required = false)
    private RequestConfig requestConfig;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    private CloseableHttpClient getHttpClient(){
        return this.beanFactory.getBean(CloseableHttpClient.class);
    }
    /**
     * @Author: hjc
     * @Description: TODO
     * @param: url
     * @Date: 16:12 2017/11/17 0017
     * @return: java.lang.String
     * @throws: IOException
     */
    public String doGet(String url) throws IOException {
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);//设置请求参数
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = this.getHttpClient().execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

    public void testComent(String as,String ae,String a) throws Exception{

    }
}
