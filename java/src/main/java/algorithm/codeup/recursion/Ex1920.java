package algorithm.codeup.recursion;

import java.util.Scanner;

public class Ex1920 {

    public static void main(String[] args) {
        new Ex1920().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if(input < 2) {
            System.out.println(input);
        } else {
            recursive(input / 2, input % 2);
        }
    }

    public void recursive(int mok, int rest) {
        if(mok <= 1) {
            System.out.print(mok + "" + rest);
            return;
        }

        recursive(mok / 2, mok % 2);

        System.out.print(rest);
    }
}
