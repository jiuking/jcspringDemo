package test.thread;

import org.junit.Test;
import test.bean.AuditUser;
import test.collection.ObjectQueueUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConCurrentQueueThreadTest {


    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 100000; i++) {

            final AuditUser user = new AuditUser();
            user.setId("A"+i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ObjectQueueUtil.getInstance().offer(user);
                    System.out.println("入栈");
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    AuditUser user = (AuditUser) ObjectQueueUtil.getInstance().poll();
                    System.out.println("出栈"+user.getId());
                }
            }).start();
        }
    }

    @Test
    public void test1() {
        Object obj = ObjectQueueUtil.getInstance().poll();
        if (obj == null) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                // task to run goes here
                try {
                    new ConCurrentQueueThreadTest().test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }
}

