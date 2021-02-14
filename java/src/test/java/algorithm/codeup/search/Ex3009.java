package algorithm.codeup.search;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=3009}
 * 
 * 순열이 아닌 조합 문제..
 * */
public class Ex3009 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			int v = scanner.nextInt();
			arr[i] = v;
		}
		int cnt = combination(arr, 0, arr.length, s);
		System.out.println(cnt);
	}
	
	static Stack<Integer> stack = new Stack<>();
	
	public static int combination(int[] arr, int index, int r, int s) {
		if(r == 0 || index >= arr.length) {
			if(stack.stream().mapToInt(i->i).sum() == s && !stack.isEmpty()) {
				return 1;
			}
			return 0;
		}
		int cnt = 0;
		
		stack.push(arr[index]);
		cnt += combination(arr, index + 1, r - 1, s);
		
		stack.pop();
		cnt += combination(arr, index + 1, r, s);
		
		return cnt;
	}
}
