package algorithm.codeup.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * {@link https://codeup.kr/problem.php?id=2657}
 * 
 * Ex2653 과 같음
 * 아... 시간 초과뜸
 * */
public class Ex2657 {
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
				if(stack.size() > 1) {
					int pre1 = stack.get(stack.size() - 1);
					int pre2 = stack.get(stack.size() - 2);
					if(pre1 == 1 && pre2 == 1 && value == 1) {
						stack.pop();
						return cnt;
					}else if(pre1 == 1 && value == 1 && stack.size() + 1 == depth) {
						stack.pop();
						return cnt;
					}
				}
				
				if(stack.size() == 1) {
					int pre = stack.peek();
					if(pre == 1 && value == 1) {
						stack.pop();
						return cnt;
					}
				}
				stack.push(value);
				
				int ssum = stack.stream().mapToInt(v->v).sum();
				if(ssum == this.sum) {
					stack.pop();
					cnt += 1;
					continue;
				}
				
				if(stack.size() >= depth) {
					stack.pop();
					continue;
				}
				
				if(ssum + 1 == this.sum && (depth - stack.size()) > 1 && stack.size() > 2) {
					int pre1 = stack.peek();
					int pre2 = stack.get(stack.size() - 2);
					if(pre1 == 1 && pre2 == 1) {
						cnt +=(depth - stack.size() - 1);
					}else {
						cnt += (depth - stack.size());
					}
					stack.pop();
					continue;
				}else {
					cnt += dfs();
				}
			}
			if(!stack.isEmpty())
				stack.pop();
			return cnt;
		}
	}
}