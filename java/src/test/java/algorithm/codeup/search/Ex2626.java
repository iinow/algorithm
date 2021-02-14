package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=2626}
 * */
public class Ex2626 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();

		//9 -> 3, 3, 3 - 4, 3, 2 - 4, 4, 2
		//8 -> 3, 3, 2
		int cnt = 0;
		for(int i = (int) Math.ceil(length / (double)3); i < Math.ceil(length / (double)2); i++) {
			System.out.println(i);
			cnt += i - (int) Math.ceil((length - i) / (double)2) + 1; 
		}
		System.out.println(cnt);
	}
}
