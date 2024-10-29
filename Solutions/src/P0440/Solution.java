package P0440;

class Solution {
    int currPosition = 0;
    public int findKthNumber(int n, int k) {
        long num = 1;
        for(int i = 1; i<k;) {
            int gap = getRootGap(num,num+1,n);
            if(i+gap <= k) {
                i += gap;
                num++;
            }
            else {
                i++;
                num*=10;
            }
        }
        return (int) num;
    }

    private int getRootGap(long curr, long next, long n) {
        int gap = 0;
        while(curr <= n) {
            gap += (int)( Math.min(n+1, next) - curr);
            curr*=10;
            next*=10;
        }
        return gap;
    }
}