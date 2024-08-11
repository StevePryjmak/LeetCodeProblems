package P0041;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1,1}));
        // System.out.println(solution.firstMissingPositive(new int[]{3,4,-1,1}));
        // System.out.println(solution.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length) {
            if(nums[i] == i+1) {}
            else if(nums[i]<=0) nums[i] = -1;
            else if(nums[i]>nums.length) nums[i] = -1;
            else if(nums[nums[i]-1] == nums[i]) nums[i] = -1;
            else {

                int temp =nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                continue;
            }
            i++;
        }
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
}