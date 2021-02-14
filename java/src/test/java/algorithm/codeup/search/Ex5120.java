package algorithm.codeup.search;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * {@link https://codeup.kr/problem.php?id=5120}
 * {@link https://codeup.kr/problem.php?id=5121}
 * */
public class Ex5120 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//일 수
		int n = scanner.nextInt();
		
		int[] codeupArr = new int[n];
		int[] koiArr = new int[n];
		int[] koiMax = {0, Integer.MAX_VALUE};
		boolean selectCodeup = false;
		boolean selectKoi = false;
		
		for(int i = 0; i < n; i++) {
			int codeup = scanner.nextInt();
			codeupArr[i] = codeup;
		}
		
		for(int i = 0; i < n; i++) {
			int koistudy = scanner.nextInt();
			koiArr[i] = koistudy;
			int sub = codeupArr[i] - koistudy;
			
			if(codeupArr[i] < koistudy) {
				codeupArr[i] = koistudy;
				selectKoi = true;
			}else {
				selectCodeup = true;
			}
			
			if(Math.abs(sub) < koiMax[1]) {
				koiMax[0] = i;
				koiMax[1] = sub;
			}
		}
		
		if(selectCodeup == false) {
			codeupArr[koiMax[0]] = codeupArr[koiMax[0]] + koiMax[1];
		}else if(selectKoi == false) {
			codeupArr[koiMax[0]] = codeupArr[koiMax[0]] - koiMax[1];
		}
		int sum  = Arrays.stream(codeupArr).sum();
		System.out.println(sum);
	}
}
