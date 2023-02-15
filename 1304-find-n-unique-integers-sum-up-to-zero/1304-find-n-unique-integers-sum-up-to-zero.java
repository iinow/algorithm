class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = (i + 1) * -1;
            arr[arr.length - 1 - i] = (i + 1);
        }
        return arr;
    }
}