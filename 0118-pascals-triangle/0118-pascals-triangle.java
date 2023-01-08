class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (res.size() == 0) {
                res.add(List.of(1));
                continue;
            }
            
            List<Integer> newList = new ArrayList<>();
            List<Integer> pre = res.get(res.size() - 1);
            newList.add(1);
            if (pre.size() != 1) {
                for (int a = 0; a < pre.size() - 1; a++) {
                    newList.add(pre.get(a) + pre.get(a + 1));
                }
            }
            
            newList.add(1);
            res.add(newList);
        }
        return res;
    }
}