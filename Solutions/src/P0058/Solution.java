package P0058;

class Solution {
    public int lengthOfLastWord(String s) {
        int lastLength = 0;
        int currentLength = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                if(currentLength > 0) lastLength = currentLength;
                currentLength = 0;
                continue;
            }
            currentLength++;
        }
        if(currentLength > 0) lastLength = currentLength;
        return lastLength;
    }
}