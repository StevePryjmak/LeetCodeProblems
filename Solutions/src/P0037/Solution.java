package P0037;

class Solution {
    public boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i<9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
    public boolean recursiveSolve(char[][] board, int index) {
        if(index == 81) return true;
        int row = index / 9;
        int col = index % 9;
        if(board[row][col] != '.') return recursiveSolve(board, index+1);
        for(char c = '1'; c<='9'; c++) {
            if(!isValid(board,row,col,c)) continue;
            board[row][col] = c;
            if(recursiveSolve(board,index+1)) return true;
            else board[row][col]= '.';
        }
        board[row][col] = '.';
        return false;
    }
    public void solveSudoku(char[][] board) {
        recursiveSolve(board, 0);
    }
}