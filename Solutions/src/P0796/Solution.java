package P0796;

class Solution {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String allRotation = s + s;
        return allRotation.contains(goal);
    }
}