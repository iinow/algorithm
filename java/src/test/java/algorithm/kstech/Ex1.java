package algorithm.kstech;

import java.util.HashSet;
import java.util.Set;

/**
 * 자연수가 적힌 2 * N장의 카드묶음을 가지고 있습니다. 카드묶음에는 같은 숫자가 적힌 카드가 2장씩 포함되어 있습니다. 어느 날 카드 1장을 잃어버렸습니다. 2*N - 1 길이의 카드 배열(cards)이 입력으로 주어질 때 잃어버린 카드에 적힌 숫자를 return 하도록 solution 함수를 완성해 주세요.
 * 
 * ex)[1, 3, 2, 2, 5, 5, 1] return 3
 * */
public class Ex1 {
	public int solution(int[] cards) {
		Set<Integer> set = new HashSet<>();
		for(int card : cards) {
			if(set.contains(card)) {
				set.remove(card);
			}else {
				set.add(card);
			}
		}
		
		return set.iterator().next();
	}
	
	public static void main(String[] args) {
		
	}
}
