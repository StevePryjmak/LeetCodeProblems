package P1671;

import java.util.ArrayList;
import java.util.List;
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] fromLeft = calculateLIS(nums, false);
        int[] fromRight = calculateLIS(nums, true);
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (fromLeft[i] > 1 && fromRight[i] > 1) { 
                int length = fromLeft[i] + fromRight[i] - 1;
                ans = Math.max(ans, length);
            }
        }

        return nums.length - ans;
    }

    private int[] calculateLIS(int[] nums, boolean reverse) {
        int n = nums.length;
        int[] lisLengths = new int[n];
        List<Integer> ends = new ArrayList<>();

        if (reverse)
            for (int i = n - 1; i >= 0; i--) 
                update(nums[i], ends, lisLengths, i);
        else 
            for (int i = 0; i < n; i++) 
                update(nums[i], ends, lisLengths, i);
        
        return lisLengths;
    }

    private void update(int num, List<Integer> ends, int[] lisLengths, int index) {
        int pos = binarySearch(ends, num);
        if (pos == ends.size()) ends.add(num);
        else ends.set(pos, num);
        lisLengths[index] = ends.size();
    }

    private int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
