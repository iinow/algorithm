package algorithm.codeup.structure;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문) 프로그래밍 문제를 풀다 보면 뒤죽박죽인 N개의 데이터를 숫자의 크기 순으로 0 ~ N-1까지의 숫자로 재정렬 해야되는 경우가 종종 있다.
예를 들어 N=5 이고,
50 23 54 24 123
이라는 데이터가 있다면,
2 0 3 1 4
가 된다.
데이터를 재정렬하는 프로그램을 작성하시오.

 입력) 첫째 줄에 데이터의 개수 N이 입력된다. ( 1 <= N <= 50,000)
둘째 줄에 공백으로 분리되어 N개의 서로 다른 데이터가 입력된다. (값의 범위:0~500,000)

출력) N개의 데이터를 0 ~ N-1로 재정렬하여 출력하라.

ex) 
5
50 23 54 24 123 
 * */
public class Ex3004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cnt = scanner.nextInt();
		
		int[] arr = new int[cnt];
		int[] copy = new int[cnt];
		for(int i = 0; i < cnt; i++) {
			int value = scanner.nextInt();
			arr[i] = value;
			copy[i] = value;
		}
		
		Arrays.sort(arr);
		for(int i = 0; i < cnt; i++) {
			int value = copy[i];
			
			for(int j = 0; j < cnt; j++) {
				if(value == arr[j]) {
					System.out.print(j+" ");
				}
			}
		}
	}
	
	//버킷 정렬 사용하지 않음 퀵정렬 사용
	public static int sortBucket(int[] arr, int maxValue) {
		int[] bucket=new int[maxValue+1];
		 
	    for (int i=0; i<bucket.length; i++) {
	       bucket[i]=0;
	    }
	
	    for (int i=0; i<arr.length; i++) {
	    	int value = arr[i];
	    	if(value < 0) {
	    		continue;
	    	}
	       bucket[value]++;
	    }
	 
	    int outPos=0;
	    for(int i=1; i<bucket.length; i++) {
	    	if(bucket[i] == 0) {
	    		return i;
	    	}
	       for (int j=0; j<bucket[i]; j++) {
	    	   arr[outPos++]=i;
	       }
	    }
	    return bucket.length;
	}
}
