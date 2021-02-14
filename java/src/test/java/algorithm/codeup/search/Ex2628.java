package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=2628}
 * */
public class Ex2628 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		
		int max1 = a > b ? a : b;
		int min1 = a > b ? b : a;
		
		if((min1 < c && c < max1) && (min1 > d || d > max1)) {
			System.out.println("cross");
			return;
		}
		
		if((min1 < d && d < max1) && (min1 > c || c > max1)) {
			System.out.println("cross");
			return;
		}
		
		System.out.println("not cross");
	}
}
