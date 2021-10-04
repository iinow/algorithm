package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex1904 {

    public static void main(String[] args) {
        new Ex1904().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);

        recursive(start, end, start);
    }

    public void recursive(int start, int end, int value) {
        if(value > end) {
            return;
        }

        if(isOdd(value)) {
            System.out.print(value + " ");
        }

        recursive(start, end, value + 1);
    }

    public boolean isOdd(int value) {
        return value % 2 == 1;
    }
}
