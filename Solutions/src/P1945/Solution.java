package P1945;

class Solution {
    public int getLucky(String s, int k) {
        int ans = 0;
        for(int i = 0; i<s.length(); i++) {
            int symbolVal = (int) s.charAt(i) - 96;
            while(symbolVal != 0) {
                ans+= symbolVal % 10;
                symbolVal /= 10;
            }
        }
        for(int i = 1; i<k; i++) {
            int newAns = 0;
            while(ans != 0) {
                newAns += ans % 10;
                ans /= 10;
            }
            ans = newAns;
        }
        return ans;
    }

}