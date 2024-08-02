package P0036;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            if(board[row][i] == '.')
                continue;
            if(set.contains(board[row][i]))
                return false;
            set.add(board[row][i]);
        }
        return true;
    }
    public boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            if(board[i][col] == '.')
                continue;
            if(set.contains(board[i][col]))
                return false;
            set.add(board[i][col]);
        }
        return true;
    } 
    public boolean isValidBox(char[][] board, int col, int row) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[row+i][col+j] == '.')
                    continue;
                if(set.contains(board[row+i][col+j]))
                    return false;
                set.add(board[row+i][col+j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i< 9; i++) if(!isValidRow(board, i)) return false;
        for(int i = 0; i<9; i++) if(!isValidCol(board, i)) return false;
        for(int i = 0; i<9; i+=3)
        for(int j = 0; j<9; j+=3) if(!isValidBox(board, i, j)) return false;
        return true;
    }
}
