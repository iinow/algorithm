package algorithm.sort;

import java.util.Arrays;

/**
 * (병합,합병??) 정렬
 * */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {6, 5, 3, 1, 8, 7, 2, 4, 9};
		sort(arr, 0, arr.length);
		Arrays.stream(arr).forEach(v->System.out.print(v+" "));
	}

    private static void sort(int[] arr, int low, int high) {
        if (high - low < 2) {
            return;
        }

        int mid = (low + high) / 2;
        sort(arr, 0, mid);
        sort(arr, mid, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
//    	System.out.println(low+" "+mid+" "+high);
        int[] temp = new int[high - low];
        int index = 0, l = low, h = mid;

        while (l < mid && h < high) {
            if (arr[l] < arr[h]) {
                temp[index++] = arr[l++];
            } else {
                temp[index++] = arr[h++];
            }
        }

        while (l < mid) {
            temp[index++] = arr[l++];
        }

        while (h < high) {
            temp[index++] = arr[h++];
        }

        for (int i = low; i < high; i++) {
            arr[i] = temp[i - low];
        }
    }
}
