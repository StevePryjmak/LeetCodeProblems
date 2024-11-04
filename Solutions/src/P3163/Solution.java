package P3163;

class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int length = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(i-1)) {
                ans.append(length).append(word.charAt(i-1));
                length = 1;
                continue;
            }
            if (length == 9) {
                ans.append(9).append(word.charAt(i));
                length = 1;
                continue;
            }
            length++;
        }
        ans.append(length).append(word.charAt(word.length()-1));
        return ans.toString();
    }
}
