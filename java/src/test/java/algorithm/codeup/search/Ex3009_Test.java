package algorithm.codeup.search;

import java.util.Stack;

public class Ex3009_Test {
	public static void main(String[] args) {
		int n = 5;
//		for(int i = 1; i <= n - 2; i++) {
//			for(int j = i + 1; j <= n - 1; j++){
//				for(int z = j + 1; z <= n; z++) {
//					System.out.println(i+" "+j+" "+z);
//				}
//			}
//		}
		
		int[] arr = {1,2,3,4,5};
		combination(arr, 0, 3);
	}
	static Stack<Integer> stack = new Stack<>();
	
	public static void combination(int[] arr, int index, int r) {
		if(r == 0 || index >= arr.length) {
//			if(stack.size() == 3)
				System.out.println(stack.toString());
			return;
		}
		
		stack.push(arr[index]);
		combination(arr, index + 1, r - 1);
		
		stack.pop();
		combination(arr, index + 1, r);
	}
}
