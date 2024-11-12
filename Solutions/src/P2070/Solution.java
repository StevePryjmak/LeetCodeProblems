package P2070;

import java.util.Arrays;
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];

        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        int max = items[0][1];
        for(int i = 0; i< items.length; i++){
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        for(int i = 0; i< queries.length; i++){
            ans[i] = binSearch(items, queries[i]);
        }

        return ans;
    }

    private int binSearch(int[][] items, int target) {
        int start = 0;
        int end = items.length - 1;
        int maxBeauty = 0;
        while( start<= end) {
            int mid = (start + end) /2;
            if(items[mid][0]> target) {
                end = mid - 1;
            }
            else {
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                start = mid + 1;
            }
        }
        return maxBeauty;
    }
}




