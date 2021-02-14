package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=5126}
 * */
public class Ex5126 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[8];
		
		for(int i = 0; i < 8; i++) {
			arr[i] = scanner.nextInt();
		}
		recurse(arr, 0, 0);
		System.out.println(min);
	}
	
	static int min = 99;
	
	public static void recurse(int[] arr, int index, int cnt) {
		if(index > arr.length - 1) {
			for(int i : arr) {
				if(i == 1) {
					return;
				}
				
			}
			min = min > cnt ? cnt : min;
			return;
		}
		
		recurse(arr, index + 1, cnt);
		revers(arr, index);
		
		recurse(arr, index + 1, cnt + 1);
		revers(arr, index);
		return;
	}
	
	public static void revers(int[] arr, int index) {
		if(index == 0) {
			arr[index] = 1 - arr[index];
			arr[index + 1] = 1 - arr[index + 1];
			return;
		}else if(index == arr.length - 1) {
			arr[index - 1] = 1 - arr[index - 1];
			arr[index] = 1 - arr[index];
			return;
		}
		arr[index - 1] = 1 - arr[index - 1];
		arr[index] = 1 - arr[index];
		arr[index + 1] = 1 - arr[index + 1];
	}
}
