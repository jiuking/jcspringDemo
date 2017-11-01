package test.threadpool;

/**
 * Created by Administrator on 2017/10/31 0031.
 * 模拟线程池实现：
 * 线程池状态以及获取线程池状态方法
 * 线程池添加捞取线程执行
 */
public class ThreadPoolDemo {

    Thread t = new Thread();
    private static final int COUNT_BITS = Integer.SIZE - 3;
    //默认线程池大小
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    //线程池状态
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    private boolean isRunning(int c){
        return c < SHUTDOWN;
    }
}
