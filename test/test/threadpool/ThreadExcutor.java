package test.threadpool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadExcutor {

    private volatile boolean running = true;

    //添加线程到BlockingQueue
    private static BlockingQueue<Runnable> queue = null;

    private final Set<Worker> workers = new HashSet<>();

    private final List<Thread> threadList = new ArrayList<>();

    //工作线程
    int poolSize = 0;

    //核心线程
    int coreSize = 0;

    boolean shutdown = false;

    public ThreadExcutor() {

    }

    public ThreadExcutor(int poolSize) {
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<>(poolSize);
    }

    public void exec(Runnable runnable) {
        if (runnable == null)
            throw new NullPointerException();
        if (coreSize < poolSize){
            addThread(runnable);
        }else {
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("poolSize:"+poolSize+"coreSize:"+coreSize);
    }

    private void addThread(Runnable runnable) {
        coreSize ++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread t = new Thread(worker);
        threadList.add(t);
        try {
            t.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void shutdown() {
        running = false;
        if(!workers.isEmpty()){
            for (Worker worker : workers){
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }

    class Worker implements Runnable {

        public Worker(Runnable runnable) {
            queue.offer(runnable);
        }

        @Override
        public void run() {
            while (true && running){
                if(shutdown == true){
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void interruptIfIdle() {
            for (Thread t : threadList) {
                t.interrupt();
            }
        }

        public Runnable getTask() throws InterruptedException {
            return queue.take();
        }
    }
}
