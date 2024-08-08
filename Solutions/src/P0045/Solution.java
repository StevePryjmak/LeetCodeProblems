package P0045;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[]{2,3,1,1,4}));
    }
    public int jump(int[] nums) {
        if(nums.length== 0) return 0;
        int jumps = 0, maxNextJump = nums[0], current = 0;
        
        while(current != nums.length - 1) {
            if(current + nums[current] >= nums.length - 1) {current = nums.length -1; jumps++; break;}
            maxNextJump = nums[current+1];
            int indexOfNextJump = current + 1,index = current + 1;
            for(int i = 0; index<nums.length && i<nums[current]; i++, index ++) {
                if(maxNextJump <= nums[index]+i) {
                    maxNextJump = nums[index] +i;
                    indexOfNextJump = index;
                }
            }
            current = indexOfNextJump;
            jumps++;
            if (current == nums.length -1) break;
            if (nums[current]+current >= nums.length-1) {current = nums.length -1; jumps++; }
        }
        return jumps;
    }
}