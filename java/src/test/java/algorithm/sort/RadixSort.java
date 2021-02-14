package algorithm.sort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * {@link https://palpit.tistory.com/129}
 * */
public class RadixSort {
	@SuppressWarnings("unchecked")
	private static LinkedList<Integer>[] counter = new LinkedList[] {
            new LinkedList<Integer>(), new LinkedList<Integer>(),
            new LinkedList<Integer>(), new LinkedList<Integer>(),
            new LinkedList<Integer>(), new LinkedList<Integer>(),
            new LinkedList<Integer>(), new LinkedList<Integer>(),
            new LinkedList<Integer>(), new LinkedList<Integer>() };

	public static void main(String[] args) {
		 int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
		 int maxDigitSymbols = 2;
		 int mod = 10;
		 int dev = 1;
		 for (int i = 0; i < maxDigitSymbols; i++, dev *= 10, mod *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int bucket = (arr[j] % mod) / dev;
                counter[bucket].add(arr[j]);
            }
 
            int pos = 0;
 
            for (int j = 0; j < counter.length; j++) {
                Integer value = null;
                while ((value = counter[j].poll()) != null) {
                	arr[pos++] = value;
                }
 
            }
		 }
		 
		 Arrays.stream(arr).forEach(v->System.out.print(v+" "));
	}
}
