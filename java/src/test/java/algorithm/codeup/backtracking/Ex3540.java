package algorithm.codeup.backtracking;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * {@link https://codeup.kr/problem.php?id=3540}
 * */
public class Ex3540 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		recurse(arr, 0, "+");
	}
	
	private static final Pattern pattern = Pattern.compile("[-+]{0,1}\\w+");
	private static Stack<String> stack = new Stack<>();
	
	public static boolean recurse(int[] arr, int i, String op) {
		if(i >= arr.length) {
			int sum = calc();
			if(sum == 0) {
				for(int j = 1; j < stack.size(); j++) {
					System.out.print(stack.get(j));
				}
				System.out.println();
			}
			return true;
		}
		int value = arr[i];
		
		stack.push(op);
		stack.push(String.valueOf(value));
		
		boolean b = false;
		b = b || recurse(arr, i + 1, " ");
		b = b || recurse(arr, i + 1, "+");
		b = b || recurse(arr, i + 1, "-");
		stack.pop();
		stack.pop();
		
		return false;
	}
	
	public static int calc() {
		String s = stack.stream().collect(Collectors.joining());
		s = s.substring(1).replaceAll(" ", "");
		Matcher m = pattern.matcher(s);
		int sum = 0;
		while(m.find()) {
			sum += Integer.parseInt(m.group());
		}
//		return m.results().mapToInt(i -> Integer.parseInt(i.group())).sum();
		return sum;
	}
}
