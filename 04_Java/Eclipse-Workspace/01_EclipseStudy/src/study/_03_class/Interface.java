package study._03_class;

//Interface. 자바에서 다중상속의 편리성을 사용하기 위해 만들어진 키워드.
//특징으로는 다중상속이 가능함, 상수(public static final)와 추상메소드(public abstract) 만을 포함가능하다.
//enum 처럼 파일 생성시에 interface 파일목록이 따로있음.
interface Interface_A {
//	인터페이스 안에서 선언되는 필드는 따로 지정하지 않아도 자동으로 public static final 특성을 가진 상수로 지정된다.
//	메소드도 마찬가지로 abstract 지정하지 않아도 자동으로 설정됨. public도.
	int B = 100;
	public void printA();
	
//	인터페이스에서 바로 실행가능한 메소드를 구현하고 싶을때는 dafulat 제한자나 static 키워드를 이용한다.
//	추상메소드만 사용하면 자식객체에서 무조건 해당 메소드를 전부 오버라이딩해야 하는 번거로움때문에 사용.
	default void setMethod () {
		System.out.println("this is Interface_A's method");
	}
	
	public static void setStaticMethod () {
		System.out.println("this is Interface_A's static method");
	}
	
//	JAVA9 에서부터는 인터페이스 내부에서만 쓸 수 있는 메소드로 private 를 지원한다. 지금 8이라서 안됨.
//	인터페이스의 private 메소드는 getter/setter 없고 해당 인터페이스 내부의 다른 메소드 안에서 호출하는 형식으로 사용됨.
//	private void setPrivateMethod() {}
//	private static setPrivateStaticMethod() {}
}

interface Interface_B {
	public static final int A = 10;
	public abstract void printB();
}

// 인터페이스를 상속할때에는 class 상속받을 클래스명 implements 인터페이스명{} 으로 선언한다.
// 인터페이스에 추상메소드가 있을경우 반드시 이것을 상속받는 클래스에서 오버라이드해줘야 한다.
// implements 이후에 오는 상속받는 인터페이스명은 쉼표구분으로 다중상속이 가능하다.
class Class_A implements Interface_A, Interface_B{
	
	protected int c = 500;
	
	@Override
	public void printA() {
		System.out.println("printA From Class_A implements Interface_A, Interface_B");
	}

	@Override
	public void printB() {
		System.out.println("Print Interface_B's int A = " + A);
		System.out.println("Print Interface_A's int B = " + B);
	}	
}

// 이게 되네...????? Class_B 는 Interface_B를 직접상속받지 않았지만 해당 인터페이스를 상속받은 클래스 Class_A 를 상속받아서
// 부모인 Class_A 가 가지는 속성을 전부 사용할 수 있으니 Interface_B 의 상수 A 랑 printA() 에 접근이 가능하네.
class Class_B extends Class_A implements Interface_A {
	@Override
	public void printA() {
		System.out.println("printA From Class_B extends Class_A implements Interface_A");
	}

	@Override
	public void printB() {
		System.out.println("printB From Class_B extends Class_A implements Interface_A");
		System.out.println("print int c From Class_A = " + c);
		System.out.println("print int A From Interface_A = " + A);
	}
}

// 인터페이스가 인터페이스를 상속할때는 extends를 사용한다. extedns 여도 받는게 인터페이스라서 다중상속이 되네??
interface Interface_C extends Interface_A, Interface_B {
	int C = 300;
	void printC();
}
// 인터페이스 A, B를 상속받은 인터페이스 C 를 상속받아 만들어진 클래스 C
// implements 는 Interface_C 하나뿐이지만 상속으로 인해서 A, B, C의 모든 추상메소드와 상수에 접근가능하다.

class Class_C implements Interface_C {
	@Override
	public void printA() {
		System.out.println("PrintA From Class_C implements Interface_C");
	}
	@Override
	public void printB() {
		System.out.println("printB From Class_C implements Interface_C");
		System.out.println("print int A From Interface_A = " + A);
		System.out.println("print int B From Interface_B = " + B);
	}
	@Override
	public void printC() {
		System.out.println("printC From Class_C implements Interface_C");		
		System.out.println("print int C From Interface_C = " + C);		
	}
}

class Class_D {
	public int d = 77;
	public void printD() {
		System.out.println("printD From Class_D");
	}
}
// 인터페이스가 클래스를 상속받는건 안되는군.
//interface Interface_D extends Class_D {}

public class Interface {
	public static void main(String[] args) {
//		인터페이스로 객체를 생성할때는 처음부터 자식개체를 인터페이스 형으로 생성하여 자동형변환을 사용한다.
//		인터페이스 자체에는 상수하고 추상메소드밖에 없기 때문에 따로 만들 필요가 없음.
//		메소드는 오버라이딩 된다면 사용할 수 있으니까 괜찮다고 해도, 자식클래스에 있는 필드나 다른 메소드를 쓰려면 이거 안되는데
		Interface_A make01 = new Class_A();
		Class_A make02 = new Class_A();
		Class_B make03 = new Class_B();
		Class_C make04 = new Class_C();
		
//		자동 형변환때문에 Interface_RemoteControl 에 없는 메소드인 printA(); 는 실행이 안되네.
//		make01.printA();
		make01.printA();
		System.out.println("---------");
		make02.printA();
		make02.printB();
		System.out.println("---------");
		make03.printA();
		make03.printB();
		System.out.println("---------");
		make04.printA();
		make04.printB();
		make04.printC();
		System.out.println("---------");
//		인터페이스의 static 메소드를 호출하는건 클래스의 static과 같이 인터페이스명.메소드명(); 으로 호출
		Interface_A.setStaticMethod();
	}

}
