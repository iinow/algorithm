class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                //row
                for (int a = 0; a < 9; a++) {
                    if (a == j) continue;
                    if (board[i][a] == board[i][j]) return false;
                }
                
                //column
                for (int a = 0; a < 9; a++) {
                    if (a == i) continue;
                    if (board[a][j] == board[i][j]) return false;
                }
                
                //grid
                for (int a = 0; a < 3; a++) {
                    int x = (i / 3 * 3) + a;
                    for (int b = 0; b < 3; b++) {
                        int y = (j / 3 * 3) + b;
                        if (x == i && y == j) continue;
                        if (board[x][y] == board[i][j]) return false;
                    }
                }
                
            }
        }
        
        return true;
    }
}