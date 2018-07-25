package com.hjc.aop;

/**
 * https://www.jianshu.com/p/aa293edba2e4
 * http://www.coozhi.com/youxishuma/g4/33884.html
 * https://blog.csdn.net/xqj198404/article/details/77651768
 * -javaagent:pathto/aspectjweaver.jar
 */
public aspect TxAspect {
    void around():call(void com.hjc.aop.object.Hello.sayHello()){
        System.out.println("开始事务。。。");
        proceed();
        System.out.println("结束事务。。。");
    }
}
