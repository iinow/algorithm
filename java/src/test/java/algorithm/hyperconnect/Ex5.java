package algorithm.hyperconnect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex5 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 1, -1, 3};
		List<Integer> list = Arrays.stream(arr).distinct().filter(i -> i > 0).boxed().collect(Collectors.toList());
	}
}
