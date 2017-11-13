package com.hjc.common.util;

import java.util.UUID;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public final class UUIDUtil {

    private UUIDUtil(){

    }

    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        System.out.println(generateUUID().length());
    }
}
