class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (sum < prices[i] - min) {
                sum = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        
        return sum;
    }
}