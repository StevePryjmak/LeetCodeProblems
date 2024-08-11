# Intuition
The problem of finding the first missing positive integer in an unsorted array can be efficiently solved using a technique known as cycle sort. The challenge is to identify the smallest positive integer that is not present in the array while optimizing both time and space complexity.

# Approach
The key insight is to recognize that the first missing positive number must be within the range of 1 to n+1, where n is the size of the array. Therefore, we can attempt to place each number in its "correct" position (i.e., `nums[i]` should be `i + 1`) if possible. If a number is out of this range, or if it’s already in the correct position, we skip it (and i also change it to -1 but you can merge 4 firs ifs into 1 and do nothing).

### Here’s how the algorithm works:

1. Iterate through the array, and for each number, attempt to place it at its correct index (`nums[i]` should be placed at `nums[nums[i] - 1]`).
2. If the current number is out of the valid range, or if placing it in the correct position would create a duplicate, move on to the next number.
3. After all numbers are processed, the first index where the number is not equal to `i + 1` is the first missing positive.
If all positions are correct, then the missing number is `n + 1`.

# Complexity
- Time complexity:
O(n)

- Space complexity:
O(1)

# Code
```
class Solution {
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
```
