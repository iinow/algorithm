class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        
        // if size less than 4 - invalid
        if(size < 4 || size == 0)
            return res;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-3;i++) {
            
            //skipping duplicates
            if(i> 0 && nums[i] == nums[i-1])
                continue;
            
            for(int j=i+1;j<nums.length-2;j++) {
                
                //skipping duplicates
                if(j> i+1 && nums[j] == nums[j-1])
                    continue;
                
                int left = j+1;
                int right = size-1;
                
                while(left < right) {
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    
                    if(sum == (long) target)
                    {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        
                        while(left<right && nums[left] == nums[left-1]) left++;
                        while(left<right && nums[right] == nums[right+1]) right--;
                    }
                    
                    else if(sum > target)
                        right--;
                    else
                        left++;
                }
                
            }
        }
        
        return res;
        
    }
}