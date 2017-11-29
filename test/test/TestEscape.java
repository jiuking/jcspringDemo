package test;

import java.util.EventListener;

public class TestEscape extends Thread{
    public TestEscape() {
        doSomething(new InnerClass());
    }

    public void doSomething(InnerClass innerClass) {
        innerClass.doSomething();
    }

    @Override
    public void run() {
        new TestEscape();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new TestEscape().start();
        }
    }

    class InnerClass extends Thread{
        public void doSomething() {
            System.out.println("1234");
        }
    }
}
