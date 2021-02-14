package algorithm.codeup.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * {@link https://codeup.kr/problem.php?id=3170}
 * 문) 진짜 오랜만에 주현이 엄마는 기억력 테스트를 하기로 했다.
주현이가 많이 컸기 때문에 이제 숫자만 가지고 테스트하기엔 부족하다.
이번에도 N개의 숫자를 불러주고, M개의 질문을 한다.
처음에 [단어]와 [숫자]를 불러주고, 질문으로 [단어]를 물어보면 해당 단어의 [숫자]를 말하는 것이다.
그런데 불러 줄 때 같은 [단어]가 나오는 경우 [이전 단어]의 [숫자]에 [현재 숫자]를 더해야 한다.
예를 들어 "ddobot 3" , "poketmon 5", "ddobot 7"을 불러 주고, 질문으로 "ddobot"을 물었을 경우 3+7인 10을 답해야 한다.
이번에는 포켓몬 썬&문  카드 풀 팩이 걸려 있다. 주현이가 잘 할 수 있도록 도와주자.

입력) 첫째 줄에 N과 M이 입력된다.(1<=N,M<=100,000)
둘째 줄부터 N줄 동안 문자열 S와 정수 k가 입력된다. 
그 다음 M줄 동안 질문 Q가 문자열로 입력된다. 만약 부르지 않았던 단어를 질문하는 경우 0을 출력한다.
(S, Q는 100글자 이하 영어 소문자 알파벳으로만 구성, k는 10이하의 자연수)

출력) 질문에 맞는 [누적 숫자]를 한줄에 하나씩 출력한다.

ex) 
3 4
ddobot 3
poketmon 5
ddobot 7
ddobot
poketmon
ddobot
hellocarbot
------------
10
5
10
0

 * */
public class Ex3170 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int qCnt = scanner.nextInt();
		int aCnt = scanner.nextInt();
		
		Map<String, Integer> map = new TreeMap<>();
		for(int i = 0; i < qCnt; i++) {
			String name = scanner.next();
			int value = scanner.nextInt();
			
			if(map.get(name) == null) {
				map.put(name, 0);
			}
			map.put(name, map.get(name) + value);
		}
		List<String> list = new ArrayList<>();
		for(int i = 0; i < aCnt; i++) {
			String name = scanner.next();
			list.add(name);
		}
		
		for(String name: list) {
			if(map.get(name) == null) {
				System.out.println("0");
			}else
				System.out.println(map.get(name));
		}
	}
}