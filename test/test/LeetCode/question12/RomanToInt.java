package test.LeetCode.question12;

/**
 * 从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。
 * 反之，减去前一个数的两倍然后加上该数
 */
public class RomanToInt {
    public int romanToInt(char roman) {
        switch (roman){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public void solution(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException();
        }
        char[] chars = s.toCharArray();
        int[] results = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            results[i] = romanToInt(chars[i]);
        }
        int sum = 0;
        for (int i = results.length - 1; i > -1 ; i--) {
            System.out.println(results[i]);
        }
    }

    public static void main(String[] args) {
        new RomanToInt().solution("XCIX");
    }
}
