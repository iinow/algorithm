class Solution {
    public int reverse(int value) {
        if (value == 0) {
            return 0;
        }
        boolean minus = value < 0;
        char[] chars = String.valueOf(Math.abs(value + 0L)).toCharArray();
        StringBuffer buffer = new StringBuffer();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (i == chars.length - 1 && chars[i] == '0') {
                continue;
            }

            buffer.append(chars[i]);
        }
        long v = Long.parseLong(buffer.toString()) * (minus ? -1 : 1);
        if (-Math.pow(2, 31) > v) {
            return 0;
        }
        if (Math.pow(2, 31) - 1 < v) {
            return 0;
        }
        return (int) v;
    }
}