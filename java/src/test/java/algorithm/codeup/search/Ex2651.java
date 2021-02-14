package algorithm.codeup.search;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=2651}
 * 
 * 순열 문제임
 * 
 * nCr = n! / ((n - r)! * r!) 
 * */
public class Ex2651 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		BigInteger res = victorial(new BigInteger(String.valueOf(n))).divide(victorial(new BigInteger(String.valueOf(n-k))).multiply(victorial(new BigInteger(String.valueOf(k)))));
		System.out.println(res.toString());
	}
	
	public static BigInteger victorial(BigInteger v) {
		if(v.compareTo(new BigInteger("1")) < 1) {
			return new BigInteger("1");
		}
		return v.multiply(victorial(v.subtract(new BigInteger("1"))));
	}
}
