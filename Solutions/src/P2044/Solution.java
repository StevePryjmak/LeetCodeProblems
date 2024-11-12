package P2044;

class Solution {
    int[] nums;
    int target = 0;
    private int backTrack(int index, int curr) {
        if(index == nums.length) 
            return (curr == target) ? 1:0;
        return backTrack(index + 1, curr) + backTrack(index + 1, curr | nums[index]);
    }

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        for(int num: nums) target |= num;
        return backTrack(0, 0);
    }
}