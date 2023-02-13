class Solution {
    public int countOdds(int low, int high) {
        boolean firstOdd = low % 2 != 0, secondOdd = high % 2 != 0;
        int diff = high - low;
        
        int sum = diff / 2;
        if (firstOdd && secondOdd) {
            sum -= 1;
        }
        sum += firstOdd ? 1 : 0;
        sum += secondOdd ? 1 : 0;
        
        return sum;
        
    }
}