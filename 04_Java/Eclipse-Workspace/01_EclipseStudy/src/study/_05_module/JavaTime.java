package study._05_module;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JavaTime {
	public static void main(String[] args) {
//		여기도 생성자 안쓰고 .now(); 메소드로 현재날자와 시간을 가져올 수 있음.
		LocalDateTime now = LocalDateTime.now();
//		SimpleDateFormat 과 비슷한 기능을 하는 time 패키지의 클래스.
//		.ofPattern(); 으로 형식을 지정할 수 있다.
		DateTimeFormatter format01 = DateTimeFormatter.ofPattern("yyyy-MM-dd a HH:mm:ss EEE");
//		위에서 정한 형식을 LocalDateTime 에 지정할때는 .format(지정한포맷) 형식인건 똑같은듯.
		System.out.println(now.format(format01));		
		
//		해당 클래스에서 제공하는 기본 메소드들로 기존날자에서 지정한 수치의 일, 시간, 년 등을 더하고 뺀 날자를 쉽게 계산할 수 있다.
		LocalDateTime calcDate = now.plusDays(10);
		System.out.println(calcDate.format(format01));
		calcDate = now.minusMinutes(100);
		System.out.println(calcDate.format(format01));
		
//		.isAfter(); .isBefore(); .isEqual(); 과 두 날자데이터를 비교할 수있음. 반환값은 boolean.
		System.out.println(calcDate.isAfter(now));
		System.out.println(calcDate.isBefore(now));
		
//		날자를 지정하는것도 가능. LocalDateTime.of(년도, 월, 일, 시, 분, 초);
		LocalDateTime setTime = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
		LocalDateTime setTimeEnd = LocalDateTime.of(2021, 12, 31, 0, 0, 0);
		System.out.println(setTime.format(format01));
		
//		.compareTo(); 두 날자객체의 값을 비교하는 메소드. 같으면 0, 아니면 -1;
//		System.out.println(setTime.compareTo(setTime));
		
//		같은 Time 패키지 안에 있는 ChronoUnit 클래스로 두 날자사이의 년, 월, 주, 일, 시, 분, 초 계산이 가능.
		System.out.println(ChronoUnit.DAYS.between(setTime, setTimeEnd));		
	}
}
