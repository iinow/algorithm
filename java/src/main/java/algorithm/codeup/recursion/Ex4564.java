package algorithm.codeup.recursion;

import java.util.Scanner;

/** 5계단
 * 10(1), 20(2), 15(3), 25(4), 10(5)
 * f(0) = 0
 * f(1) = 10
 * f(2) = 30
 * f(n) = Math.max(f(n - 3) + stairs[n - 1], f(n - 2)) + stairs[n]
 *
 * ex)
 * f(3) = Math.max(f(0) + stairs[2], f(1)) + stairs[3]
 * f(
 */
public class Ex4564 {

    public static void main(String[] args) {
        new Ex4564().solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[scanner.nextInt() + 1];
        int[] maxScores = new int[scores.length];

        for(int i = 1; i <= scores.length - 1; i++) {
            scores[i] = scanner.nextInt();
        }

        int res = recursive(scores.length - 1, scores, maxScores);
        System.out.printf("%d%n", res);
    }

    public int recursive(int n, int[] scores, int[] maxScores) {
        if(n <= 0) {
            return 0;
        }

        if(maxScores[n] != 0) {
            return maxScores[n];
        }

        if(n == 1) {
            return maxScores[n] = scores[n];
        }

        if(n == 2) {
            return maxScores[n] = scores[n] + scores[n - 1];
        }

        int a = recursive(n - 3, scores, maxScores) + scores[n - 1];
        int b = recursive(n - 2, scores, maxScores);

        return maxScores[n] = Math.max(a, b) + scores[n];
    }
}
