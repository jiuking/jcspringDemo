package test.thread;

import org.junit.Test;

public class FalseDemoThread {

    private Object object = new Object();

    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            System.out.println(System.currentTimeMillis()-start);
        }

    }

    private class FalseDemo implements Runnable{
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        final FalseDemoThread f = new FalseDemoThread();
            new Thread(){
                @Override
                public void run() {
                    f.test3();
                }
            }.start();
            new Thread(){
                @Override
                public void run() {
                    f.test4();
                }
            }.start();
            new Thread(){
                @Override
                public void run() {
                    f.test1();
                }
            }.start();
    }

    public synchronized void test1() {
        for (int i = 0; i < 100; i++) {
            System.out.println("a"+i);
        }
    }

    public synchronized void test2() {
        for (int i = 101; i < 200; i++) {
            System.out.println("b       "+i);
        }
    }

    public void test3() {
        synchronized (object) {
            for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);
            }
        }
    }

    public void test4() {
        synchronized (object) {
            for (int i = 100; i < 200; i++) {
                System.out.println("B     " + i);
            }
        }
    }
}



