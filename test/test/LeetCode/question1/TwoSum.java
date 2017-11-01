package test.LeetCode.question1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/1 0001.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *  Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    private int[] targetNums = {1,2,3,4,5};
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0,0};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return new int[]{i,map.get(nums[i])};
            map.put(target - nums[i],i);
        }
        return result;
    }

    @Test
    public void print(){
        int[] result = new TwoSum().twoSum(targetNums,9);
        System.out.println(result[0] +" "+result[1]);
    }
}
