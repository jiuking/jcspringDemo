package com.hjc.aop;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : Administrator
 * @date : 2018/7/25 0025 13:43
 * @description : 使用cglib动态代理
 * MethodInterceptor主要的方法拦截类，它是Callback接口的子接口，需要用户实现
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        //Enhancer 主要的增强类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    /**
     * MethodProxy :JDK的java.lang.reflect.Method类的代理类，可以方便的实现对源对象方法的调用,
     * @param proxy
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始");
        Object result = methodProxy.invoke(target, args);
        System.out.println("事务结束");
        return result;
    }
}
