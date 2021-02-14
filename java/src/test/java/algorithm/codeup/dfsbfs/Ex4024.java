package algorithm.codeup.dfsbfs;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=4024}
 * */
public class Ex4024 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int w = scanner.nextInt();
		int h = scanner.nextInt();
		String[][] arr = new String[h][w];
		boolean[][] exists = new boolean[h][w];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				arr[i][j] = scanner.next();
			}
		}
		int cnt = 0;
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(arr[i][j].equals("L")) {
					try {
						if(notExist(arr, exists, w, h, i, j)) {
							cnt++;
							continue;
						}
					} catch (Exception e) {
						
					}
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean notExist(String[][] arr, boolean[][] exists, final int w, final int h, int i, int j) throws Exception {
		if(i < 0 || i >= h || j < 0 || j >= w) {
			return false; 
		}
		if(arr[i][j].equals(".")) {
			return false;
		}
		
		if(exists[i][j]) {
			return false;
		}
		
		boolean e = false;
		if(arr[i][j].equals("L") && !exists[i][j]) {
			exists[i][j] = true;
			e = true;
		}
		e = e | notExist(arr, exists, w, h, i + 1, j);
		e = e | notExist(arr, exists, w, h, i + 1, j - 1);
		e = e | notExist(arr, exists, w, h, i + 1, j + 1);
		e = e | notExist(arr, exists, w, h, i, j - 1);
		e = e | notExist(arr, exists, w, h, i, j + 1);
		e = e | notExist(arr, exists, w, h, i - 1, j);
		e = e | notExist(arr, exists, w, h, i - 1, j - 1);
		e = e | notExist(arr, exists, w, h, i - 1, j + 1);
		
		return e;
	}
}
