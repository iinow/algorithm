package algorithm.codeup.relation;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=1905}
 * */
public class Ex1905 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(recurse(n));
	}
	public static int recurse(int n) {
		if(n == 1) {
			return 1;
		}
		return n + recurse(--n);
	}
}
