package algorithm.programers.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ExPrint {
		
	
	public int solution(int[] priorities, int location) {
		Queue<Node> queue = new LinkedList<>();
		for(int i = 0; i < priorities.length; i++) {
			queue.add(new Node(i, priorities[i]));
		}
		//2, 1, 3
		int cnt = 1;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			boolean big = false;
			for(Node n: queue) {
				if(node.data < n.data) {
					queue.add(node);
					big = true;
					break;
				}
			}
			if(big) {
				continue;
			}
			if(node.index == location) {
				break;
			}else {
				cnt++;
			}
		}
		return cnt;
    }
	
	public static void main(String[] args) {
		ExPrint p = new ExPrint();
		int cnt = p.solution(new int[]{2,1,3,2}, 2);
		System.out.println(cnt);
	}
	
	static class Node {
		int index;
		int data;
		
		public Node(int index, int data) {
			this.index = index;
			this.data = data;
		}
	}
}
