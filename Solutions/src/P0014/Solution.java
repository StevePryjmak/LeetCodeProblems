package P0014;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i = 0; ; i++)
        for(String s: strs)
            if(i >= s.length() || s.charAt(i) != strs[0].charAt(i))
                return strs[0].substring(0,i);
    }
}