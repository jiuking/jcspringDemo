package test.LeetCode.quetion500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Keyboard Row
 */
public class Solution {

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> lineOne = new HashSet<String>(){
            {
                add("Q");
                add("W");
                add("E");
                add("R");
                add("T");
                add("Y");
                add("U");
                add("I");
                add("O");
                add("P");
            }
        };
        Set<String> lineTwo = new HashSet<String>(){
            {
                add("A");
                add("S");
                add("D");
                add("F");
                add("G");
                add("H");
                add("J");
                add("K");
                add("L");
            }
        };
        Set<String> lineThree = new HashSet<String>(){
            {
                add("Z");
                add("X");
                add("C");
                add("V");
                add("B");
                add("N");
                add("M");
            }
        };
        for (String word : words) {
            char[] chars = word.toUpperCase().toCharArray();
            int one = 0,two = 0,three = 0;
            boolean isLine = true;
            for (char c : chars) {
                String s = Character.toString(c);
                if (lineOne.contains(s)) {
                    one = 1;
                }
                if (lineTwo.contains(s)) {
                    two = 1;
                }
                if (lineThree.contains(s)) {
                    three = 1;
                }
                if (one + two + three > 1){
                    isLine = false;
                    break;
                }
            }
            if (isLine)
                result.add(word);
        }
        return result.toArray(new String[0]);
    }

    @Test
    public  void test() {
        String[] s = {"Hello", "Alaska", "Dad", "Peace"};
        for (String temp : findWords(s)) {
            System.out.println(temp);
        }
    }
}
