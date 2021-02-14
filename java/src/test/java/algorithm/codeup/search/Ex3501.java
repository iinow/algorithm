package algorithm.codeup.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=3501}
 * */
public class Ex3501 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[][] arr = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			int r = scanner.nextInt();
			int g = scanner.nextInt();
			int b = scanner.nextInt();
			arr[i][0] = r;
			arr[i][1] = g;
			arr[i][2] = b;
		}
		search(arr, 0, -1);
		System.out.println(result.stream().min((a, b) -> {
			if(a > b) {
				return 1;
			}else if(a < b) {
				return -1;
			}return 0;
		}).get());
	}
	
	private static List<Integer> result = new ArrayList<>();
	private static Stack<Integer> stack = new Stack<>();
	
	public static void search(int[][] arr, int index, int rgbindex) {
		if(stack.size() == arr.length) {
			result.add(stack.stream().mapToInt(i->i).sum());
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(i == rgbindex) {
				continue;
			}
			stack.push(arr[index][i]);
			search(arr, index + 1, i);
			stack.pop();
		}
	}
}
