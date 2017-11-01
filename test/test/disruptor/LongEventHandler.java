package test.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
