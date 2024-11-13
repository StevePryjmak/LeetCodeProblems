package P0921;

class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int opend = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') opend++;
            else if(opend < 1) ans++;
            else opend--;
        }
        return ans + opend;
    }
}