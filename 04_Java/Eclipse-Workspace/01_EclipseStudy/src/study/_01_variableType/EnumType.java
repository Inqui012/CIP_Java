package study._01_variableType;

// 열거상수를 생성. 생성할때부터 enum 으로 생성하는 옵션이 있네.
// Enumeration Type. 열거상수 타입. 한정된 범위의 상수를 가지는 타입? 요일, 월, 시간 처럼 지정된 범위가 있는것들?
//js에서 객체를 만드는 느낌하고 비슷한가?
// public enum => 열거상수를 만들겠다는 선언 키워드
// public enum 타입이름 {열거할 상수들} = 주의. 상수들 이름은 전부 대문자로.

// 지정된 MONDAY 값을 가지고 있는 EnumType이란 이름의 객체를 생성. 상수별로 반복
public enum EnumType {
	MONDAY,
	TUSEDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY
}
