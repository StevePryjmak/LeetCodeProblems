package P1905;

class Solution1 {

    boolean isSubIland;
    
    public void dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if(grid[i][j] == 0) return;
        if(grid[i][j] == 1) isSubIland = false;
        grid[i][j] = 0;
        dfs(grid,i+1, j);
        dfs(grid,i-1, j);
        dfs(grid,i, j+1);
        dfs(grid,i, j-1);
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
            if(grid2[i][j] != 2) continue;
            isSubIland = true;
            dfs(grid2, i, j);
            if(isSubIland) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] grid1 = new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(s.countSubIslands(grid1, grid2));
    }

    public static void show(int[][] grid) {
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}