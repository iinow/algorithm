package algorithm.codeup.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=4421}
 * */
public class Ex4421 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean[][] arr = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			char[] c = scanner.next().toCharArray();
			for(int j = 0; j < c.length; j++) {
				int v = Character.getNumericValue(c[j]);
				arr[i][j] = v == 0 ? false : true;
			}
		}
		scanner.close();

		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int r = dfs(arr, i, j);
				if(r > 0)
					res.add(r);
			}
		}
		Collections.sort(res);
		System.out.println(res.size());
		res.stream().forEach(v->System.out.println(v));
	}
	
	public static int dfs(boolean[][] arr, int i, int j) {
		if(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length) {
			return 0;
		}
		
		if(!arr[i][j]) {
			return 0;
		}
		arr[i][j] = false;
		
		int s = 1;
		s += dfs(arr, i, j - 1);
		s += dfs(arr, i, j + 1);
		s += dfs(arr, i - 1, j);
		s += dfs(arr, i + 1, j);
		
		return s;
	}
}
