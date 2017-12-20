package test.LeetCode.question657;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Judge Route Circle
 */
public class Solution {

    public boolean judgeCircle(String moves) {
        if (moves == null) {
            return false;
        }
        char[] move = moves.toUpperCase().toCharArray();
        int x = 0,y = 0;
        for (int i = 0; i < 2; i++) {
            switch (move[i]) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(judgeCircle("LR"));
    }
}
