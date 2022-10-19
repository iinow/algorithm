import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        Set<String> temp = new HashSet<>();
        for (int i = 0; i < length - 2; i++) {
            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    String v = nums[i] + "," + nums[left] + "," + nums[right];
                    if (!temp.contains(v)) {
                        res.add(List.of(nums[i], nums[left], nums[right]));
                        temp.add(v);
                    }
                }
                if (sum <= 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return res;
    }
}