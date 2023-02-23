class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        
        int i2 = 0, i3 = 0, i5 = 0;
        int v2 = 2, v3 = 3, v5 = 5;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(v2, Math.min(v3, v5));
            
            if (arr[i] == v2) {
                v2 = 2 * arr[++i2];
            }
            if (arr[i] == v3) {
                v3 = 3 * arr[++i3];
            }
            if (arr[i] == v5) {
                v5 = 5 * arr[++i5];
            }
        }
        return arr[arr.length - 1];
    }
}