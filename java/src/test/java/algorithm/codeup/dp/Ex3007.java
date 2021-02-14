package algorithm.codeup.dp;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=3007}
 * */
public class Ex3007 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] arr = new int[n+1];

		for(int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + scanner.nextInt();
		}
		
		for(int j = 0; j < m; j++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int sum = arr[b] - arr[a - 1];
			System.out.println(sum);
		}
	}
}
