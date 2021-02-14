package algorithm.codeup.backtracking;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=3510}
 * */
public class Ex3510 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int b = scanner.nextInt();
		int n = scanner.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			int v = scanner.nextInt();
			arr[i] = v;
		}
		dfs(arr, 0, b);
		System.out.println(max);
	}
	
	private static Stack<Integer> stack = new Stack<>();
	private static int max = Integer.MIN_VALUE;
	
	public static void dfs(int[] arr, int index, int b) {
		int sum = stack.stream().mapToInt(i->i).sum();
		if(max <= sum && sum <= b) {
			max = sum;
		}
		
		if(sum > b) {
			return;
		}
		
		if(index >= arr.length) {
			return;
		}
		
		stack.push(arr[index]);
		dfs(arr, index + 1, b);
		stack.pop();
		
		dfs(arr, index + 1, b);
		
		return;
	}
}
