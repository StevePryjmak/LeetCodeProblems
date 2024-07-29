package P0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray())
        {
            if(map.containsKey(c)) stack.push(c);
            else if(stack.size() != 0 && map.get(stack.peek()) == c) stack.pop();
            else return false;
        }
        return stack.size() == 0;
    }
}