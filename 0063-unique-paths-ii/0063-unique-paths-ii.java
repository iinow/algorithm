class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xLength = obstacleGrid.length, yLength = obstacleGrid[0].length;
        int[][] temp = new int[xLength][yLength];
        for (int i = 0; i < xLength; i++) {
            if (obstacleGrid[i][0] == 0) temp[i][0] = 1;
            else continue;
            if (i == 0) continue;
            temp[i][0] = temp[i - 1][0];
        }
        
        for (int i = 0; i < yLength; i++) {
            if (obstacleGrid[0][i] == 0) temp[0][i] = 1;
            else continue;
            if (i == 0) continue;
            temp[0][i] = temp[0][i - 1];
        }
        
        for (int x = 1; x < xLength; x++) {
            for (int y = 1; y < yLength; y++) {
                if (obstacleGrid[x][y] == 1) {
                    continue;
                }
                temp[x][y] = temp[x][y - 1] + temp[x - 1][y];
            }
        }
        
        return temp[xLength - 1][yLength - 1];
    }
}