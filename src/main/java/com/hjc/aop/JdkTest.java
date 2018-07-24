package com.hjc.aop;

import com.hjc.aop.object.ITalk;
import com.hjc.aop.object.PeopleTalk;

/**
 * @author : Administrator
 * @date : 2018/7/24 0024 16:53
 * @description : jdk面向切面
 */
public class JdkTest {
    public static void main(String[] args) {
        ITalk talk = (ITalk) new DynamicProxy().bind(new PeopleTalk());
        talk.talk("业务说明");
    }
}
