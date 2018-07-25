package com.hjc.aop.object;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : Administrator
 * @date : 2018/7/24 0024 16:42
 * @description :
 */
public class PeopleTalk implements ITalk {

    @Setter
    @Getter
    private String username;

    @Getter
    @Setter
    private String age;

    @Override
    public void talk(String msg) {
        System.out.println(msg + "!你好，我是" + username + ",今的年龄是" + age);
        speak(msg);
    }

    @Override
    public void speak(String msg) {
        System.out.println("speak msg:"+msg);
    }
}
