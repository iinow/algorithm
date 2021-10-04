package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex1915 {

    public static void main(String[] args) {
        new Ex1915().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int startIndex = 2;

        System.out.println(recursive(input, startIndex, 0, 1, 1));
    }

    public int recursive(int input, int startIndex, int value, int first, int second) {
        if(input <= 2) {
            return 1;
        }

        if(input == startIndex) {
            return value;
        }

        int sum = first + second;

        return recursive(input, startIndex + 1, sum, second, sum);
    }
}
