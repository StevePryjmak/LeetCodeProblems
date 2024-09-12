package P1684;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] chars = new int[26];
        int ans = 0;
        for(int i = 0; i< 26; i++) chars[i] = 0;
        for(int i = 0; i< allowed.length(); i++) {
            chars[(int) allowed.charAt(i) - 97] = 1;
        }
        for(String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray())
            if(chars[(int) c - 97] == 0) {isConsistent = false; break;}
            if(isConsistent) ans++;
        }
        return ans;
    }
}