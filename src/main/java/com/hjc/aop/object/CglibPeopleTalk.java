package com.hjc.aop.object;

/**
 * @author : Hjc
 * @date : 2018/7/25 0025 14:41
 * @description : 没有实现ITalk的类
 */
public class CglibPeopleTalk {
    public void talk(String msg,CglibPeopleTalk cglibPeopleTalk) {
        System.out.println("people talk:" + msg);
        cglibPeopleTalk.speak(msg);
    }

    public void speak(String msg) {
        System.out.println("people speak："+msg);
    }
}
