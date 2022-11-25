package study._05_module;

// 날자와 시간을 좀 더 다양하게 사용할 수 있는 클래스. Date 보다 자주 쓰이는 느낌?
// 가지고있는 필드가 대부분 Static 이네.
import java.util.Calendar;

public class JavaUtil_Calendar {
	public static void main(String[] args) {
//		캘린더의 생성자가 protected 설정이라 이렇게는 생성할 수 없는듯.
//		Calendar test01 = new Calendar();		
//		.getInstance(); PC에서 표시되는 현재 시간을 가져오는 메소드. 보통은 시간 변수를 생성할때 이렇게 하나봐.
		Calendar testCal = Calendar.getInstance();
		
//		.get(int); 형으로 데이터를 가져오는? 보통 안에는 Calendar 객체의 필드를 지정한다.
//		대문자인거 보니 이거 상수네. 객체를 생성하면서 초기화된 값이 변하지 않아서...인가?
		System.out.println("Calendar.YEAR : " + testCal.get(Calendar.YEAR));
//		현재 달에서 몇번째 주.
		System.out.println("Calendar.DAY_OF_WEEK_IN_MONTH : " + testCal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("Calendar.DAY_OF_MONTH : " + testCal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar.ERA : " + testCal.get(Calendar.ERA));
		System.out.println("Calendar.HOUR_OF_DAY : " + testCal.get(Calendar.HOUR_OF_DAY));
		System.out.println("Calendar.MINUTE : " + testCal.get(Calendar.MINUTE));
		System.out.println("Calendar.WEEK_OF_YEAR : " + testCal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Calendar.ZONE_OFFSET : " + testCal.get(Calendar.ZONE_OFFSET));
		System.out.println("Calendar.JANUARY : " + testCal.get(Calendar.JANUARY));
		System.out.println("Calendar.MONDAY : " + testCal.get(Calendar.MONDAY));
		System.out.println("Calendar.FRIDAY : " + testCal.get(Calendar.FRIDAY));
		
//		Calendar 객체가 가지고 있는 상수중에서 jan~dec, mon~sun 의 상수들은 그냥 요일이나 월을 숫자로 지정만 해놓은것들.
//		월은 그렇다고 쳐도, 요일은 월요일이 10....? 이고 이거를 monday 로 표현하고 싶으면 switch 문으로 각각 문자열을 지정해야함.

		
//		오전오후를.... 0/1 로 리턴....하나? 아닌데....?
//		오전이 0인건 정해져있는것 같기도 하고...? 오전 0 오후 1 인건 맞는것 같고 이건 AM에 저장되어 있고 pm 에는 다른값인것 같다.
		System.out.println("Calendar.AM_PM : " + testCal.get(Calendar.AM_PM));
		System.out.println("Calendar.AM : " + testCal.get(Calendar.AM));
		System.out.println("Calendar.PM : " + testCal.get(Calendar.PM));

//		hour 는 오전 오후기준으로 표현한다. 오전은 0~11까지를 두번 도는 형식.
		System.out.println("Calendar.HOUR : " + testCal.get(Calendar.HOUR));
		
//		Month는 특이하게 하나 적은 숫자를 가져오네. 오늘의 달을 가져오려면 +1 필요.
		System.out.println("Calendar.MONTH : " + testCal.get(Calendar.MONTH));

	}
}
