package algorithm.kstech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 임의의 자연수 N이 주어질 때 각 자리의 숫자를 정렬하려고 합니다. 예를 들어 주어진 숫자 N = 2613인 경우 각 자릿수를 오름차순으로 정렬하면 1236이 되며, 내림차순으로 정렬하면 6321이 되고, 두 숫자의 합은 7557이 됩니다. 임의의 자연수 N이 매개변수로 주어질 때 N의 각 자릿수를 오름차순으로 정렬한 수와 내림차순으로 정렬한 수의 합을 return 하도록 solution 함수를 완성해 주세요.
 * */
public class Ex2 {
	public int solution(int N) {
		List<Integer> list = new ArrayList<>();
		for(char c: String.valueOf(N).toCharArray()) {
			list.add(Integer.parseInt(String.valueOf(c)));
		}
		Collections.sort(list);
		int low = Integer.parseInt(list.stream().map(v -> String.valueOf(v)).collect(Collectors.joining()));
		
		list.sort((a, b) -> {
			if(a > b) {
				return -1;
			}else if(a < b) {
				return 1;
			}else {
				return 0;
			}
		});
		int high = Integer.parseInt(list.stream().map(v -> String.valueOf(v)).collect(Collectors.joining()));
		return low + high;
	}
	
	public static void main(String[] args) {
		int n = 2613;
		System.out.println(new Ex2().solution(n));
	}
}
