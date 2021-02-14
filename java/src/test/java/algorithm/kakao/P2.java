package algorithm.kakao;

import java.util.Scanner;

public class P2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String res = solution(scanner.next());
		System.out.println(res);
	}
	
	static final String comfortableMark = "\\(\\)";
	static final String uncomfortableMark = "\\)\\(";
	
	public static String solution(String p) {
		if(p.isEmpty())
			return p;
		
		String copy = p;
		while(true) {
			String str = copy.replaceAll(comfortableMark, "");
			if(str.length() == copy.length()) {
				break;
			}
			copy = str;
			
			//올바른 괄호 문자열
			if(copy.isEmpty()) {
				return p;
			}
			
		}
		
		//변환 과정...
		while(true) {
			String str = copy.replaceAll(uncomfortableMark, comfortableMark);break;
		}
        String answer = "";
        return answer;
    }
	
	public static boolean comfortable(String s) {
		String copy = s;
		while(true) {
			String str = copy.replaceAll(comfortableMark, "");
			if(str.length() == copy.length()) {
				break;
			}
			copy = str;
			
			//안정한 문자열
			if(copy.isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
