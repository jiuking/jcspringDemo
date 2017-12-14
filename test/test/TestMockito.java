package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2017/10/27 0027.
 */
public class TestMockito {
    @Test
    public void createMockObject(){
        List mockedList = mock(List.class);
        Assert.assertTrue(mockedList instanceof List);

        ArrayList mockedArrayList = mock(ArrayList.class);
        Assert.assertTrue(mockedArrayList instanceof List);
        Assert.assertTrue(mockedArrayList instanceof ArrayList);
    }

    @Test
    public void configMockObject(){
        List mockedList = mock(List.class);
        when(mockedList.add("one")).thenReturn(Boolean.TRUE);
        when(mockedList.size()).thenReturn(1);
        Assert.assertTrue(mockedList.add("one"));
        Assert.assertEquals(mockedList.size(),1);
    }

    @Test
    public void test() {
        long exceptionStart = System.currentTimeMillis();
        try {
            for (int i = 1; i < 1000000; i++) {
                System.out.println("外部异常："+i);
                if (i % 500 == 0) {
                    throw new ArithmeticException();
                }
            }
        } catch (Exception e) {

        }
        long exceptionEnd = System.currentTimeMillis();
        System.out.println(exceptionEnd - exceptionStart);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            System.out.println("内部异常："+i);
            try {
                if (i % 500 == 0) {
                    throw new ArithmeticException();
                }
            } catch (Exception e) {

            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
