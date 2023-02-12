class Solution {
    public void setZeroes(int[][] matrix) {
        int x = matrix.length, y = matrix[0].length;
        boolean[][] temp = new boolean[x][y];
        Set<String> history = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0 && !temp[i][j]) {
                    if (!history.contains("r" + i)) {
                        if (!temp[i][j]) {
                            for (int a = 0; a < y; a++) {
                                if (matrix[i][a] != 0) {
                                    temp[i][a] = true;
                                }
                                matrix[i][a] = 0;
                            }
                            history.add("r" + i);
                        }
                    }

                    if (!history.contains("c" + j)) {
                        if (!temp[i][j]) {
                            for (int a = 0; a < x; a++) {
                                if (matrix[a][j] != 0) {
                                    temp[a][j] = true;
                                }
                                matrix[a][j] = 0;
                            }
                            history.add("c" + j);
                        }
                    }
                }
            }
        }
    }
}