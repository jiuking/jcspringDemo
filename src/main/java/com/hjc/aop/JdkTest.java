package com.hjc.aop;

import com.hjc.aop.object.ITalk;
import com.hjc.aop.object.PeopleTalk;
import sun.misc.ProxyGenerator;

import java.lang.reflect.Proxy;

/**
 * @author : Hjc
 * @date : 2018/7/24 0024 16:53
 * @description : jdk面向切面
 *
 * -javaagent:E:\customagent\out\artifacts\customagent_jar\customagent.jar 添加到vm参数可对应生成class文件
 * 或者System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");查看源代码可知，也可产生class文件。
 * System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true); 也可
 * vm配置-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true测试也可以效果
 */
public class JdkTest {
    public static void main(String[] args) {
//        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ITalk talk = (ITalk) new DynamicProxy().bind(new PeopleTalk());
        System.out.println(talk instanceof Proxy);
        talk.talk("业务说明");
    }
}
