package algorithm.sort;

import java.util.Arrays;

/**
 * Simple, Slow
 * */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {4,2,1,5,6};
		
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];

			int j = 0;
			for(j = i - 1; j >= 0; j--) {
				if(arr[j] > key) {
					arr[j+1] = arr[j];
				}else {
					break;
				}
			}
			arr[j + 1] = key;
		}
		
		Arrays.stream(arr).forEach(System.out::print);
	}
}
