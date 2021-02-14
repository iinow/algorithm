package algorithm.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=1714}
 * */
public class Ex1714 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] cs = s.toCharArray();
        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < cs.length; i++){
            stack.push(String.valueOf(cs[i]));
        }
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
	}
}
