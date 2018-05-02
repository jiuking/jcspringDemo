package com.hjc.index.util;

import com.hjc.index.annotation.LogAdvice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: Hjc
 * @Description: 面向切面AOP
 * @param: null
 * @Date: 14:55 2018/5/2 0002
 * @return:
 * @throws:
 */
@Aspect
@Component
public class MyInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);

    @Pointcut("execution(* com.hjc.index.controller.TestController.aopTest(..))")
    public void pointCut() {
    }

    @Before("execution(* com.hjc.index.controller.TestController.aopTest(..))")
    public void before() {
        log.info("直接开始");
    }

    @Before("pointCut()")
    public void before1() {
        log.info("借助方法开始");
    }

    @After("pointCut()")
    public void after() {
        log.info("借助方法之后");
    }

    @Around("pointCut() && @annotation(logAdvice)")
    public Object around(ProceedingJoinPoint joinPoint, LogAdvice logAdvice) throws Throwable {
        log.info("方法环绕之前" + logAdvice.type().getValue());
        Object object = joinPoint.proceed();
        log.info("方法环绕之后");
        return object;
    }

    @AfterThrowing(throwing = "e")
    public void throwException(Throwable e) {
        log.info(e.getMessage());
    }
}
