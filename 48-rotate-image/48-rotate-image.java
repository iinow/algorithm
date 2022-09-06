class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] results = new int[length][length];

		for (int i = 0; i < length; i++) {
			int y = length - 1 - i;
			for (int j = 0; j < length; j++) {
				results[j][y] = matrix[i][j];
			}
		}
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = results[i][j];
            }
        }
    }
}