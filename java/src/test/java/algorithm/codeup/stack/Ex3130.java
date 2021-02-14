package algorithm.codeup.stack;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=3130}
 * */
public class Ex3130 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		BigInteger sum = new BigInteger("0");
		
		for(int i = 0; i < n; i++) {
			int height = scanner.nextInt();
			while(!stack.isEmpty() && stack.peek() < height)
				stack.pop();
			if(stack.isEmpty() || stack.peek() > height) {
				stack.push(height);
			}
			sum = sum.add(new BigInteger(String.valueOf(stack.size() - 1)));
		}
		
		System.out.println(sum);
	}
}
