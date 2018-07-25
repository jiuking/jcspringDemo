package com.hjc.aop.object;

/**
 * @author hjc
 * aspectJ 切面对象
 */
public class Hello {

    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        new Hello().sayHello();
    }
}
