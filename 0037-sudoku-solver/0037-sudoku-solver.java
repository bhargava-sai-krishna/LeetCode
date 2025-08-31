class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean isValid(char[][] board, int r, int c, char val) {
        for (int i=0; i<9; i++) {
            if (board[r][i] == val) return false;
            if (board[i][c] == val) return false;
            if (board[3*(r/3) + i/3][3*(c/3) + i%3] == val) return false;
        }
        return true;
    }

    public boolean solve(char[][] board) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') {
                    for (char n='1'; n<='9'; n++) {
                        if (isValid(board, i, j, n)) {
                            board[i][j] = n;
                            if (solve(board)){ 
                                return true;
                            }
                            else{ 
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
