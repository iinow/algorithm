class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int x = image.length, y = image[0].length;
        boolean[][] b = new boolean[x][y];
        recursive(image, b, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    private void recursive(int[][] image, boolean[][] history, int x, int y, int color, int preColor) {
        if (history.length <= x || history[0].length <= y || x < 0 || y < 0) {
            return;
        }
        
        if (history[x][y]) {
            return;
        }
        
        if (image[x][y] != preColor) {
            return;
        }
        
        image[x][y] = color;
        history[x][y] = true;
        
        recursive(image, history, x + 1, y, color, preColor);
        recursive(image, history, x, y - 1, color, preColor);
        recursive(image, history, x, y + 1, color, preColor);
        recursive(image, history, x - 1, y, color, preColor);
    }
}