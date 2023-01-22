class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        int a = 1, b = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int temp = a;
            a = a + b;
            b = temp;
        }
        
        return a;
    }
}