package study._05_module;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class JavaLang_Text {
	public static void main(String[] args) {
		double num01 = Math.random() * 1000000000;
//		숫자의 표현형식을 결정하는 클래스. DateFormat 이랑 비슷함.
//		사용할 수 있는 형식은 단순하게 0으로 소수몇자리를 표시할건지, 정수 몇자리를 표시할건지.
//		정수를 실제 숫자보다 더 큰 숫자로 설정해놓으면 앞자리는 0으로 채운다.
		DecimalFormat testFormat = new DecimalFormat("0.00");
		DecimalFormat testFormat01 = new DecimalFormat("000000.00");
		System.out.println(testFormat.format(num01));
		System.out.println(testFormat01.format(num01));
		
//		#으로도 0처럼 표현할 수 있는데, 이경우 정수부분이 실제 숫자보다 커도 남는 자리를 채우지 않음.
//		소숫점 아래로도 숫자가 없으면 표시가 안되네
		DecimalFormat testFormat02 = new DecimalFormat("#######.####");
		System.out.println(testFormat02.format(num01));
		
//		수치앞에 +, - 기호를 붙여서 양수 음수를 표현하는것도 가능.
		DecimalFormat testFormat03 = new DecimalFormat("+####.##");
		DecimalFormat testFormat04 = new DecimalFormat("-####.##");
		System.out.println(testFormat03.format(num01));
		System.out.println(testFormat04.format(num01));
		
//		쉼표위치도 임의로 정할 수 있는데 왜....이럴까
//		정수부분에 #이랑 0이랑 섞어서 써도 오류는 안나는데 의도한 모양이 되는지는 좀 헷갈리는것 같네
		DecimalFormat testFormat05 = new DecimalFormat("#,##.0");
		System.out.println(testFormat05.format(num01));
		
//		지수형식으로 표현...?
		DecimalFormat testFormat06 = new DecimalFormat("0.0E0");
		System.out.println(testFormat06.format(num01));
		
//		이외에도 양수, 음수를 ;를 사용해서 동시에 설정할 수 있고
//		% 문자를 붙이거나 통화기호를 유니코드? 같은 형식으롯 설정해줄 수도 있다.		
		
//		정규표현식. 표현식의 기호자체를 외울 필요는 딱히 없지만 어떻게 사용되는지는 알아야한다.
//		Java.Util 의 regex 패키지를 사용해서 해당 문자열이 지정한 패턴에 맞는지를 확인할 수 있다.
//		String 문자열에서 \ 를 인식을 못하기 때문에 \\ 로 표현해야함.
		String regEx = "(010|02)-\\d{3,4}-\\d{4}";
		String str01 = "010-123-4567";
//		Pattern.matches(정규표현식 문자열, 테스트할 문자열);
//		테스트할 문자열이 지정한 표현식에 맞는 형식을 가지고 있는지 테스트하고 반환값을 true/false 로 돌려준다.
		boolean regExCheck = Pattern.matches(regEx, str01);
		System.out.println(regExCheck);
		regEx = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		str01 = "testttt@nnnnnnjjjjj";
		regExCheck = Pattern.matches(regEx, str01);
		System.out.println(regExCheck);
	}
}
