package start.ch01;

public class Variable {
//	 main 안의 코드가 가장 먼저 실행됨. 
//	 숫자는 기본 1byte(8bit) 로 표기되고 8bit중 최상위비트 1bit은 부호표시용도로 사용한다.
//	 변수지정할때 2진법일경우 0b 로시작, 8진법 0으로 시작, 16진법 0x로 시작.
//	 양수 > 음수 변환. 2의 보수법.	
	public static void main(String[] args) {
//		System.out.println(); = console.log();
		System.out.println("Hello");
//		변수가 메모리에 공간을 가지게 되는것은 변수에 값이 들어가는 순간.
//		int a; 상태에서는 메모리를 가지고 있지 않음.
		int a = 10;
		float b = 2.5f;
//		변수는 반드시 초기화를 해 줘야 에러 없이 실행이 가능.	
		int num = 0;
		
		int var01 = 0b1011;
		int var02 = 02255;
		int var03 = 0x12a;
		long var04 = 999999999999999999L;
		
		char var05 = 'a';
		char var06 = 65;
//		이스케이프 문자. \n, \t, \', \\, \" 사용가능.		
		String init = "hello there 'one qoute' \"tow qoute\"";
		
//		자바에서의 실수는 부동소수점 방식으로 저장한다.
//		e를 10의 지수로 계산해서 가수e지수값 으로 표현할 수도 있다.
//		3승 이상으로는 출력도 e로 되는듯.		
		float var07 = 2.444f;
		double var08 = 0.0000000005;
		
		boolean var09 = true;
		boolean var10 = (a == 20);
		
		System.out.println("ADD : " + (a+b));
		System.out.println("MINUS : " + (a-b));
		System.out.println("NUM : " + num);
		System.out.println("02NUM : " + var01);
		System.out.println("08NUM : " + var02);
		System.out.println("16NUM : " + var03);
		System.out.println("LONG : " + var04);
		System.out.println("CHAR : " + var05);
		System.out.println("UNICODE : " + var06);
		System.out.println("STRING : " + init);
		System.out.println("FLOAT : " + var07);
		System.out.println("DOUBLE : " + var08);
		System.out.println("BOOLEAN : " + var09);
		System.out.println("BOOLEAN : " + var10);
	}

}
