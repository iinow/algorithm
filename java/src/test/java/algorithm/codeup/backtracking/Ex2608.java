package algorithm.codeup.backtracking;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * {@link https://codeup.kr/problem.php?id=2608}
 * */
public class Ex2608 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = "O";
		}
		recursion(arr, 0);
	}
	
	private static Stack<String> stack = new Stack<>();
	
	public static void recursion(String[] arr, int i) {
		if(stack.size() == arr.length) {
			System.out.println(stack.stream().collect(Collectors.joining()));
			return;
		}
		
		stack.push(arr[i]);
		recursion(arr, i + 1);
		stack.pop();
		
		arr[i] = "X";
		stack.push(arr[i]);
		recursion(arr, i + 1);
		stack.pop();
		arr[i] = "O";
	}
}
