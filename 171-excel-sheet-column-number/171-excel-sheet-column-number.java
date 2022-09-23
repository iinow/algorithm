class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        char[] array = columnTitle.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ss = array[i];
            int gisu = array.length - 1 - i;
            int value = (int) Math.pow(26, gisu);
            sum += (value * (((int) ss) - 64));
        }
        return sum;
    }
}