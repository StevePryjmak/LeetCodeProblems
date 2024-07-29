package P0022;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ans = new ArrayList<>();
    int n;
    private void dfs(int openNum,int closeNum,String s) {
        if(openNum == closeNum && openNum+closeNum == 2*n){
            ans.add(s);
            return;
        }
        if(openNum < n) dfs(openNum+1,closeNum,s+"(");
        if(closeNum < openNum) dfs(openNum,closeNum+1,s+")");
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0,0,"");
        return ans;
    }
}