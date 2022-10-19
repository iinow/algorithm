import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - closest) > Math.abs(sum - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closest;
    }
}