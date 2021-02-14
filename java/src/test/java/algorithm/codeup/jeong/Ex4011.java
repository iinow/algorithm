package algorithm.codeup.jeong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex4011 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split("-");
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		Date day = inputFormat.parse(strs[0]);
		String date = outputFormat.format(day);
		
		int sex = Integer.parseInt(strs[1].substring(0, 1));
		
		if(sex == 1) {
			date = date.replaceFirst("^\\d{2}", "19") + " M";
		}else if(sex == 2) {
			date = date.replaceFirst("^\\d{2}", "19") + " F";
		}else if(sex == 3) {
			date = date.replaceFirst("^\\d{2}", "20") + " M";
		}else {
			date = date.replaceFirst("^\\d{2}", "20") + " M";
		}
		
		System.out.println(date);
	}
}
