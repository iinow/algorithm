class Solution {
    Set<Integer> set = new HashSet<>();
    
    public boolean isHappy(int n) {
        while(n != 1) {
            int res = cal(n);
            if (set.contains(res)) {
                return false;
            } else {
                set.add(res);
            }
            n = res;
        }
        return true;
    }
    
    private int cal(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .map(i -> (int) Math.pow(i, 2))
                .sum();
    }
}