package test;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/10/27 0027.
 */
public class TestGuava {
    private static final Logger logger = LoggerFactory.getLogger(TestGuava.class);
    @Test
    public void testGuava(){
        System.out.println(Objects.equals(null,null));
        Optional<Integer> optionalA = Optional.of(5);
        Optional<Integer> optionalB = Optional.of(2);

        Assert.assertTrue(optionalA.isPresent());
        logger.info(Strings.nullToEmpty(null));
        logger.info(Strings.emptyToNull(null));
        logger.info(new TestGuava().sum(optionalA,optionalB)+"");
        new TestGuava().sqrt(2);
    }
    private Integer sum(Optional<Integer> optionalA,Optional<Integer> optionalB){
        Integer a = optionalA.get();
        Integer b = optionalB.get();
        return a+b;
    }

    @Test
    public void test(){
        logger.info(new BigDecimal(Integer.MIN_VALUE).toString());
    }

    private void sqrt(double a){
        Preconditions.checkArgument(a > 0,"Illegal Argument pass:Negative vlaue %s",a);
    }

    @Test
    public void integerEqualTest(){
        String[] s = new String[]{"1","2","3"};
        List list = Arrays.asList(s);
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put(null,"2");
        logger.info(list.get(1).toString());
        s[1] = "a";
        logger.info(list.get(1).toString());
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
        System.out.println(Objects.equals(a,b));
    }

    private static final ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    private static class ThreadTest extends Thread{
        @Override
        public void run() {
            logger.info("into Thread");
                DateFormat sf = sdf.get();
                try {
                    logger.info(sf.format(new Date()));
                    System.out.println(sdfError.parse("2014-01-01"));
                }catch (ParseException e){
                    e.printStackTrace();
                }

            }
    }
    private static SimpleDateFormat sdfError = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void ThreadTe(){
        for (int i = 0; i < 1000; i++) {
            Thread t = new ThreadTest();
            t.setName("线程"+i);
            t.start();
            logger.info(t.getName());
        }
    }

    @Test
    public void testGuav() {
        String a = " a b ";
        System.out.println(Strings.isNullOrEmpty(a));
        System.out.println(a.length());
        System.out.println(a.trim());
        try{

        }catch (Exception e){
            throw e;
        }
    }
}
