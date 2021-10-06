package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex1953 {

    public static void main(String[] args) {
        new Ex1953().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        recursive(n, 1);
    }

    public void recursive(int n, int start) {
        if(start > n) {
            return;
        }

        recursiveLine(start, 1);

        System.out.println();

        recursive(n, start + 1);
    }

    public void recursiveLine(int start, int index) {
        if(index > start) {
            return;
        }

        System.out.print("*");

        recursiveLine(start, index + 1);
    }
}
