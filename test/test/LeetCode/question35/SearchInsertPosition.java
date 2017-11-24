package test.LeetCode.question35;

import org.junit.Test;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]){
                result =  i+1;
            }else if (target == nums[i])
                return i;
            else
                break;

        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 4, 5, 7, 10, 12};
        int result = searchInsert(nums, 11);
        System.out.println(result);
        System.out.println(nums[result]);
    }
}
