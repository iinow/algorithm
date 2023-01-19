class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int mid = length / 2;
        int start = 0;
        int last = length;
        
        while(true) {
            int midValue = nums[mid];
            if (midValue > target) {
                int index = mid / 2;
                if (index == mid) {
                    return -1;
                }
                last = mid;
                mid = index;
                continue;
            } 
            
            if (midValue < target) {
                int index = (mid + last) / 2;
                if (index == mid) {
                    return -1;
                }
                start = mid;
                mid = index;
                continue;
            }
            
            return mid;
        }
    }
}