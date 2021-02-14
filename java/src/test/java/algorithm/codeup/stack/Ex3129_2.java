package algorithm.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

public class Ex3129_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		boolean result = true;
		
		Stack<String> stack = new Stack<>();
		for(char c: str.toCharArray()) {
			String v = String.valueOf(c);
			if(v.equals("(")) {
				stack.push(v);
			}else {// ) 인 경우 
				if(stack.isEmpty()) {
					result = false;
					break;
				}
				String pre = stack.pop();
				if(pre.equals("(")) {
					continue;
				}else {
					result = false;
					break;
				}
			}
		}
		
		if(result && stack.isEmpty()) {
			System.out.println("good");
		}else {
			System.out.println("bad");
		}
	}
}
