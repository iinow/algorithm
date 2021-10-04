package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex1902 {

    public static void main(String[] args) {
        new Ex1902().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        print(max, max);
    }

    public void print(int max, int value) {
        if(value == 0) {
            return;
        }

        System.out.println(value);

        print(max, value - 1);
    }
}
