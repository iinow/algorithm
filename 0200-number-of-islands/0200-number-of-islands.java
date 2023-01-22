class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] history = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += recursive(history, grid, i, j);
            }
        }
        
        return count;
    }
    
    private int recursive(boolean[][] history, char[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0) {
            return 0;
        }
        
        if (history[x][y]) {
            return 0;
        }
        
        history[x][y] = true;
        if (grid[x][y] == '1') {
            recursive(history, grid, x + 1, y);
            recursive(history, grid, x - 1, y);
            recursive(history, grid, x, y + 1);
            recursive(history, grid, x, y - 1);
        } else if (grid[x][y] == '0') {
            return 0;
        }
        
        return 1;
    }
}