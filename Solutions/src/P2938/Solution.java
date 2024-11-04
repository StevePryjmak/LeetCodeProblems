package P2938;

class Solution {
    public long minimumSteps(String s) {
        long ans = 0,aded = 0;
        for(long i=0; i < s.length();i++) {
            if(s.charAt((int)i) == '0') {
                ans+= i-aded;
                aded++;
            }
        }
        return ans;
    }
}