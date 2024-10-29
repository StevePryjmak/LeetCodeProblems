package P0567;

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        for (char c : s1.toCharArray()) s1Freq[c - 'a']++;

        int[] windowFreq = new int[26];
        int windowSize = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            if (i >= windowSize) {
                windowFreq[s2.charAt(i - windowSize) - 'a']--;
            }
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}
