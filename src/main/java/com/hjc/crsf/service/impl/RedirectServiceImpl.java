package com.hjc.crsf.service.impl;

import com.hjc.crsf.service.RedirectService;
import com.hjc.http.client.util.HttpClientPoolUtil;
import org.springframework.stereotype.Service;

/**
 * @author : Administrator
 * @date : 2018/7/16 0016 10:36
 * @description : 重定向service类
 */
@Service
public class RedirectServiceImpl implements RedirectService {


    @Override
    public Object redirectUrlContent(String url) {
        Object obj = null;
        try {
            System.out.println("abc");
            HttpClientPoolUtil httpClientPoolUtil = new HttpClientPoolUtil();
            obj = HttpClientPoolUtil.execute(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
