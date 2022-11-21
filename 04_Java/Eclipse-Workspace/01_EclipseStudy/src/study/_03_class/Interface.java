package study._03_class;

//Interface. 자바에서 다중상속의 편리성을 사용하기 위해 만들어진 키워드.
//특징으로는 다중상속이 가능함, 상수(public static final)와 추상메소드(public abstract) 만을 포함가능하다.
//enum 처럼 파일 생성시에 interface 파일목록이 따로있음.
interface Interface_RemoteControl {
//	인터페이스 안에서 선언되는 필드는 따로 지정하지 않아도 자동으로 public static final 특성을 가진 상수로 지정된다.
//	메소드도 마찬가지로 abstract 지정하지 않아도 자동으로 설정됨. public도.
	int B = 100;
	public void turnOn();
	
//	인터페이스에서 바로 실행가능한 메소드를 구현하고 싶을때는 dafulat 제한자나 static 키워드를 이용한다.
//	추상메소드만 사용하면 자식객체에서 무조건 해당 메소드를 전부 오버라이드해야 하는 번거로움때문에 사용.
	default void setMethod () {
		System.out.println("this is Interface's method");
	}
	
	public static void setStaticMethod () {
		System.out.println("this is Interface's static method");
	}
}

interface Interface_A {
	public static final int A = 10;
	public abstract void printA();
}

// 인터페이스를 상속할때에는 class 상속받을 클래스명 implements 인터페이스명{} 으로 선언한다.
// 인터페이스에 추상메소드가 있을경우 반드시 이것을 상속받는 클래스에서 오버라이드해줘야 한다.
// implements 이후에 오는 상속받는 인터페이스명은 쉼표구분으로 다중상속이 가능하다.
class Interface_Tv implements Interface_RemoteControl, Interface_A{

	@Override
	public void turnOn() {
		System.out.println("Turn on the TV");
	}

	@Override
	public void printA() {
		System.out.println("Print Interface_A's int A = " + A);
		System.out.println("Print Interface_RemoteControl's int B = " + B);
	}	
}

public class Interface {

	public static void main(String[] args) {
//		인터페이스로 객체를 생성할때는 처음부터 자식개체를 인터페이스 형으로 생성하여 자동형변환을 사용한다.
//		인터페이스 자체에는 상수하고 추상메소드밖에 없기 때문에 따로 만들 필요가 없음.
		Interface_RemoteControl make01 = new Interface_Tv();
		Interface_Tv make02 = new Interface_Tv();
		
//		자동 형변환때문에 Interface_RemoteControl 에 없는 메소드인 printA(); 는 실행이 안되네.
//		make01.printA();
		make01.turnOn();

		make02.printA();
		make02.turnOn();
		
//		인터페이스의 static 메소드를 호출하는건 클래스의 static과 같이 인터페이스명.메소드명(); 으로 호출
		Interface_RemoteControl.setStaticMethod();
	}

}
