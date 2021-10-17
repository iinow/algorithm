package algorithm.codeup.binarysearch;

import java.util.Scanner;

public class Ex2655 {
    public static void main(String[] args) {
        new Ex2655().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.printf("%.4f%n", (-b / a));
    }
}
