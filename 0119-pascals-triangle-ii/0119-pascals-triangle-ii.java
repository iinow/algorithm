class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
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
        return res.get(res.size() - 1);
    }
}
