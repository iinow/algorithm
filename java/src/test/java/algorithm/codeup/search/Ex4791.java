package algorithm.codeup.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=4791}
 * */
public class Ex4791 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int m = scanner.nextInt();	//사대 수
		int n = scanner.nextInt();	//동물 수
		int l = scanner.nextInt();	//사정거리
		
		int[] arr = new int[m];
		int cnt = 0;
		
		//사대 위치
		for(int i = 0; i < m; i++) {
			int x = scanner.nextInt();
			arr[i] = x;
		}
		
		Arrays.sort(arr);
		//동물 위치
		for(int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int index = binarySearch(arr, x, 0, arr.length - 1);
			if(arr[index] - l <= x && x <= arr[index] + l) {
				int xx = Math.abs(arr[index] - x);
				if(l - xx >= y) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	public static int binarySearch(int[] arr, int x, int start, int end) {
		int mid = (start + end) / 2;
		int diff = Math.abs(start - end);
		if(diff == 0) {
			return start;
		}else if(diff == 1) {
			int diffA = Math.abs(arr[start] - x);
			int diffB = Math.abs(arr[end] - x);
			return diffA > diffB ? end : start;
		}
		
		int index = mid;
		if(arr[mid] > x) {
			index = binarySearch(arr, x, start, mid);
		}else if(arr[mid] < x) {
			index = binarySearch(arr, x, mid, end);
		}
		return index;
	}
}
