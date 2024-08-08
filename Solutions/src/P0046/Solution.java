package P0046;

import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> permuteRecursive(int[] nums, int start) {
        if (start == nums.length - 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[start]);
            result.add(list);
            return result;
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = start; i<nums.length; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            List<List<Integer>> subResult = permuteRecursive(nums, start+1);
            for(List<Integer> list: subResult) {
                list.add(nums[start]);
                result.add(list);
            }
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
        return result;

    }
    public List<List<Integer>> permute(int[] nums) {
        return permuteRecursive(nums, 0);

    }
}