class Solution {
    public int shortestPath(int[][] grid, int k) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        final int lastRow = rows - 1;
        final int lastCol = cols - 1;

        // Manhattan Optimization
        if (k >= rows + cols - 2) return rows + cols - 2;

        // Use BFS
        final Queue<int[]> queue = new LinkedList<>();
        
        // init case
        queue.offer(new int[] { 0, 0, k });

        // for checking visited with highest k so far 
        final Integer[][] maxK = new Integer[rows][cols];

        for (int steps = 0; !queue.isEmpty(); steps++) {
            for (int i = 0, n = queue.size(); i < n; i++) {
                
                final int[] curr = queue.poll();
                final int currRow = curr[0];
                final int currCol = curr[1];
                final int currK = curr[2];

                // return first found value
                if (currRow == lastRow && currCol == lastCol) return steps;

                // add right
                if (currCol < lastCol) {
                    final int newRow = currRow;
                    final int newCol = currCol + 1;
                    final int newK = currK - grid[newRow][newCol];
                    if (newK >= 0 && (maxK[newRow][newCol] == null || newK > maxK[newRow][newCol])) {
                        queue.offer(new int[] { newRow, newCol, newK });
                        maxK[newRow][newCol] = newK;
                    }
                }

                // add down
                if (currRow < lastRow) {
                    final int newRow = currRow + 1;
                    final int newCol = currCol;
                    final int newK = currK - grid[newRow][newCol];
                    if (newK >= 0 && (maxK[newRow][newCol] == null || newK > maxK[newRow][newCol])) {
                        queue.offer(new int[] { newRow, newCol, newK });
                        maxK[newRow][newCol] = newK;
                    }
                }

                // add left
                if (currCol > 0) {
                    final int newRow = currRow;
                    final int newCol = currCol - 1;
                    final int newK = currK - grid[newRow][newCol];
                    if (newK >= 0 && (maxK[newRow][newCol] == null || newK > maxK[newRow][newCol])) {
                        queue.offer(new int[] { newRow, newCol, newK });
                        maxK[newRow][newCol] = newK;
                    }
                }

                // add up
                if (currRow > 0) {
                    final int newRow = currRow - 1;
                    final int newCol = currCol;
                    final int newK = currK - grid[newRow][newCol];
                    if (newK >= 0 && (maxK[newRow][newCol] == null || newK > maxK[newRow][newCol])) {
                        queue.offer(new int[] { newRow, newCol, newK });
                        maxK[newRow][newCol] = newK;
                    }
                }
            }
        }

        return -1;
    }
    
    private int recursive(int[][] grid, boolean[][] history, int m, int n, int count, int k, int currentMaxCount) {
        if (m >= grid.length || m < 0 || n >= grid[0].length || n < 0) {
            return -1;
        }
        
        if (history[m][n]) {
            return -1;
        }
        
        if (grid[m][n] == 1) {
            if (k == 0) return -1;
            --k;
        }
        
        if (m == grid.length - 1 && n == grid[0].length - 1) {
            return count;
        }
        
        if (count >= currentMaxCount) {
            return -1;
        }
        
        int min = Integer.MAX_VALUE;
        history[m][n] = true;
        int up = recursive(grid, history, m - 1, n, count + 1, k, min);
        if (up != -1) {
            min = Math.min(min, up);
        }
        int right = recursive(grid, history, m, n + 1, count + 1, k, min);
        if (right != -1) {
            min = Math.min(min, right);
        }
        
        int down = recursive(grid, history, m + 1, n, count + 1, k, min);
        if (down != -1) {
            min = Math.min(min, down);
        }
        
        int left = recursive(grid, history, m, n - 1, count + 1, k, min);
        if (left != -1) {
            min = Math.min(min, left);
        }
        
        history[m][n] = false;
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}