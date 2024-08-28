package P1905;

import java.util.*;

public class Solution2 {
    public boolean dfs(int[][] grid, int x, int y) {
        Set<Pair> group = new HashSet<>();
        group.add(new Pair(x, y));
        boolean ans = true;
        while(!group.isEmpty()) {
            Pair p = group.iterator().next();
            group.remove(p);
            int i = p.getX();
            int j = p.getY();
            if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) continue;
            if(grid[i][j] == 0) continue;
            if(grid[i][j] == 1) ans = false;
            grid[i][j] = 0;
            group.add(new Pair(i+1, j));
            group.add(new Pair(i-1, j));
            group.add(new Pair(i, j+1));
            group.add(new Pair(i, j-1));
        }
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if(grid1.length == 0 || grid1[0].length == 0) return 0;
        for(int i = 0; i<grid1.length; i++)
        for(int j = 0; j<grid1[0].length; j++) {
            if(grid1[i][j] == 1 && grid2[i][j] == 1) grid2[i][j] = 2; 
        }

        int ans = 0;
        for(int i = 0; i<grid2.length; i++)
        for(int j = 0; j<grid2[0].length; j++) {
            if(grid2[i][j] ==2 && dfs(grid2, i, j)) ans++; 
        }
        return ans;
    }
}
