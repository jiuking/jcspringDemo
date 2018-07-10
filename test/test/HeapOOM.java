package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Administrator
 * @date : 2018/7/9 0009 13:55
 * @description : 测试内存溢出异常测试
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
