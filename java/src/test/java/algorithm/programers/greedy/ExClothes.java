package algorithm.programers.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link https://programmers.co.kr/learn/courses/30/lessons/42862}
 * */
public class ExClothes {
	public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lost_v = new HashSet<>();
        Set<Integer> reserve_v = new HashSet<>();
        int answer = 0;

        for (int i : lost) {
            lost_v.add(i);
        }

        for (int i : reserve) {
            if (lost_v.contains(i)) {
            	reserve_v.add(i);
                lost_v.remove((Object)i);
                continue;
            }
        }
        
        for (int i : reserve) {
        	if(reserve_v.contains(i)) {
        		continue;
        	}
        	 if (lost_v.contains(i - 1)) {
                 lost_v.remove((Object)(i-1));
                 continue;
             } else if (lost_v.contains(i + 1)) {
                 lost_v.remove((Object)(i+1));
                 continue;
             }
        }
        
        answer = (n - lost_v.size());
        return answer;
    }
	
	public static void main(String[] args) {
		
	}
}
