package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=2631}
 * */
public class Ex2631 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int find = 0;
		int index = 0;
		int sum = 0;
		int[] arr = new int[n];

		for(int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			arr[i] = value;
		}
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(sum == k) {
				find++;
			}else if(sum > k) {
				while(sum > k) {
					sum -= arr[index++];
				}
				if(sum == k) {
					find++;
				}
			}
		}
		System.out.println(find);
	}
}
