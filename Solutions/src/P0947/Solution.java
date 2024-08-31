package P0947;

import java.util.*;

class Solution {
    int max_removed = 0;
    public void dfs(Vector<Vector<Integer>> stones, int removed, HashMap<Integer, Vector<Integer>> row, HashMap<Integer, Vector<Integer>> col) {
        for(int i = 0; i < stones.size(); i++) {
            if(row.containsKey(stones.get(i).get(0)) || col.containsKey(stones.get(i).get(1))) {
                Vector<Vector<Integer>> stonesRemoved = new Vector<>(stones);
                stonesRemoved.remove(i);
                
                HashMap<Integer, Vector<Integer>> newRow = new HashMap<>(row);
                HashMap<Integer, Vector<Integer>> newCol = new HashMap<>(col);
                newRow.remove(stones.get(i).get(0));
                newCol.remove(stones.get(i).get(1));
                
                dfs(stonesRemoved, removed + 1, newRow, newCol);
            }
        }
        if(removed > max_removed) max_removed = removed;
    }
    public int removeStones(int[][] stones) {
        HashMap<Integer, Vector<Integer>> row = new HashMap<>();
        HashMap<Integer, Vector<Integer>> col = new HashMap<>();
        Vector<Vector<Integer>> stonesVect = new Vector<>();
        for(int i = 0; i < stones.length; i++) {
            stonesVect.add(new Vector<>(stones[i][0], stones[i][1]));
            if(!row.containsKey(stones[i][0])) row.put(stones[i][0], new Vector<>());
            if(!col.containsKey(stones[i][1])) col.put(stones[i][1], new Vector<>());
            row.get(stones[i][0]).add(i);
            col.get(stones[i][1]).add(i);
        }
        dfs(stonesVect, 0, row, col);
        return max_removed;
    }
}