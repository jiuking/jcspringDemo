package test.LeetCode.question557;
/*
*
*Given a string,
* you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
* Input: "Let's take LeetCode contest"
* Output: "s'teL ekat edoCteeL tsetnoc"
* */
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        String result = "";
        String[] temp = s.split(" ");
        for (int i = 0; i < temp.length; i++) {
            char[] chars = temp[i].toCharArray();
            char[] temp1 = new char[chars.length];
            int index = 0;
            for (int j = chars.length - 1; j > -1; j--) {
                temp1[index] = chars[j];
                ++index;
            }
            result = result + String.valueOf(temp1) +" ";
        }
        return result.substring(0,result.length()-1);
    }

    public static void main(String[] args) {
        String reuslt = new Solution().reverseWords("Let's take LeetCode contest");
        System.out.println(reuslt);
    }
}
