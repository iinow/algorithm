package algorithm.codeup.search;

import java.util.Scanner;

import algorithm.codeup.search.Ex3002.Tree.Node;


/**
 * {@link https://codeup.kr/problem.php?id=3002}
 * 
 * 2진 검색 트리로 
 * 
 * 사실 Map 으로 사용해도 됨 
 * */
public class Ex3002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Tree tree = new Tree();
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = i + 1;
			arr[i][1] = scanner.nextInt();
		}
		
		tree.makeTree(arr);
		int m = scanner.nextInt();
		for(int i = 0; i < m; i++) {
			Node node = tree.findNode(tree.node, scanner.nextInt());
			if(node == null) {
				System.out.print("-1 ");
				continue;
			}
			System.out.print(node.index+" ");
		}
		
	}
	
	static class Tree {
		Node node;
		static class Node {
			int index;
			int data;
			Node left;
			Node right;
			
			Node(int index, int data) {
				this.index = index;
				this.data = data;
			}
		}
		
		public void makeTree(int[][] arr) {
			this.node = makeTreeNode(arr, 0, arr.length - 1);
		}
		
		private Node makeTreeNode(int[][] arr, int start, int end) {
			if(start > end) return null;
			int mid = (start + end) / 2;
			Node node = new Node(arr[mid][0], arr[mid][1]);
			node.left = makeTreeNode(arr, start, mid - 1);
			node.right = makeTreeNode(arr, mid + 1, end);
			return node;
		}
		
		public Node findNode(Node node, int data) {
			if(node == null) {
				return null;
			}
			if(data < node.data) {
				return findNode(node.left, data);
			}else if(data > node.data) {
				return findNode(node.right, data);
			}
			return node;
		}
	}
}