package algorithm.codeup.search;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=2641}
 * 
 * 안좋음.. 통과이긴 하지만 좀 바꿔야함
 * */
public class Ex2641 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		int value = 1;
		boolean up = false;
		
		while(true) {
			if(up) {
				if(stack.isEmpty()) {
					break;
				}
				value = stack.pop() + 1;
				
				if(stack.size() > 1 && value == 3) {
					if(stack.peek() == 3 || stack.get(stack.size() - 2) == 3) {
						value = 1;
						continue;
					}
				}
				
				if(stack.size() > 0 && value == 3) {
					if(stack.peek() == 3) {
						value = 1;
						continue;
					}
				}
				
				if(value > 3) {
					value = 1;
					continue;
				}
				up = false;
			}
			
			stack.push(value);
			value = 1;
			
			int sum = stack.stream().mapToInt(v->v).sum();
			
			if(sum == n) {
				System.out.println(stack.toString());
				cnt++;
				stack.pop();
				up = true;
			}else if(sum > n) {
				stack.pop();
				up = true;
			}
		}
		System.out.println(cnt);
	}
}