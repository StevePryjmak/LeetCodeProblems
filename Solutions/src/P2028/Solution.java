package P2028;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = (m+n) * mean;
        int[] ans = new int[n];
        for(int i = 0; i<m; i++) sum -= rolls[i];
        sum -= n;
        for(int i = 0; i<n; i++) {
            if(sum > 5) {
                ans[i] = 6;
                sum -=5;
            }
            else if(sum > 0) {
                ans[i] = 1+sum;
                sum = 0;
            }
            else ans[i] = 1;
        }
        if(sum != 0) return new int[0];
        return ans;
    }
}