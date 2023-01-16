class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] > b[0]) return 1;
            if (a[0] < b[0]) return -1;
            return 0;
        });
        
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (list.isEmpty()) {
                list.add(current);
                continue;
            }
            
            int[] last = list.get(list.size() - 1);
            
            if (current[1] <= last[1]) {
                continue;
            }
            
            if (current[0] <= last[1]) {
                last[1] = current[1];
                continue;
            }
            
            list.add(current);
        }
        
        return list.toArray(new int[][]{});
    }
}