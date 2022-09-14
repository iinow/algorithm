class Solution {
    public int majorityElement(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }
           
        Integer key = 0;
        Integer count = 0;
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            int k = iter.next();
            int v = map.get(k);
            if (count < v) {
                count = v;
                key = k;
            }
        }
        return key;
    }
}