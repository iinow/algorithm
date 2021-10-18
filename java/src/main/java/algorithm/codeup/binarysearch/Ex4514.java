package algorithm.codeup.binarysearch;

import java.util.Scanner;

public class Ex4514 {
    public static void main(String[] args) {

    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int[] marbles = new int[scanner.nextInt()];
        int[][] temp = new int[marbles.length][marbles.length];
        int cntGroup = scanner.nextInt();

        for (int i = 0; i < marbles.length; i++) {
            marbles[i] = scanner.nextInt();
        }

        recursive(temp, marbles, 0);
    }

    public int recursive(int[][] temp, int[] marbles, int index) {
        while(true) {

        }
    }
}
