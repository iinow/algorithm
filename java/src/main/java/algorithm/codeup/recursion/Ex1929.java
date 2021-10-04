package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex1929 {

    public static void main(String[] args) {
        new Ex1929().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        recursive(input);
    }

    public void recursive(int value) {
        if(value == 1) {
            System.out.println(value);
            return;
        }

        int result = isOdd(value) ? calculateOdd(value) : calculateEven(value);

        recursive(result);

        System.out.println(value);
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
