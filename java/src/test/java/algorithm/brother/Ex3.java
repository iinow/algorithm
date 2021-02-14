package algorithm.brother;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Ex3 {
	
	public int solution(int[] A) {
		Map<Integer, Integer> map = new TreeMap<>();
		Arrays.stream(A).distinct().forEach(v -> {
			if(map.get(Math.abs(v)) == null) {
				map.put(Math.abs(v), 0);
			}
			map.put(Math.abs(v), map.get(Math.abs(v)) + 1);
		});
		
		Iterator<Integer> iter = map.keySet().iterator();
		int max = 0;
		while(iter.hasNext()) {
			int key = iter.next();
			if(map.get(key) == 2) {
				if(max < key) {
					max = key;
				}
			}
		}
		return max;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {3, 2, -2, 5, -3};
		System.out.println(new Ex3().solution(arr));
	}
}
