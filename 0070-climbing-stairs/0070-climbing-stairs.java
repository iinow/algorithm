class Solution {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        
        int a = 3, b = 2, temp = 3;
        for (int i = 0; i < n - 3; i++) {
            temp = a;
            a += b;
            b = temp;
        }
        
        return a;
    }
}
