package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=2625}
 * */
public class Ex2625 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int sum = 0;
		for(int a = (int) Math.ceil((double)length / 3); a < Math.ceil((double)length / 2); a++) {
			for(int b = (int) Math.ceil((length - a) / (double)2); b <= a; b++) {
				System.out.println(a+", "+b);
				int c = length - (a + b);
				if(b + c > a) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}
