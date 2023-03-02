class Solution {
    public int[] findBall(int[][] grid) {
        int length = grid[0].length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = match(grid, i);
        }
        return res;
    }
    
    private int match(int[][] grid, int column) {
        int row = 0, maxColumn = grid[0].length;
        while (row != grid.length) {
            if (grid[row][column] == 1) {
                if (column + 1 >= maxColumn) {
                    return -1;
                }
                if (grid[row][column + 1] == -1) {
                    return -1;
                }
                row++;
                column++;
                continue;
            }
            if (grid[row][column] == -1) {
                if (column - 1 < 0) {
                    return -1;
                }
                if (grid[row][column - 1] == 1) {
                    return -1;
                }
                row++;
                column--;
            }
        }
        return column;
    }
}