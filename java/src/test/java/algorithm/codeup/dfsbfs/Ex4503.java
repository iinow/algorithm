package algorithm.codeup.dfsbfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * {@link https://codeup.kr/problem.php?id=4503}
 * 
 * 이 문제는 DFS 로 풀이 해야함 스택으로
 * 
 * 연관관계 내용이 깊이 탐색으로 가고 있음..
 * */
public class Ex4503 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int pair = scanner.nextInt();
		
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for(int i = 0; i < n; i++) {
			map.put(i + 1, new ArrayList<>());
		}
		
		for(int i = 0; i < pair; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		Set<Integer> set = new HashSet<>();
		Iterator<Integer> iter = map.keySet().iterator();
		int k = iter.next();
		recurse(map, set, k);
		
		System.out.println(set.size() - 1);
	}
	
	public static void recurse(Map<Integer, List<Integer>> map, Set<Integer> set, int key) {
		if(set.contains(key)) {
			return;
		}
		set.add(key);
		List<Integer> list = map.get(key);
		for(int v: list) {
			recurse(map, set, v);
		}
	}
}
