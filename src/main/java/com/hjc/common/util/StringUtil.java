package com.hjc.common.util;

public final class StringUtil {
    public static boolean isEmpty(String s){
        if (s == null || s.trim().isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}
