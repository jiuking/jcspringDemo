package test;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/10/27 0027.
 */
public class TestGuava {
    private static Logger logger = Logger.getLogger(TestGuava.class);
    @Test
    public void testGuava(){
        Optional<Integer> optionalA = Optional.of(5);
        Optional<Integer> optionalB = Optional.of(2);

        Assert.assertTrue(optionalA.isPresent());
        logger.info(Strings.nullToEmpty(null));
        logger.info(Strings.emptyToNull(null));
        logger.info(new TestGuava().sum(optionalA,optionalB)+"");
    }
    private Integer sum(Optional<Integer> optionalA,Optional<Integer> optionalB){
        Integer a = optionalA.get();
        Integer b = optionalB.get();
        return a+b;
    }
}
