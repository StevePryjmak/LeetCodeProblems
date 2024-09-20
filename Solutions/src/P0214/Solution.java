package P0214;

class Solution {
    public String shortestPalindrome(String s) {
        int count = kmp(new StringBuilder(s).reverse().toString(), s);
        return new StringBuilder(s.substring(count)).reverse().toString() + s;
    }

    private int kmp(String txt, String patt) {
        String str = patt + '#' + txt;
        int[] pi = new int[str.length()];
        int i= 1, k = 0;
        while (i < str.length()) {
            if(str.charAt(i)== str.charAt(k)) {
                k++;
                pi[i] = k;
                i++;
            }
            else {
                if(k > 0) k = pi[k-1];
                else {
                    pi[i] = 0;
                    i++;
                }
            }
            
        }
        return pi[str.length() - 1];
    }
}