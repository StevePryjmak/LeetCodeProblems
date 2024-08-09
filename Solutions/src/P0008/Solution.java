package P0008;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-21474836482"));
    }
    public int myAtoi(String s) {
        int multiplyer = 1;
        int ans = 0, i = 0;
        while(i<s.length() && s.charAt(i) == ' ') i++;
        if(i == s.length()) return 0;
        if(s.charAt(i) == '-') {multiplyer = -1; i++;}
        else if(s.charAt(i) == '+') i++;
        for(;i<s.length();i++) {
            int digit = s.charAt(i) - 48;
            if (digit > 9 || digit <0) break;
            if(multiplyer == -1) {
                if(ans > Integer.MAX_VALUE /10) return Integer.MIN_VALUE;
                if(ans == Integer.MAX_VALUE /10 && digit >= 8) return Integer.MIN_VALUE;
            }
            else if (ans > Integer.MAX_VALUE /10) return Integer.MAX_VALUE;
            else if(ans == Integer.MAX_VALUE /10 && digit >= 7) return Integer.MAX_VALUE;
            ans = ans * 10 + digit;
        }
        return ans * multiplyer;
    }
}
