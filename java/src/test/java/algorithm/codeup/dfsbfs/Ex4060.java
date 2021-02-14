package algorithm.codeup.dfsbfs;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=4060}
 * */
public class Ex4060 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		boolean[][] darkArr = new boolean[m][n];
		boolean[][] lightArr = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				darkArr[i][j] = scanner.nextInt() == 0 ? false : true;
				lightArr[i][j] = darkArr[i][j]; 
			}
		}
		int l = 0, d = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(recurse(lightArr, i, j, true)) l++;
				if(recurse(darkArr, i, j, false)) d++;
			}
		}
		System.out.println(l+" "+d);
	}
	
	public static boolean recurse(boolean[][] arr, int i, int j, boolean light) {
		if(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length) {
			return false;
		}
		
		if(arr[i][j] == light) {
			return false;
		}
		arr[i][j] = light;
		boolean update = true;
		recurse(arr, i - 1, j, light);
		recurse(arr, i + 1, j, light);
		recurse(arr, i, j - 1, light);
		recurse(arr, i, j + 1, light);
		
		return update;
	}
}
