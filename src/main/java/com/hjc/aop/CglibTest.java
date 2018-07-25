package com.hjc.aop;

import com.hjc.aop.object.CglibPeopleTalk;

/**
 * @author : Administrator
 * @date : 2018/7/25 0025 14:47
 * @description : cglib测试类
 */
public class CglibTest {
    public static void main(String[] args) {
        CglibPeopleTalk peopleTalk = (CglibPeopleTalk) new CglibProxy().getInstance(new CglibPeopleTalk());
        peopleTalk.talk("业务方法",peopleTalk);
//        peopleTalk.speak("业务方法");
    }
}
