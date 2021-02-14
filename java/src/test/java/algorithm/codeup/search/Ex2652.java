package algorithm.codeup.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * {@link https://codeup.kr/problem.php?id=2652}
 * */
public class Ex2652 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		DFS dfs = new DFS(n, k);
		dfs.addValues(0,1);
		System.out.println(dfs.dfs());
	}
	
	static class DFS {
		private int depth; //root
		private int sum;
		private List<Integer> values = new ArrayList<>();
		private Stack<Integer> stack = new Stack<>();
		
		public DFS(int depth, int sum) {
			this.depth = depth;
			this.sum = sum;
		}
		
		public void addValues(int ...value) {
			values.addAll(Arrays.stream(value).mapToObj(v->v).collect(Collectors.toList()));
		}
		
		public int dfs() {
			int cnt = 0;
			for(int value: values) {
				if(!stack.isEmpty()) {
					int pre = stack.peek();
					if(pre == 1 && value == 1) {
						stack.pop();
						return cnt;
					}
				}
				stack.push(value);
				
				if(stack.stream().mapToInt(v->v).sum() == this.sum) {
					stack.pop();
					cnt += 1;
					continue;
				}
				
				if(stack.size() >= depth) {
					stack.pop();
					continue;
				}
				cnt += dfs();
			}
			if(!stack.isEmpty())
				stack.pop();
			return cnt;
		}
	}
}