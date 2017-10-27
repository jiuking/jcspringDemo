package test;

import org.apache.log4j.Logger;
import test.entity.PersonEntity;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
public class TestLomBok {
    private static Logger logger = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args) {
        logger.info(new PersonEntity().setName("asd").getName());
    }
}
