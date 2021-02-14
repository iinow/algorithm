package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=5123}
 * */
public class Ex5123 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if((arr[i] + arr[j]) % 3 == 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
