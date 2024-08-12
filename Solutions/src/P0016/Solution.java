package P0016;

import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int distance = sum - target;
                
                if(Math.abs(distance) < Math.abs(minDistance)) minDistance = distance;
                if(distance == 0) return target;
                else if(distance < 0) j++;
                else k--;
            }
        }
        return target + minDistance;        
    }
}