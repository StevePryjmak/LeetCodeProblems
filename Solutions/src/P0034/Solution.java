package P0034;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,1,2};
        int target = 1;
        int[] result = s.searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public int search(int[] nums, int start, int end, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] == target) return 0; 
        else if (nums.length == 1) return -1;
        // int start = 0, end = nums.length -1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[start])
            {
                if(nums[start]<=target && target <= nums[mid])
                end = mid-1;
                else start = mid+1;
            }
            else
            {
                if(nums[mid]<=target && target <= nums[end])
                start= mid+1;
                else end = mid-1;
            }
        }
       
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int index = search(nums, 0, nums.length-1, target);
        if (index == -1) return new int[]{-1,-1};
        int start=0;
        int left = index;
        int end = nums.length-1;
        int right = index;
        // find start;
        while(start<left) {
            int mid = (start + left)/2;
            if(nums[mid] != target) {
                if(nums[mid+1] == target) {
                    left = mid+1;
                    break;
                }
                start = mid+1;
            }
            else {
                if(mid-1==-1 || nums[mid-1] != target) {
                    left = mid;
                    break;
                }
                left = mid-1;
            }
        }
        // find end;
        while(right < end) {
            int mid = (right + end) /2;
            if(nums[mid]!=target){
                if(nums[mid-1] == target) {
                    right = mid-1;
                    break;
                }
                end = mid-1;
            }
            else {
                if(mid+1 == nums.length || nums[mid+1] != target) {
                    right = mid;
                    break;
                }
                right = mid+1;
            }
        }
        return  new int[]{left, right};
    }
}