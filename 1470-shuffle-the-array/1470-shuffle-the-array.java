class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            int index = i * 2;
            res[index] = nums[i];
            res[index + 1] = nums[i + n];
        }
        return res;
    }
}