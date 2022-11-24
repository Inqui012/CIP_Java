package study._05_module;

// Wrapper Class = 포장 클래스. 자바의 기본 데이터타입을 생성하기 위해서 존재하는 클래스? primitive 타입을 위한 클래스.
// byte = Byte 클래스 / char = Character 클래스 ...
public class JavaLang_WrapperClass {
	public static void main(String[] args) {
//		기본타입의 변수가 아니라 포장객체를 생성하는것을 boxing 이라고 한다.
//		새로운 객체를 생성하면서 매개변수에 "" 안에 값을 넣어주거나, 아니면 그냥 변수처럼 값을 바로 넣을수도 있음.
//		바로 값을 넣어주면 자동으로 boxing을 실행해서 객체를 생성하는듯. 
		Integer intObj = new Integer("100");
		Long longObj = 999999999999999999L;
//		객체인데 찍으면 바로 값이 보이네....?
		System.out.println(intObj);
		System.out.println(longObj);
		System.out.println("-------");
		
//		위와 같은 형식으로 객체형으로 만들어진 값들을 다시 기본타입 값으로 바꾸는 것을 unboxing 이라고 함.
//		딱히 별다른 구문없이 바로 값이 들어간다.
		int a = intObj;
		long b = longObj;
//		.intValue(); 를 하면 해당 객체의 값을 int 형으로 바꿔서 가져오는듯. 모든 타입마다 있음.
//		박스형에 연산자를 대입하면 자동으로 언박싱 후 연산자를 실행한다.
		System.out.println(intObj.intValue());
		System.out.println(intObj + 10);
		System.out.println(a);
//		강제로 int형으로 바꿔서 가져오네. 오버플로워 일어남.
		System.out.println(longObj.intValue());
		System.out.println(b);
		System.out.println("-------");
		
//		이경우 비교하는것들은 '객체'이기 때문에 == 으로는 false, .equals로는 true 를 찍는다.
		Integer intObj01 = new Integer("100");
		System.out.println(intObj == intObj01);
//		객체가 저장하는 값을 비교하는 equals 인데 포장클래스 내부적으로 값을 비교하도록 오버라이딩 되어 있다고 하네.
		System.out.println(intObj.equals(intObj01));
		System.out.println("-------");
//		박싱된 객체의 비교에서 예외가 존재하는데
//		Boolean 의 true/false, char 의 문자, (byte, shor, int) 의 -128 부터 127 까지의 값은 == 으로도 값 비교가 가능.
		Integer intObj02 = 10;
		Integer intObj03 = 10;
		System.out.println(intObj02 == intObj03);
		System.out.println(intObj02.equals(intObj03));
	}
}
