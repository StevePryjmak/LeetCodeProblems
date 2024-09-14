package P2419;

class Solution {
    public int longestSubarray(int[] nums) {
        int maxLength = 1, maxNum = nums[0];
        int currentLength = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] == maxNum) currentLength++;
            else if(nums[i] > maxNum) {
                maxNum = nums[i];
                maxLength = 1; 
                currentLength = 1;
            }
            else {
                if(currentLength > maxLength) maxLength = currentLength;
                currentLength = 0;
            }
        }
        if(currentLength > maxLength) maxLength = currentLength;
        return maxLength;
    }
}