package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {8,1,6,5,4,3,2,7};
		sort(arr, 0, arr.length - 1);
		Arrays.stream(arr).forEach(v->System.out.print(v+" "));
	}
	
	private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot) {
            	low++;
            }
            while (arr[high] > pivot) {
            	high--;
            }
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
