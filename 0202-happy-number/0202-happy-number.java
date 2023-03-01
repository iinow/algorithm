class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (true) {
            if (n == 0) {
                if (sum == 1) return true;
                if (set.contains(sum)) break;
                n = sum;
                set.add(sum);
                sum = 0;
                continue;
            }
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return false;
    }
}