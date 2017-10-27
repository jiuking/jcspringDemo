package com.hjc.spring.test;

import com.hjc.spring.test.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
public class TestLomBok {
    private static Logger logger = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args) {
        logger.info(new PersonEntity().setName("asd").getName());
    }
}
