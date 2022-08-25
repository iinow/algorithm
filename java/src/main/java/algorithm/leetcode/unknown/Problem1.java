package algorithm.leetcode.unknown;

public class Problem1 {

    public static void main(String[] args) {
        var solution = new Solution();
        int[] nums = { 2, 7, 11, 15 };
        var target = 9;

        var result = solution.twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return null;
        }
    }
}
