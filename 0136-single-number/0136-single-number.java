class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num: nums) {
            if (map.get(num) == null) {
                map.put(num, false);
                continue;
            }
            map.put(num, true);
        }
        
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            int key = iter.next();
            if (!map.get(key)) {
                return key;
            }
        }
        return 1;
    }
}