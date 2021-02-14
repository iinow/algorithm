package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=2633}
 * */
public class Ex2633 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			if(value >= k) {
				System.out.println((i+1));
				return;
			}
		}
		
		System.out.println((n+1));
	}
}
