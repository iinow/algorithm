package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=2650}
 * 
 * 최대공약수 문제 풀이
 * */
public class Ex2650 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int min = Math.min(Math.min(a, b), c);
		int res = 1;
		for(int i = min; i >= 2; i--) {
			int aa = a % i;
			if(aa != 0) {
				continue;
			}
			
			int bb = b % i;
			if(bb != 0) {
				continue;
			}
			
			int cc = c % i;
			if(cc != 0) {
				continue;
			}
			a /= i;
			b /= i;
			c /= i;
			res *= i;
		}
		System.out.println(res);
	}
}
