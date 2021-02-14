package algorithm.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=3129}
 * */
public class Ex3129 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		Stack<String> stack = new Stack<>();
		for(char c: str.toCharArray()) {
			stack.push(String.valueOf(c));
		}
		
		String copy = null;
		boolean collect = true;
		while(!str.isEmpty()) {
			copy = str.replaceAll("\\(\\)", "");
			if(copy.length() == str.length()) {
				collect = false;
				break;
			}else {
				str = copy;
			}
		}
		
		if(collect) {
			System.out.println("good");
		}else {
			System.out.println("bad");
		}
	}
}
