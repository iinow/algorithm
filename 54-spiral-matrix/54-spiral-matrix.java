class Solution {
    /**
    * 우 -> 하 -> 왼 -> 상 -> 우 반복
    */
    private List<Integer> list = new ArrayList<>();
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int c = matrix.length * matrix[0].length;
        List<Integer> spiral = new ArrayList<>(c);
        int i = 0;
        int j = 0;
        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;
        int rightLimit = matrix[0].length;
        int downLimit = matrix.length;
        int leftLimit = -1;
        int upLimit = 0;

        for (int x = 0; x < c; x++) {
            spiral.add(matrix[i][j]);
            if (right) {
                if (j + 1 == rightLimit) {
                    rightLimit--;
                    down = true;
                    right = false;
                    i++;
                } else
                    j++;
                continue;
            }
            if (down) {
                if (i + 1 == downLimit) {
                    downLimit--;
                    down = false;
                    left = true;
                    j--;
                } else
                    i++;
                continue;
            }
            if (left) {
                if (j - 1 == leftLimit) {
                    leftLimit++;
                    left = false;
                    up = true;
                    i--;
                } else
                    j--;
                continue;
            }
            if (up) {
                if (i - 1 == upLimit) {
                    upLimit++;
                    up = false;
                    right = true;
                    j++;
                } else
                    i--;
                continue;
            }
        }
        return spiral;
    }
}