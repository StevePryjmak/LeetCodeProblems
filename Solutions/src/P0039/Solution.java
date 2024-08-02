package P0039;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void dfs(int[] candidates, int target, List<Integer> list, int curentSum){
        if(curentSum > target) return ;
        if(curentSum == target) {
            result.add(list);
            return ;
        }

        for(int i = 0; i<candidates.length; i++) {
            if(list.size() != 0 && candidates[i]< list.get(list.size()-1))
            continue;
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(candidates[i]);
            dfs(candidates, target, list1, curentSum+candidates[i]);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0);
        return result;
    }
}
