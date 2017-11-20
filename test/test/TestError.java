package test;

import java.util.HashMap;
import java.util.Map;

public class TestError {
    public static Map map = new HashMap(){{
        map.put("a","2");
    }};

    public static void main(String[] args) {
        System.out.println((String) map.get("a"));
    }

}
