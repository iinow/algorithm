class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, List<Integer>> map = Arrays.stream(nums)
                .mapToObj(i -> i)
                .collect(Collectors.groupingBy(i -> i));
        
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            int key = iter.next();
            List<Integer> list = map.get(key);
            if (list.size() == 1) {
                return key;
            }
        }
        return 0;
    }
}