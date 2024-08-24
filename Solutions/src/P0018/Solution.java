
import java.util.*;

class Solution {
    public int[] copyElementFrom(int[] nums, int index) {
        if (nums == null || nums.length == 0 || index < 0 || index >= nums.length) return new int[0];
        int[] result = new int[nums.length - index];
        System.arraycopy(nums, index, result, 0, nums.length - index);
        return result;
    }
    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<nums.length-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(j < k) {
                long sum = (long) nums[i] + (long) nums[j] + (long) nums[k];
                if(sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
                    j++;
                    k--;
                    continue;
                }
                if(sum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                } 
                else if(sum < target) j++;
                else k--;
            }
        }
        return result;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int[] rightNums = nums;
        for(int i = 0;i < nums.length;i++)
        {
            rightNums = copyElementFrom(nums, i+1);
            long targetOfThree = target;
            if(targetOfThree - nums[i] > Integer.MAX_VALUE || targetOfThree - nums[i] < Integer.MIN_VALUE) 
            {
                continue;
            }
            List<List<Integer>> sumsOfThree = threeSum(rightNums, (int)target-nums[i]);

            //add to result
            for (List<Integer> list : sumsOfThree) {
                List<Integer> modifiableList = new ArrayList<>(list);
                modifiableList.add(0, nums[i]);  
                result.add(modifiableList);      
            }

            // skip the same
            i++;
            while(i<nums.length && nums[i]== nums[i-1]) i++;
            i--;
            

        }
        return result;
    }
}
