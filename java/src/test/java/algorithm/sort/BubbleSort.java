package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {7,4,5,1,3};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		Arrays.stream(arr).forEach(System.out::print);
	}
}
