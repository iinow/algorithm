package algorithm.codeup.stack;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=3022}
 * */
public class Ex3022 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInteger a = new BigInteger(scanner.next());
		BigInteger b = new BigInteger(scanner.next());
		
		System.out.println(a.subtract(b).toString());
	}
}
