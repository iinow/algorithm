package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=3506}
 * 
 * 피보나치 문제
 * 
 * 메모라이저로 풀이함
 * */
public class Ex3506 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] arr = {1,2};
		System.out.println(fivo(arr, n));
	}
	
	public static int fivo(int[] arr, int n) {
		if(n == 1 || n == 2) {
			return arr[n - 1];
		}
		
		for(int i = 3; i <= n; i++) {
			int sum = arr[0] + arr[1];
			arr[0] = arr[1];
			arr[1] = sum;
		}
		return arr[1];
	}
}
