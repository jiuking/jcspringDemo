package com.hjc.http.client.util;

import java.util.ResourceBundle;

/**
 * @author : Administrator
 * @date : 2018/7/12 0012 16:03
 * @description : 获取
 */
public class PropertiesHandler {

    public static ResourceBundle properties = null;

    public static String getPropertiesValue(String url,String key) {
        properties = ResourceBundle.getBundle(url);
        return properties.getString(key);
    }

}
