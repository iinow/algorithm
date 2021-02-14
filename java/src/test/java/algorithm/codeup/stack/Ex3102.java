package algorithm.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=3102}
 * */
public class Ex3102 {
	public static void main(String[] args) {
		String ss = "push( 123 )";
		System.out.println(ss.split("\\d+")[0]);
		
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i <= n; i++) {
			String command = scanner.nextLine();
			command(command, stack);
		}
	}
	
	public static void command(String str, Stack<Integer> stack) {
		switch(str) {
			case "top()": {
				if(stack.isEmpty()) {
					System.out.println("-1");
				}else
					System.out.println(stack.peek());
				break;
			}
			case "pop()": {
				if(stack.isEmpty() == false)
					stack.pop();
				break;
			}
			case "size()": {
				System.out.println(stack.size());
				break;
			}
			case "empty()": {
				System.out.println(stack.empty());
				break;
			}
			default: {
				if(str.isEmpty())
					return;
				String s = str.split("\\d+")[0];
				int v = Integer.parseInt(String.valueOf(str.subSequence(s.length(), str.length() - 2)));
            	stack.push(v);
	            break;
			}
		}
	}
}
