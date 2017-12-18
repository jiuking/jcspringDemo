package test.collection;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: Administrator
 * @Description: 单列模式多线程队列
 * @Date: 13:17 2017/12/18 0018
 */
public class ObjectQueueUtil<T> {

    private final ConcurrentLinkedQueue<T> queue = new ConcurrentLinkedQueue();

    private ObjectQueueUtil() {

    }
    /**
     * @Author: Administrator
     * @Description: 入队列
     * @param: t 入队列对象类
     * @Date: 13:16 2017/12/18 0018
     * @return: Boolean
     */
    public boolean offer(T t) {
        return queue.offer(t);
    }

    public boolean addAll(Collection<T> t){
        return queue.addAll(t);
    }

    public int size() {
        return queue.size();
    }

    /**
     * @Author: Administrator
     * @Description: 出队列
     * @Date: 13:16 2017/12/18 0018
     * @return: T 对象
     */
    public T poll() {
        return queue.poll();
    }

    public T peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
    /**
     * @Author: Administrator
     * @Description: 移除指定对象
     * @param: t 待移除对象
     * @Date: 13:16 2017/12/18 0018
     * @return: boolean
     */
    public boolean remove(T t) {
        return queue.remove(t);
    }

    private static class UtilHolder{
        private static final ObjectQueueUtil INSTANCE = new ObjectQueueUtil();
    }

    public static ObjectQueueUtil getInstance() {
        return UtilHolder.INSTANCE;
    }
}
