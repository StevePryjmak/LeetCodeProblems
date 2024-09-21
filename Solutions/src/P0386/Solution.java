package P0386;

import java.util.*;
class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return ans;
    }
    
    private void dfs(int num, int limit) {
        if (num > limit) return; 
        ans.add(num);
        
        for (int i = 0; i <= 9; i++) { 
            dfs(num * 10 + i, limit);
        }
    }
}
