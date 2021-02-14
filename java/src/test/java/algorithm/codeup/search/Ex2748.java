package algorithm.codeup.search;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * {@link https://codeup.kr/problem.php?id=2748}
 * 
 * 깊이우선탐색으로 처리함
 * */
public class Ex2748 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		int[] arr = new int[m];
		
		for(int i = 0; i < m; i++) {
			arr[i] = scanner.nextInt();
		}
		
		int cnt = dfs(arr, 0, n);
		System.out.println(cnt);
	}
	
	public static int dfs(int[] arr, int index, int n) {
		if(arr.length == index) {
			int sum = Arrays.stream(arr).sum();
			System.out.println(Arrays.stream(arr).mapToObj(i->i).collect(Collectors.toList()).toString());
			if(sum == n) {
				return 1;
			}
			return 0;
		}
		int sum = 0;
		sum += dfs(arr, index+1, n);
		arr[index] = -arr[index];
		sum += dfs(arr, index+1, n);
		return sum;
	}
}
