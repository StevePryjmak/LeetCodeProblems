package P0241;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> ans = new ArrayList<>();
        int n = exp.length();
        
        for (int i = 0; i < n; i++) {
            char op = exp.charAt(i);
            if (op == '+' || op == '-' || op == '*') {
                List<Integer> s1 = diffWaysToCompute(exp.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(exp.substring(i + 1));
                
                for (int a : s1) {
                    for (int b : s2) {
                        if (op == '+') ans.add(a + b);
                        else if (op == '-') ans.add(a - b);
                        else if (op == '*') ans.add(a * b);
                    }
                }
            }
        }
        
        if (ans.isEmpty()) ans.add(Integer.parseInt(exp));
        return ans;
    }
}