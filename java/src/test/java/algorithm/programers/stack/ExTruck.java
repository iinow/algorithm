package algorithm.programers.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * {@link https://programmers.co.kr/learn/courses/30/lessons/42583}
 * */
public class ExTruck {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> crossQueue = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();
		//길이 2 
		//다리 무게 10
		//트럭 무게 7 4 5 6
		int second = 0;
		for(int truck: truck_weights) {
			queue.add(truck);
		}
		
		while(!queue.isEmpty() || !crossQueue.isEmpty()) {
			second++;
			
			if(!queue.isEmpty() && crossQueue.isEmpty()) {
				crossQueue.add(new Truck(queue.poll(), second));
				continue;
			}
			
			while(!crossQueue.isEmpty()) {
				Truck t = crossQueue.peek();
				if(second - t.second >= bridge_length) {
					crossQueue.poll();
					continue;
				}
				break;
			}
			
			if(!queue.isEmpty()) {
				int truck = queue.peek();
				int sum = crossQueue.stream().mapToInt(i->i.weight).sum() + truck;
				if(sum > weight) {
					continue;
				}
				
				crossQueue.add(new Truck(queue.poll(), second));
			}
		}
		
        return second;
    }
	
	static class Truck {
		int weight;
		int second;
		
		public Truck(int weight, int second) {
			this.weight = weight;
			this.second = second;
		}
	}
	
	public static void main(String[] args) {
		ExTruck t = new ExTruck();
		int second = t.solution(2, 10, new int[] {7,4,5,6});
		System.out.println(second);
	}
}
