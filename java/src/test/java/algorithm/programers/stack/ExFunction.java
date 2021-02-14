package algorithm.programers.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.AbstractMap.SimpleEntry;

/**
 * {@link https://programmers.co.kr/learn/courses/30/lessons/42586}
 * */
public class ExFunction {
	public int[] solution(int[] progresses, int[] speeds) {
		//k = day, v = 개수
        Stack<SimpleEntry<Integer, Integer>> stack = new Stack<>();
        for(int i = 0; i < progresses.length; i++) {
        	int progress = progresses[i];
        	int speed = speeds[i];
        	
        	int day = (int)Math.ceil((100 - progress) / (double)speed);
        	if(stack.isEmpty() == false) {
        		if(stack.peek().getKey() >= day) {
        			stack.peek().setValue(stack.peek().getValue() + 1);
        			continue;
        		}
        	}
        	stack.push(new SimpleEntry<Integer, Integer>(day, 1));
        }
        
        return stack.stream().mapToInt(i->i.getValue()).toArray();
    }
	
	public static void main(String[] args) {
		ExFunction fu = new ExFunction();
		int[] arr = fu.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		Arrays.stream(arr).forEach(System.out::println);
	}
}
