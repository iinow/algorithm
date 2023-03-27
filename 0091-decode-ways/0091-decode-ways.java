class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numberOfWays(s, 0, dp);
    }

    private int numberOfWays(String string, int index, int[] dp) {
        if (index >= string.length()) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int ways = 0;
        for (int i = 1; i <= 2; i++) {
            if (index + i <= string.length() && isValid(string.substring(index, index + i))) {
                ways += numberOfWays(string, index + i, dp);
            }
        }
        dp[index] = ways;
        return dp[index];
    }

    private boolean isValid(String string) {
        if (string.length() == 0 || string.charAt(0) == '0') {
            return false;
        }
        int value = Integer.parseInt(string);
        return value >= 1 && value <= 26;
    }
}