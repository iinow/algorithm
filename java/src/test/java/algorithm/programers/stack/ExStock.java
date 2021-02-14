package algorithm.programers.stack;

import java.util.Arrays;

/**
 * {@link https://programmers.co.kr/learn/courses/30/lessons/42584}
 * */
public class ExStock {
	
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
        	boolean under = false;
        	for(int j = i + 1; j < prices.length; j++) {
        		if(prices[i] - prices[j] > 0) {
        			answer[i] = j - i;
        			under = true;
        			break;
        		}
        	}
        	if(under) {
        		continue;
        	}
        	answer[i] = prices.length - 1 - i;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		ExStock s = new ExStock();
		int[] arr = s.solution(new int[] {1, 2, 3, 2, 3});
		Arrays.stream(arr).forEach(System.out::println);
	}
}
