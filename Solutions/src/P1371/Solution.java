package P1371;

import java.util.Arrays;

class Solution {
    public int findTheLongestSubstring(String s) {
        int[] CharMap = new int[26];
        CharMap['a' - 'a'] = 1;
        CharMap['e' - 'a'] = 2;
        CharMap['i' - 'a'] = 4;
        CharMap['o' - 'a'] = 8;
        CharMap['u' - 'a'] = 16;
        int[] combinationAppearance = new int[32];
        Arrays.fill(combinationAppearance, -1);
        int prefixXOR = 0, longestSubstring = 0;
        for(int i = 0; i < s.length(); i++) {
            prefixXOR ^= CharMap[s.charAt(i) - 'a'];
            if(combinationAppearance[prefixXOR] == -1 && prefixXOR != 0) 
                combinationAppearance[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - combinationAppearance[prefixXOR]);

        }
        return longestSubstring;
    }
}