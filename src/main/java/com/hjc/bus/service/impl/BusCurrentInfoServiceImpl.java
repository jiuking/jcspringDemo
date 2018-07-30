package com.hjc.bus.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjc.bus.service.BusCurrentInfoService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Administrator
 * @date : 2018/7/27 0027 17:03
 * @description : 公交实时查询service实现类
 */
@Service
public class BusCurrentInfoServiceImpl implements BusCurrentInfoService {

    private static final Logger logger = LoggerFactory.getLogger(BusCurrentInfoServiceImpl.class);


    @Override
    public String getBusCurrentInfo(String busNo, String lineType) throws IOException {
        StringBuilder url = new StringBuilder();
        StringBuilder resultMsg_ = new StringBuilder();
        StringBuilder resultMsg_temp = new StringBuilder();
        url.append("http://m.basbus.cn/ssgj/m_search?").append("id=").append(busNo).append("&linetype=").append(lineType);
        logger.info("url:"+url.toString());
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url.toString());
        CloseableHttpResponse response = httpCilent.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            response.close();
        }
        Document doc = Jsoup.parse(result);
        Elements elements = doc.select("img");
        for (Element el : elements) {
            Element parent = el.parent().parent();
            logger.info(parent.text());
            resultMsg_temp.append("\r\n").append(parent.text());
        }
        Element startStand = doc.selectFirst("div.left");
        if (startStand == null) {
            logger.info("查询不到该路线");
            return "查询不到该路线";
        }
        Element endStand = doc.selectFirst("div.right");
        logger.info(startStand.text() + "--->" + endStand.text());
        resultMsg_.append(startStand.text()).append("---->").append(endStand.text()).append(resultMsg_temp);
        return resultMsg_.toString();
    }

    public String allBusStand(String busNo,String lineType) throws URISyntaxException, IOException {
        String url = "http://m.basbus.cn/SSGJ/GetBusLineDetail";
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        HttpPost request = new HttpPost();
        request.setURI(new URI(url));
        List<NameValuePair> nvps = new ArrayList<>(4);
        nvps.add(new BasicNameValuePair("line", busNo));
        nvps.add(new BasicNameValuePair("type", lineType));
        request.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
        CloseableHttpResponse response = httpCilent.execute(request);
        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
            return "查询无该公交！";
        }
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "utf-8");
        JSONObject jsonObject = JSON.parseObject(result);
        StringBuilder stringBuilder = new StringBuilder();
        List<JSONObject> list = (List<JSONObject>) jsonObject.get("list");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get("station"));
            stringBuilder.append(list.get(i).get("station")).append(i).append(" ");
        }
        return stringBuilder.toString();
    }
}
