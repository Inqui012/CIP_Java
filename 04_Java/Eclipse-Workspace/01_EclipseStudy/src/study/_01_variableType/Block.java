package study._01_variableType;

public class Block {

	public static void main(String[] args) {
//		변수의 사용범위. var01 은 main 블록 안에서는 전부 사용가능. 지역변수.
//		var02 는 if문의 블록 안에서 선언되었기 때문에 밖에서는 접근이 불가능하다.
//		if문 안의 var02 와 밖의 var02 는 다른 변수로 생각되어서 같은 변수병이라도 두번 선언할 수 있고 가지고 있는 값도 다름.
		int var01 = 15;
		if (var01 > 10) {
			int var02 = var01 - 10;
			System.out.println(var02);
		}
		int var02 = 10;
		int var03 = var01 + var02 + 5;
		System.out.println(var03);
		
		String var04 = "string";
//		출력종류
		System.out.println("엔터가 들어감");
		System.out.printf("변수: %d\n", var01);
		System.out.printf("문자열: %s\n", var04);
		System.out.printf("변수01 정수로 : %d %n변수02 실수로 : %d\n", var01, var02);
//		%6d = 6자리의 정수 앞의 빈자리에는 공백. %-6d = 6자리의 정수 뒤의 빈자리에 공백.
		System.out.printf("정수출력 : %6d\n", 1234);
		System.out.printf("정수출력 : %-6d\n", 1234);
//		%10.2f = 10자리 정수와 소수2자리까지 출력. 앞의 빈자리 공백.
		System.out.printf("소수출력 : %10.2f\n", 123456789123456.234);
		
String pyra = "";
for (int i = 0; i <= 5; i++) {
	for(int j = 1; j <= i; j++) {
		pyra += "*";
	}
	pyra += "\n";
}
System.out.println(pyra);
		
	}

}
