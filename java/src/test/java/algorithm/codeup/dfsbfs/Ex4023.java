package algorithm.codeup.dfsbfs;

import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=4023}
 * */
public class Ex4023 {
	private static final int WHITE = 2;
	private static final int BLACK = 1;
	private static Stack<String> stack = new Stack<>();
	
	enum DIRECT {
		VERTICAL, HORIZON, DIA1, DIA2
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] arr = new int[19][19];
		boolean[][] exists = new boolean[19][19];
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		
		boolean end = false;
		
		//화이트
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				for(DIRECT direct: DIRECT.values()) {
					int w = recurse(arr, exists, i, j, WHITE, direct);
					String s = null;
					if(w == 5) {
						s = find();
					}
					stack.clear();
					
					int b = recurse(arr, exists, i, j, BLACK, direct);
					if(b == 5) {
						s = find();
					}
					stack.clear();
					if(w == 5 || b == 5) {
						int res = w == 5 ? WHITE : BLACK;
						System.out.println(res);
						System.out.println(s);
						end = true;
						break;
					}
				}
				if(end) {
					break;
				}
			}
			if(end) {
				break;
			}
		}		
		if(end == false) {
			System.out.println("0");
		}
	}
	
	public static int recurse(int[][] arr, boolean[][] exists, int i, int j, final int value, DIRECT direct) {
		if(i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
			return 0;
		}
		
		if(exists[i][j]) {
			return 0;
		}
		
		if(arr[i][j] == value) {
			int res = 1;
			exists[i][j] = true;
			if(direct == DIRECT.HORIZON) {
				res += recurse(arr, exists, i, j - 1, value, direct);
				res += recurse(arr, exists, i, j + 1, value, direct);
			}else if(direct == DIRECT.VERTICAL) {
				res += recurse(arr, exists, i - 1, j, value, direct);
				res += recurse(arr, exists, i + 1, j, value, direct);
			}else if(direct == DIRECT.DIA1) {
				res += recurse(arr, exists, i - 1, j - 1, value, direct);
				res += recurse(arr, exists, i + 1, j + 1, value, direct);
			}else if(direct == DIRECT.DIA2) {
				res += recurse(arr, exists, i - 1, j + 1, value, direct);
				res += recurse(arr, exists, i + 1, j - 1, value, direct);
			}
			exists[i][j] = false;
			stack.push(String.valueOf((j+1)+" "+(i+1)));
			return res;
		}else {
			return 0;
		}
	}
	
	private static String find() {
		String min = stack.stream().min((a, b) -> {
			int aa = Integer.parseInt(a.replaceAll(" ", ""));
			int bb = Integer.parseInt(b.replaceAll(" ", ""));
			if(aa > bb) {
				return 1;
			}else if(aa < bb) {
				return -1;
			}return 0;
		}).get();
		return min.replaceFirst("(\\d+) (\\d+)", "$2 $1");
	}
}
