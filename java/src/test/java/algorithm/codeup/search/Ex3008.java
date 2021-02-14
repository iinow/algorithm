package algorithm.codeup.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=3008}
 * */
public class Ex3008 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			int value = scanner.nextInt();
			arr[i] = value;
			sum += value;
		}
		boolean b = false;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(sum - arr[i] - arr[j] == 100) {
					b = true;
					arr[i] = 0;
					arr[j] = 0;
					break;
				}
			}
			if(b) {
				break;
			}
		}
		
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				continue;
			}
			System.out.println(arr[i]);
		}
	}
}
