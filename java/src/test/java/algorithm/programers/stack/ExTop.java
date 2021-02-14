package algorithm.programers.stack;

import java.util.Arrays;

/**
 * {@link https://programmers.co.kr/learn/courses/30/lessons/42588}
 */
public class ExTop {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		
		for(int i = heights.length - 1; i > 0; i--) {
			int h = heights[i];
			for(int j = i - 1; j >= 0; j--) {
				int hh = heights[j];
				
				if(hh > h) {
					answer[i] = j + 1;
					break;
				}
			}
		}

        return answer;
    }
	
	public static void main(String[] args) {
		ExTop t = new ExTop();
		int[] arr = {6,9,5,7,4};
		int[] res = t.solution(arr);
		
		Arrays.stream(res).forEach(System.out::print);
	}
}
