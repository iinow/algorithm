package algorithm.codeup.stack;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=4654}
 * */
public class Ex4654 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] arr = new int[n];
		int[] answer = new int[n];
		
		for(int i = 0; i < n; i++) {
			int height = scanner.nextInt();
			arr[i] = height;
		}
		
		
		for(int i = arr.length - 1; i > 0; i--) {
			int h = arr[i];
			for(int j = i - 1; j >= 0; j--) {
				int hh = arr[j];
				
				if(hh > h) {
					answer[i] = j + 1;
					break;
				}
			}
		}
		
		for(int i: answer) {
			System.out.print(i+" ");
		}
	}
}
