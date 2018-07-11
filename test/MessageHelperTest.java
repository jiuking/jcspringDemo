import com.hjc.activeme.util.MessageHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Administrator
 * @date : 2018/7/10 0010 17:45
 * @description :
 */
public class MessageHelperTest extends BaseJunit4Test {

    @Autowired
    private Destination tttQueueDestination;

    @Test
    public void enqueuedTest() throws InterruptedException {
        Map<String, Object> map = new HashMap<>();
        map.put("test1","Tom");
        for (int i = 0; i < 10000000; i++) {
            MessageHelper.sendMessage(tttQueueDestination,map,"processor11"+i);
            Thread.sleep(1000);
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                map.put("test1", "tom");
                MessageHelper.sendMessage(tttQueueDestination, map, "processor1");
                }
            }).start();
        }
    }

    @Test
    public void dequeuedTest() {
//        MessageHelper
    }
}
