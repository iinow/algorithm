package algorithm.codeup.search;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=4880}
 * */
public class Ex4880 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		//(0, 1) = 도보, (2, 3) = 자전거
		int[][] arr = new int[n][4];
		
		for(int i = 0; i < n; i++) {
			int walkmin = scanner.nextInt();
			int walkmon = scanner.nextInt();
			int bikemin = scanner.nextInt();
			int bikemon = scanner.nextInt();
			
			arr[i][0] = walkmin;
			arr[i][1] = walkmon;
			
			arr[i][2] = bikemin;
			arr[i][3] = bikemon;
		}
		
		int max = dfs(arr, 0, n, k);
		System.out.println(max);
	}
	
	static Stack<Integer> stackMin = new Stack<Integer>();
	static Stack<Integer> stackMon = new Stack<Integer>();
	
	public static int dfs(int[][] arr, int index, int n, int k) {
		if(stackMin.size() == n || stackMon.size() == n) {
			int sum = stackMin.stream().mapToInt(i->i).sum();
			if(sum > k) {
				return 0;
			}
			return stackMon.stream().mapToInt(i->i).sum();
		}
		int max = 0;
		
		stackMin.push(arr[index][0]);
		stackMon.push(arr[index][1]);
		
		max = dfs(arr, index + 1, n, k);
		
		stackMin.pop();
		stackMon.pop();
	
		stackMin.push(arr[index][2]);
		stackMon.push(arr[index][3]);
		
		int v = dfs(arr, index + 1, n, k);
		max = max > v ? max : v;
		
		stackMin.pop();
		stackMon.pop();
		return max;
	}
}
