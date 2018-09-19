import java.util.concurrent.*;

public class TestCountDownLatch {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int j = 0; j < 5; j++) {
            CountDownLatch countDownLatch = new CountDownLatch(5);
            System.out.println("线程j:"+j+countDownLatch.getCount());

            //测试阻塞其他线程
//        new Thread(new MyRunnable(countDownLatch)).start();
            //为了测试效果进行线程休眠
            Thread.sleep(1000);
            for (int i = 1; i <= 5; i++) {
                System.out.println("第" + i + "调用countDown方法结束");
                executor.execute(new MyRunnable(countDownLatch));

                //为了测试效果进行线程休眠
//            Thread.sleep(1000);
            }
            //对于CountDownLatch来说，重点是那个“一个线程”,是它在等待，
            // 而另外那N的线程在把“某个事情”做完之后可以继续等待，可以终止。
            // 而对于CyclicBarrier来说，重点是那N个线程，他们之间任何一个没有完成，
            // 所有的线程都必须等待。
            //充分说明CountDownLatch中线程做完事情后，未等待还可以做新进来的事情
            //可能执行结果:
            //先打印----线程挚馨尪痹
            //后打印---新的线程111
            executor.execute(() -> {
                System.out.println("新的线程111");
            });
            countDownLatch.await();
            System.out.println(countDownLatch.getCount());
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
class MyRunnable implements Runnable {
    CountDownLatch countDownLatch;
    public MyRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("线程执行尪痹..."+Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}
