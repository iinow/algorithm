package algorithm.sort;

import java.util.Arrays;

/**
 * 
 * */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {9,6,7,3,5};
		
		
		for(int i = 0; i < arr.length - 1; i ++) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					index = j;
				}
			}
			arr[index] = arr[i];
			arr[i] = min;
		}
		
		Arrays.stream(arr).forEach(System.out::print);
	}
}
