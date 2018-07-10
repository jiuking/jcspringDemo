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
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("test1","Tom");
        MessageHelper.sendMessage(tttQueueDestination,map,"processor11");
    }
}
