package P0032;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, i = 0;
        stack.push(-1);
        for(;i<s.length();i++) {
            if(s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}