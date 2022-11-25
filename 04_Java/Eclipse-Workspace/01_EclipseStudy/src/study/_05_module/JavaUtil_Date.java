package study._05_module;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtil_Date {
	public static void main(String[] args) {
//		java.util 의 Date 클래스. 단순하게 날자를 저장하기 위한 객체?
//		현재는 삭제되는 메소드도 많고 해서 자주 안쓰나? Calendar 를 더 많이 쓰는 추세?
//		둘다 날자를 다루는 클래스인건 맞으니 상호작용을 하면서 사용할 수도 있다.
		Date testDate = new Date();
		String strTestDate = testDate.toString();
		
//		SimpleDateFormat 클래스. java.text 에 위치함.
//		보통 Date 객체를 출력할때 어떤 형식으로 만들것인지 지정해주는 클래스이다.
//		생성할 포맷약어의 자세한 내용은 api 페이지 참조. 
		SimpleDateFormat testFormat = new SimpleDateFormat("yyyy-MM-dd 'T'HH:mm:ss .SSSXXX");
		
//		찍히는건 같지만 testDate 는 Date 객체의 인스턴스지만 아래는 문자열이다.
		System.out.println(testDate);

//		생성한포맷.format(Date인스턴스); 형식으로 지정된 Date 인스턴스의 날자를 지정한 형식으로 표현할 수 있도록 바꿔준다.
//		이때 반환되는 형식을 갖춘 날자는 SimpleDateFormat 객체의 인스턴스...겠지? 아니다. StringBuffer 형태.
		System.out.println(testFormat.format(testDate));

//		.toLocalizedPattern(); 은 해당 인스턴스에 지정된 형식을 그냥 문자열로 보여주는듯.
		System.out.println(testFormat.toLocalizedPattern());
//		System.out.println(testFormat.parse(strTestDate, 0));
		
		System.out.println(strTestDate);
	}
}
