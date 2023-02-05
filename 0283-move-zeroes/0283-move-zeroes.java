class Solution {
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        
        int j = 0;
        for (int num: nums) {
            if (num != 0) {
                temp[j] = num;
                j++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}