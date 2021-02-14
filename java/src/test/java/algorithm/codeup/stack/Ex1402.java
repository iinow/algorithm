package algorithm.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=1402}
 * */
public class Ex1402 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++) {
			stack.push(scanner.nextInt());
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
}
