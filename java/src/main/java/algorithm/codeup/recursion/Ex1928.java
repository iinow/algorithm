package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex1928 {

    public static void main(String[] args) {
        new Ex1928().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        recursive(input);
    }

    public void recursive(int value) {
        System.out.println(value);

        if(value == 1) {
            return;
        }

        int result = isOdd(value) ? calculateOdd(value) : calculateEven(value);

        recursive(result);
    }

    public boolean isOdd(int value) {
        return value % 2 == 1;
    }

    public int calculateOdd(int value) {
        return (3 * value) + 1;
    }

    public int calculateEven(int value) {
        return value / 2;
    }
}
