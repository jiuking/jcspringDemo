package test.thread;

import org.junit.Test;

public class FalseDemoThread {
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

    private class falseDemo implements Runnable{
        @Override
        public void run() {

        }
    }
}
