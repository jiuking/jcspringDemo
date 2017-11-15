package com.hjc.common.util;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
public final class Constants {
    public static final String REGEXSTR = "^-?\\d+$";

    public static void main(String[] args) {
        System.out.println("13445".matches(REGEXSTR));
    }
}
