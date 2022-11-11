package start.ch01;

import java.util.Calendar;

public class EnumTypeTest {

	public static void main(String[] args) {
		EnumType today = null;
//		java에서 제공하는 날자와 요일에 관련된객체. 임포트필요
		Calendar cal = Calendar.getInstance();
//		DAY_OF_WEEK = 요일에 따라서 숫자를 반환한다.
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
//		받아온 숫자를 열거상수로 변환해서 변수에 대입해주는 스위치문.
		switch (week) {
		case 1: today = EnumType.SUNDAY; break;
		case 2: today = EnumType.MONDAY; break;
		case 3: today = EnumType.TUSEDAY; break;
		case 4: today = EnumType.WEDNESDAY; break;
		case 5: today = EnumType.THURSDAY; break;
		case 6: today = EnumType.FRIDAY; break;
		case 7: today = EnumType.SATURDAY; break;
		}
		
		if (today == EnumType.SUNDAY) {
			System.out.println("Sunday");
		} else {
			System.out.println("not Sunday");
		}
		System.out.println(week);
		System.out.println(today);
	}

}
