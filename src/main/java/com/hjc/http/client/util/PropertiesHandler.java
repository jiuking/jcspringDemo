package com.hjc.http.client.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author : Administrator
 * @date : 2018/7/12 0012 16:03
 * @description : 获取
 */
public class PropertiesHandler {

    public static String getPropertiesValue(String url,String key) {
        Resource resource = new ClassPathResource(url);
//        properties = ResourceBundle.getBundle(url); 获取不到对应的问题
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            return props.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 暂无存在resource根目录下的properties文件。暂时弃用该方法
     * @param url
     * @param key
     * @return
     */
    @Deprecated
    public static String getClassPropertiesValue(String url,String key) {
        //获取不到对应的问题
        ResourceBundle properties = ResourceBundle.getBundle(url);
        return properties.getString(key);
    }
}
