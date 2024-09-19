package P2326;


class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int d = 0, x=0, y=0;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}}, ans = new int[m][n];
        for(int i = 0; i<m; i++)
        for(int j = 0; j<n; j++) ans[i][j] = -1;
        for(;head != null; head = head.next) {
            
            ans[x][y] = head.val;
            int newX = x + directions[d][1];
            int newY = y + directions[d][0];
            if(newX == -1 || newX == m || newY == -1 || newY == n || ans[newX][newY] != -1) 
                d = (d+1)%4;
            x = x + directions[d][1];
            y = y + directions[d][0];
        }
        return ans;
    }
}