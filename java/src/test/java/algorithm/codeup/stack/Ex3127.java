package algorithm.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=3127}
 * */
public class Ex3127 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] ss = scanner.nextLine().split(" ");
		Stack<String> stack = new Stack<>();
		
		for(String s : ss) {
			if(s.equals("*")) {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(b*a));
			}else if(s.equals("+")) {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(b+a));
			}else if(s.equals("-")) {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(b-a));
			}else {
				stack.push(s);
			}
		}
		
		System.out.println(stack.toString());
	}
}
