package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex1912 {

    public static void main(String[] args) {
        new Ex1912().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        System.out.println(recursive(value));
    }

    public int recursive(int value) {
        if(value == 0) {
            return 1;
        }

        return value * recursive(value - 1);
    }
}
