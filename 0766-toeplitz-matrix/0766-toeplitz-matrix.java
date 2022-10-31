class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m - 1; i++) {
            if (!recursive(matrix, i, 0, matrix[i][0])) {
                return false;
            }
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (!recursive(matrix, 0, i, matrix[0][i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean recursive(int[][] matrix, int m, int n, final int value) {
        if (m >= matrix.length || n >= matrix[0].length) return true;
        if (matrix[m][n] != value) return false;
        return recursive(matrix, m + 1, n + 1, value);
    }
}