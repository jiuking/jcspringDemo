package test.LeetCode.question728;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
* A self-dividing number is a number that is divisible by every digit it contains.
* For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
* Also, a self-dividing number is not allowed to contain the digit zero.
* Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
* */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        if (left < 0 || right < left || right > 10000){
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <=right ; i++) {
            String temp = String.valueOf(i);
            boolean isDividing = true;
            char[] a = temp.toCharArray();
            for (int j = 0 ;j<a.length;j++) {
                /*if (a[j] - 48 == 0 && j+1 == a.length){
                    isDividing = false;
                }*/
                if (a[j] - 48 == 0)
                    continue;
                if (i % (a[j] - 48) != 0) {
                    isDividing = false;
                    break;
                }
            }
            if (isDividing)
                list.add(i);
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> result = new Solution().selfDividingNumbers(66, 708);
        for (int temp : result) {
            System.out.println("dividing number:"+temp);
        }
    }

    @Test
    public void test(){
        char a = '0';
        int b = 20;
        char[] temp = String.valueOf(b).toCharArray();
        for (char c :  temp ) {
            System.out.println(c);
        }
        System.out.println(a);
        System.out.println(2%2);
    }
}
