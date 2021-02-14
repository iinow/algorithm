package algorithm.codeup.structure;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 문) 세종이는 정보과학 선생님인 JH를 도와주기 위해 정보과학 성적처리 프로그램을 만들기로 했다.
JH 선생님은 학생들의 명단과 점수를 입력하면 상위 m명의 학생 명단을 출력해 주기를 원한다.
다음 조건을 만족하는 프로그램을 작성해 보자.

입력) 첫째 줄에 데이터의 개수 n (3<=n<=100)과 출력인원 m (1<=m<=n)이 공백으로 구분되어 입력된다.
둘째 줄부터 학생 이름과 점수(0 100)가 공백으로 구분되어 입력된다. 
단 이름의 길이는 최대 10바이트 이내이다.

출력) 상위 m명의 학생명단을 출력한다.
단, 출력순서는 점수가 높은 학생이 먼저 출력되며, 점수가 같을 경우 입력 순서가 빠른 순서로 출력한다.

ex)
4 2
Jeon 95
Kim 59
Lee 90
Bae 100
--------
Bae
Jeon


인코딩 문제로 해결을 못 하겠음...
 * */
public class Ex3015 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner scanner = new Scanner(System.in, "utf8");
		int cnt = scanner.nextInt();
		int outputCnt = scanner.nextInt();

		List<Person> list = new ArrayList<>();
		for(int i = 0; i < cnt; i++) {
			String name = scanner.next();
			int score = scanner.nextInt();
			list.add(new Person(name, score));
		}
		
		list.sort(new PersonComparatorImpl());
		for(int i = 0; i < outputCnt; i++) {
			System.out.println(new String(list.get(i).name.getBytes(), "utf8"));
		}
		System.out.println(System.getProperty("file.encoding"));
	}
}

class Person {
	String name;
	int score;
	
	Person(String name, int score){
		this.name = name;
		this.score = score;
	}
}

class PersonComparatorImpl implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		if(o1.score > o2.score) {
			return -1;
		}else if(o1.score < o2.score) {
			return 1;
		}else {
			return 0;
		}
	}
}
