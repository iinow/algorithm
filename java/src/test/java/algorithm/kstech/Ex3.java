package algorithm.kstech;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 12시간 단위로 표시되는 시계가 있습니다. 오전일 경우 AM , 오후일 경우 PM으로 표시되며, 시간은 시:분:초로 표시됩니다.
예를 들어, 오전 11시 27분 35초일 경우 AM 11:27:35 로 표시가 되며, 오후 8시 20분 4초일 경우 PM 08:20:04 로 표시가 됩니다.
이제부터, 우리는 시계에 표시된 시간에서 N초 후의 시간을 구하려고 합니다.
단, N초 후의 시간 표시를 12시간 단위에서 24시간 단위 표시로 변경하려고 합니다.
24시간 단위로 표시되므로 오전과 오후를 나타내는 AM, PM과 같은 문자열은 표시되지 않으며, 시:분:초만 표시됩니다.
 * */
public class Ex3 {
	
	public String solution(String p, int n) throws ParseException {
		SimpleDateFormat inputFormat = new SimpleDateFormat("a hh:mm:ss", Locale.ENGLISH);
		SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputFormat.parse(p));
		cal.add(Calendar.SECOND, n);
		return outputFormat.format(cal.getTime());
	}
	
	public static void main(String[] args) throws ParseException {
//		String p = "PM 01:00:00";
		String p = "PM 11:59:59";
		int n = 1;
		SimpleDateFormat inputFormat = new SimpleDateFormat("a hh:mm:ss", Locale.ENGLISH);
		SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputFormat.parse(p));
		cal.add(Calendar.SECOND, n);
		String res = outputFormat.format(cal.getTime());
		System.out.println(res);
	}
}
