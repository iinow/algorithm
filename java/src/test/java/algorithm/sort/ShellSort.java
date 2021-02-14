package algorithm.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {9,1,22,4,0,-1,1,22,100,10};
		int gap = arr.length / 2;
		
		while(gap > 0) {
			for(int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				int index = i;
				
				while(index >= gap && arr[index - gap] > temp) {
					arr[index] = arr[index - gap];
					index -= gap;
				}
				arr[index] = temp;
			}
			System.out.print("gap: "+ gap + " = ");
			Arrays.stream(arr).forEach(v -> System.out.print(v+" "));
			System.out.println();
			gap /= 2;
		}
		
		Arrays.stream(arr).forEach(v -> System.out.print(v+" "));
	}
}
