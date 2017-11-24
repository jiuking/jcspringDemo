package test.LeetCode.question20;

import org.junit.Test;

public class ParenthessTest {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return false;
        char[] chars = s.toCharArray();
        for (int c : chars) {
        }
        return false;
    }

    @Test
    public void test() {
        String test = "(){}[]";
//        boolean isValid = isValid(test);
//        System.out.println(isValid);
        int a = '(';
        int b = ')';
        int c = '{';
        int d = '}';
        int e = '[';
        int f = ']';
        System.out.println(a +" " + b+" " + c+" " + d+" " + e+" " + f);
    }
}
