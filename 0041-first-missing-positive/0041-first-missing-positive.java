class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Boolean> map = new TreeMap<>();
        for(int num: nums) {
            if (num <= 0) {
                continue;
            }
            map.put(num, true);
        }
        
        int count = 0;
        int key = 0;
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            key = iter.next();
            count++;
            if (count == 1 && key > 1) {
                return 1;
            }
            if (key - 1 != 0 && !map.containsKey(key - 1)) {
                return key - 1;
            }
            if (map.containsKey(key + 1)) {
                continue;
            } else {
                return key + 1;
            }
        }
        return key - 1 <= 0 ? key + 1 : 1;
    }
}