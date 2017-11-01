package test.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
