class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int jisu = 0;
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += (chars[i] - 'A' + 1) * Math.pow(26, jisu);
            jisu++;
        }
        return sum;
    }
}