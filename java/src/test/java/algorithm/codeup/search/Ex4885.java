package algorithm.codeup.search;

import java.util.Scanner;

/**
 * {@link https://codeup.kr/problem.php?id=4885}
 * */
public class Ex4885 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int bucketA = scanner.nextInt();
		final int bucketB = scanner.nextInt();
		
		final int goalBucketA = scanner.nextInt();
		final int goalBucketB = scanner.nextInt();
		
		int res = dfs(bucketA, 0, bucketB, 0, goalBucketA, goalBucketB, 0);
		System.out.println(res);
	}
	
	public static int dfs(final int bucketA, int bucketAQuantity, final int bucketB, int bucketBQuantity, final int goalBucketA, final int goalBucketB, int cnt) {
		if(cnt > 10) {
			return -1;
		}
		if(bucketAQuantity == goalBucketA && bucketBQuantity == goalBucketB) {
			return cnt;
		}
		int res = -1;
		
		//fill A
		if(bucketA != bucketAQuantity) {
			int a = dfs(bucketA, bucketA, bucketB, bucketBQuantity, goalBucketA, goalBucketB, cnt + 1);
			if(res < 0) {
				res = a;
			}
			if(a > 0) {
				res = res > a ? a : res;
			}
		}
		
		//empty A
		if(bucketAQuantity != 0) {
			int a = dfs(bucketA, 0, bucketB, bucketBQuantity, goalBucketA, goalBucketB, cnt + 1);
			if(res < 0) {
				res = a;
			}
			if(a > 0) {
				res = res > a ? a : res;
			}
		}

		//fill B
		if(bucketB != bucketBQuantity) {
			int b = dfs(bucketA, bucketAQuantity, bucketB, bucketB, goalBucketA, goalBucketB, cnt + 1);
			if(res < 0) {
				res = b;
			}
			if(b > 0) {
				res = res > b ? b : res;
			}
		}
		
		//empty A
		if(bucketBQuantity != 0) {
			int a = dfs(bucketA, bucketAQuantity, bucketB, 0, goalBucketA, goalBucketB, cnt + 1);
			if(res < 0) {
				res = a;
			}
			if(a > 0) {
				res = res > a ? a : res;
			}
		}
		
		//Move A to B, B to A
		if(!(bucketAQuantity == 0 && bucketBQuantity == 0)) {
			//A to B
			if(bucketB != bucketBQuantity) {
				int bucketSum = bucketB - (bucketAQuantity + bucketBQuantity);
				int diff = bucketSum >= 0 ? 0 : Math.abs(bucketSum);
				int c = dfs(bucketA, diff, bucketB, (bucketAQuantity + bucketBQuantity) - diff, goalBucketA, goalBucketB, cnt + 1);
				if(res < 0) {
					res = c;
				}
				if(c > 0) {
					res = res > c ? c : res;
				}
			}
			//B to A
			if(bucketA != bucketAQuantity) {
				int bucketSum = bucketA - (bucketAQuantity + bucketBQuantity);
				int diff = bucketSum >= 0 ? 0 : Math.abs(bucketSum);
				int d = dfs(bucketA, (bucketAQuantity + bucketBQuantity) - diff, bucketB, diff, goalBucketA, goalBucketB, cnt + 1);
				if(res < 0) {
					res = d;
				}
				if(d > 0) {
					res = res > d ? d : res;
				}
			}
		}
		return res;
	}
}
