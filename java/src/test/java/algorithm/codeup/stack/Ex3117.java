package algorithm.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author BISHOP
 * {@link https://codeup.kr/problem.php?id=3117}	
 */
public class Ex3117 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			int v = scanner.nextInt();
			if(v == 0) {
				if(stack.isEmpty() == false) {
					stack.pop();
				}
			}else {
				stack.push(v);
			}
		}
		
		System.out.println(stack.stream().mapToInt(i->i).sum());
	}
}
