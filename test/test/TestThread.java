package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.threadpool.ExecutorServiceFactory;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2017/10/31 0031.
 * 测试多线程，及线程池
 */
public class TestThread {
    private static final Logger logger = LoggerFactory.getLogger(TestThread.class);
    @Test
    public void testThread1(){
        new SingleThread().start();
    }
    private class SingleThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                logger.info("线程"+i);
            }
        }
    }

    @Test
    public void testDA(){
        final int COUNT_BITS = Integer.SIZE - 3;
        final int CAPACITY   = (1 << COUNT_BITS) - 1;
        final int RUNNING    = -1 << COUNT_BITS;
        final int SHUTDOWN   =  0 << COUNT_BITS;
        final int STOP       =  1 << COUNT_BITS;
        final int TIDYING    =  2 << COUNT_BITS;
        final int TERMINATED =  3 << COUNT_BITS;
        System.out.println(COUNT_BITS);
        System.out.println(-1 << COUNT_BITS);
        System.out.println(1 << COUNT_BITS);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(CAPACITY);
        System.out.println(~CAPACITY);
        System.out.println(RUNNING|0);
    }

    @Test
    public void testPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Task("a"));
        executorService.execute(new Task("b"));
        executorService.execute(new Task("c"));

        executorService.execute(new Task("d"));
        executorService.execute(new Task("e"));
        executorService.execute(new Task("f"));
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("Thread pool is over");
    }

    @Test
    public void testThread(){
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        }.start();
    }


    static class Task implements Runnable{
        private String id;
        Task(String id){
            this.id = id;
        }
        @Override
        public void run() {
            System.out.println("Thread "+id+" is working");
            try {
                //每个任务随机延时1s以内的时间以模拟线程的运行
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread "+id+" over");
        }
    }
}
