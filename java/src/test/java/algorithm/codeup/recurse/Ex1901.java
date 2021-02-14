package algorithm.codeup.recurse;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=1901}
 * */
public class Ex1901 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		
		printValue(1, value);
	}
	
	public static void printValue(int value, int max) {
		if(value > max) {
			return;
		}
		System.out.println(value);
		printValue(++value, max);
	}
}
