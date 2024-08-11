package P0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    void backtrack(int[] candidates, int target, int start, List<Integer> current) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i<candidates.length; i++) {
            if(i>start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i+1, current);
                current.remove(current.size()-1);
            }
            
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
}