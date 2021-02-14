package algorithm.kakao;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		solution(scanner.next());
	}
	public static int solution(String s) {
		//기본 1개로 압축했을 경우
        int answer = s.length();
        char[] cs = s.toCharArray();
        
        //i = 문자열 개수만큼 압축했을 때
        for(int i = 2; i <= s.length() / 2; i++) {
        
        	Map<String, Integer> map = new TreeMap<>();
        }
        
        return answer;
    }
}
