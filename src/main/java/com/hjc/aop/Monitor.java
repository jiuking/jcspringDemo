package com.hjc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Monitor {
    @Pointcut("execution(* hello())")
    public void excute(){

    }
    @Before("excute()")
    public void beforedo(){
        System.out.println("before");
    }
}
