package com.hjc.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;

/**
 * @author : Administrator
 * @date : 2018/6/29 0029 10:14
 * @description : JSON数据格式转换
 */
public class JSONUtils {

    /**
             * 将对象的大写转换为下划线加小写，例如：userName-->user_name
    *
            * @param object
  * @return
          * @throws JsonProcessingException
     */
            public static String toUnderlineJSONString(Object object) throws JsonProcessingException {
                 ObjectMapper mapper = new ObjectMapper();
                mapper.setPropertyNamingStrategy(PropertyNamingStrategy.PASCAL_CASE_TO_CAMEL_CASE);
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                 String reqJson = mapper.writeValueAsString(object);
                 return reqJson;
            }
    /**
     * 将下划线转换为驼峰的形式，例如：user_name-->userName
     *
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T toSnakeObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.PASCAL_CASE_TO_CAMEL_CASE);
        T reqJson = mapper.readValue(json, clazz);
        return reqJson;
    }
}
