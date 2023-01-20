class Solution {
    public int addDigits(int num) {
        while (num / 10 != 0) {
            num = loop(num);
        }

        return num;
    }

    private int loop(int num) {
        int sum = 0;
        int mok = 1;

        while (mok != 0) {
            mok = num / 10;
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}