package P0047;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    void backtrack(int[] nums, boolean[] visited, List<Integer> current) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i<nums.length; i++) {
            if(visited[i]) continue;
            current.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, current);
            current.remove(current.size()-1);
            visited[i] = false;
            while(i+1<nums.length && nums[i] == nums[i+1]) i++;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < visited.length; i++) visited[i] = false;
        Arrays.sort(nums);
        backtrack(nums, visited, current);
        return result;
        
    }
}