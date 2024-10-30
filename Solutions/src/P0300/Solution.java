package P0300;

import java.util.ArrayList;
import java.util.List;
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ends = new ArrayList<>();
        for(int num:nums) {
            int pos = binarySearch(ends, num);
            if (pos == ends.size()) ends.add(num);
            else ends.set(pos, num);
        }
        return ends.size();
    }

    private int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size()-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(lis.get(mid) < target)
                left= mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}