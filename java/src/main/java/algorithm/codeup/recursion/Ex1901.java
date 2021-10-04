package algorithm.codeup.recursion;

import java.util.Scanner;

/**
 * @link https://codeup.kr/problem.php?id=1901
 */
public class Ex1901 {

    public static void main(String[] args) {
        new Ex1901().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        print(max, 1);
    }

    public void print(int max, int value) {
        if(value > max) {
            return;
        }

        System.out.println(value);

        print(max, value + 1);
    }
}
