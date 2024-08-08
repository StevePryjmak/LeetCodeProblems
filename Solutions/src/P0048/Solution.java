package P0048;

class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        Solution s = new Solution();
        s.rotate(matrix);
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        System.out.println(n);

        for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }

        for(int i = 0; i<n; i++) 
        for(int j = 0; j<n/2;j++)
        {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n-j-1];
            matrix[i][n-j-1] = temp;
        }
    }
}