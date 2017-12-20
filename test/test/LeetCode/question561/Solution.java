package test.LeetCode.question561;

import org.junit.Test;

import java.util.Arrays;

/**
 * Array Partition I
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length;i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    @Test
    public void test() {
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
        System.out.println(0%2);
    }
}
