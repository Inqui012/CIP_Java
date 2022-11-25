package study._05_module;

import java.util.Calendar;
import java.util.TimeZone;

public class JavaUtil_TimeZone {

	public static void main(String[] args) {
//		얘도 생성자로 생성 못하네.
//		TimeZone tZone = new TimeZone();
		TimeZone tZone = TimeZone.getTimeZone("GMT");
		Calendar testCal = Calendar.getInstance(tZone);
		
//		코드쓰는 현재 오후12시인데 3찍음. GMT 기준으로 시간을 가져와서 그런듯.
		System.out.println(testCal.get(Calendar.HOUR));
	}

}
