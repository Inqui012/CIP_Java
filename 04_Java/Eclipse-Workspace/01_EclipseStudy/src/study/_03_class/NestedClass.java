package study._03_class;

// 중첩클래스 = 클래스 내부에서 새로운 클래스를 선언하는것.
// 멤버클래스는 컴파일후 A $ B.class 파일로 변환, 로컬클래스는 A $methodA B.class 로 생성.
// 인스턴스 멤버 클래스 = 일반 클래스 A 안에 일반 클래스 B 가 존재. A 를 생성해야만 B 를 생성가능.
// 정적 멤버 클래스 = 일반 클래스 A 안에 static 클래스 B 가 존재. A 를 생성하지 않아도 B 를 생성가능.
// 로컬 클래스 = 클래스 A 의 메소드 methodA(); 안에 클래스 B 가 존재. methodA(); 가 실행되는 중에만 B 를 생성가능.
// 상위 A 클래스에 의존적인 다른 클래스들. 두 클래스 사이의 접근이 편해진다.

// 중첩클래스의 경우 접근제한자 protect는 사용 못하는듯.

class A {
//	내부에 있는 클래스는 자유롭게 사용가능. 일반생성, 생성자 안에서 중첩클래스 생성, 메소드 안에서 생성.
//	B b01 = new B();
//	A(){B b02 = new B();}
	int a = 1;
	void methodA () {
		System.out.println("methodA From Class A");
		B b001 = new B();
		System.out.println("Create Class B inside methodA of Class A");
		class D {
			int d = 10000;
			void methodD() {
				System.out.println("Class D inside methodA of Class A");
			}
		}
//		클래스 D 의 경우 methodA() 의 안에서만 생성, 실행 가능하기 때문에 메소드 안에서 선언하고, 생성하고, 실행하는가?
		D d001 = new D();
		d001.methodD();
		System.out.println(d001.d);
//		일단 A 클래스가 생성된 다음에 실행되는 methodA() 이기 때문에 A 클래스의 모든 메소드, 필드에 접근가능.
//		반대로 아직 생성하지않은 상태의 B 클래스의 b 값에는 접근을 못하고
//		클래스 A 내부에서 생성된 B 를 통해서는 b 값에 접근할 수 있다.
		System.out.println(a);
//		System.out.println(b);
		System.out.println(b001.b);
	}
//	중첩된 인터페이스. 이런경우는 부모객체인 A 에서는 implements 가 불가능하고 동일 선상이나 하위인 B 이하에서 가능
//	A가 생성되지 않으면 해당 인터페이스도 생성이 안되기때문에 A에 의존적인 다른 중첩 클래스에서 사용하거나 익명구현으롯 사용하는듯.
	interface InterfaceA {
		int A = 10;
		void printA();
	}
	class B {
		int b = 10;
		B (){
			System.out.println("Create Class B inside Class A");
		}
		void methodB() {
//			a = 2;
			System.out.println("methodB From Class B inside Class A");
//			상위 필드 a 에 접근가능.
//			중첩클래스 B 를 생성하려면 반드시 A도 같이 생성되기 때문에 상위 클래스의 모든 필드, 메소드에 접근가능.
			System.out.println("int a From Class A = " + a);
//			내부클래스에서 외부의 필드, 메소드를 접근할경우 외부클래스.this.접근할필드,메소드 로 접근할 수 있다.
			A.this.methodA();
		}
	}
	
//	정적 클래스이기 때문에 필드에 넣어서 사용할 때에는 static 으로 만들어주는게 좋은듯
	static C c001 = new C();
	static class C {
		static int c = 100;
		static void methodC() {
			System.out.println("methodC From static Class C inside Class A");
//			상위 클래스의 필드, 메소드여도 static 으로 생성된 클래스에서는 일반 필드, 메소드를 가져올 수 없음. 
//			System.out.println("int a From Class A = " + a);
		}
	}
}

public class NestedClass {

	public static void main(String[] args) {
		A a01 = new A();
//		A클래스 안에 중첩되어 있는 B객체를 생성할때면 아래와 같이 생성한다. '.'으로 들어가는 느낌.
		A.B b01 = a01.new B();
		
		a01.methodA();
		System.out.println("-----");
		b01.methodB();
		System.out.println("-----");
		A.C.methodC();
	}

}
