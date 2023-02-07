class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                if (right == mid) return left;
                right = mid;
                continue;
            } else if (nums[mid] < target) {
                if (left == mid) return right;
                left = mid;
                continue;
            }
            return mid;
        }
        
        return 0;
    }
}