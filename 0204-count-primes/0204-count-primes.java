class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int result = 0;
        for (int i = 2; i < n; ++i) {
            if (primes[i]) {
                result++;
                for (int j = i * 2; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return result;
    }
}