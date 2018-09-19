import java.util.concurrent.*;

public class TestCyclicBarrier {
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(5);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int j = 0; j < 4; j++) {
            barrier.reset();
            System.out.println("线程j:"+j+barrier.getNumberWaiting());

            //测试阻塞其他线程
//        new Thread(new MyRunnable(countDownLatch)).start();
            //为了测试效果进行线程休眠
            Thread.sleep(1000);
            for (int i = 1; i <= 4; i++) {
                System.out.println("第" + i + "调用countDown方法结束");
                executor.execute(new MyRunnale1(barrier));

                //为了测试效果进行线程休眠
//            Thread.sleep(1000);
            }
            System.out.println("等刀气"+barrier.getNumberWaiting());
            barrier.await();
            System.out.println(barrier.getNumberWaiting());
            System.out.println("线程挚馨尪痹");
            /*executor.execute(() -> {
                System.out.println("新的线程111");
            });*/


        }
        executor.shutdown();
        /*
		 * 测试阻塞主线程

		for (int i = 1; i <= 5; i++) {
			new Thread(new MyRunnable1(countDownLatch,i+"")).start();
			Thread.sleep(1000);
		}
		try {
			System.out.println("主线程阻塞");
			countDownLatch.await();
			System.out.println("主线程继续执行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} */
    }
}
class MyRunnale1 implements Runnable{
    private CyclicBarrier cyclicBarrier;
    private String mark;
    public MyRunnale1(CyclicBarrier cyclicBarrier) {
        super();
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"进入线程,线程阻塞中...");
        try {
            // barrier的await方法，在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
            cyclicBarrier.await();
//            Thread.sleep(2000);//为了看到更好的效果，线程阻塞两秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(mark+"线程阻塞结束,继续执行...");

    }
    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }
    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
}
