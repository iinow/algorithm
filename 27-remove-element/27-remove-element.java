class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int length = 1;
        boolean escape = false;
        while(index <= nums.length - 1) {
            if (nums[index] == val) {
                for (int i = index + 1; i < nums.length; i++) {
                    if (nums[i] != val) {
                        int temp = nums[index];
                        nums[index] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                    if (i == nums.length - 1) {
                        escape = true;
                        break;
                    }
                }
            }
            if (escape) break;
            index++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return nums.length;
    }
}