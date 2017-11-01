package test.threadpool;

import java.util.concurrent.ExecutorService;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
public class ExecutorServiceFactory {
    private static final ExecutorServiceFactory executorServiceFactory = new ExecutorServiceFactory();

    private ExecutorService executorService;

    private ExecutorServiceFactory(){

    }

    public static ExecutorServiceFactory getInstance(){
        return executorServiceFactory;
    }

}
