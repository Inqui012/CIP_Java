package study._05_module;

public class JavaLang_Math {
	public static void main(String[] args) {
		int a = -100;
		int b = 100;
		float c = -50.1156f;
		double d = 10.5555555;
		int e = 25;
		
//		Math.abs(); 매개변수로 받는 값의 절댓값(양수값)을 반환한다.
		System.out.println(Math.abs(a));
		System.out.println(Math.abs(b));
		System.out.println(Math.abs(c));
		System.out.println("-------------");
		
//		Math.ceil(); 매개변수로 주어지는 실수를 소숫점 올림으로 정수까지만 표현한다.
		System.out.println(Math.ceil(c));
		System.out.println(Math.ceil(d));
		System.out.println("-------------");
		
//		Math.floor(); 매개변수로 주어지는 실수를 소숫점 버림으로 정수까지만 표현한다.
		System.out.println(Math.floor(c));
		System.out.println(Math.floor(d));
		System.out.println("-------------");
		
//		Math.round(); 주어지는 실수를 소숫점 반올림으로 정수까지만 표현.
		System.out.println(Math.round(c));
		System.out.println(Math.round(d));
		System.out.println("-------------");

//		Math.max(); Math.min(); 두 값에서 큰값과 작은값을 출력.
		System.out.println(Math.max(a, b));
		System.out.println(Math.min(a, b));
		System.out.println("-------------");
		
//		Math.sqrt(); 제곱근을 double 값으로 반환.
		System.out.println(Math.sqrt(144));
		System.out.println(Math.sqrt(145));
	}
}
