package study._03_class;

// 익명 자식 객체. 일시적으로 한번만 사용되고 버려지는 객체. 재사용 불가.
// 재사용성이 없어서 한번만 사용할 여러 객체를 전부 만드는것이 유지보수면에서 더 불리할때.
class ClassA {
	public void methodA () {
		System.out.println("methodA From ClassA");
	}
}
class ClassB {
	private ClassA A01 = new ClassA();
//	필드에서 선언.
//	새로 생성되는 ClassA 의 생성자 구문을 덮어씌우는 느낌인가? ClassA의 메소드를 오버라이딩한다.
//	오버라이딩은 자식이 부모객체를 덮어씌우는 개념이라서 이 경우는 자동으로 ClassA의 메소드를 오버라이딩한 익명의 자식객체를 생성?
//	자동으로 타입 형변환이 일어난다.
	private ClassA A02 = new ClassA() {
		@Override
		public void methodA() {
			System.out.println("Anonymous in field");
		}		
	};
	public void methodB01() {
		A01.methodA();
		A02.methodA();
	}
	
//	메소드 안에서 익명객체를 선언한다. 이경우는 메소드를 실행할때만 해당 객체를 생성하게 된다.
//	로컬 중첩 클래스...랑.... 뭐가 다르지??? 메소드 종료되면 사라지는 일회성인건 똑같지 않나.
//	아 익명객체는 일회성이니까 다른곳에서 못쓰는구나. 재사용성.
	public void methodB02() {
		ClassA A03 = new ClassA() {
			@Override
			public void methodA() {
				System.out.println("Anonymous in method");
			}	
		};
		A03.methodA();
	}
	
//	매개변수로 받아서 사용하기. 이 경우 실제 익명객체 선언은 해당 메소드를 불러오면서 하게된다.
	public void methodB03(ClassA val) {
		val.methodA();
	}
}

// 익명 구현 객체. 위와 같이 일회성으로 사용되는 인터페이스.
interface InterfaceA {
	void intMethodA();
}
class ClassC {
//	인터페이스도 객체니까 인터페이스 형으로 새로운 객체를 만들어서 그 안의 메소드를 오버라이딩 할 수 있다.
//	오버라이딩 된다는건 이거는 자동으로 implements 를 받아온 객체를 생성하는건가.
//	자동으로 형변환이 되는 이름없는 자식 객체를 생성하는건 클래스나 인터페이스나 똑같은 것 같네.
	private InterfaceA IntA01 = new InterfaceA() {
		@Override
		public void intMethodA() {
			System.out.println("intMethodA of InterfaceA in field as anonymous");
		}
	};
	public void methodC01 () {
		IntA01.intMethodA();
	}
	
//	메소드 안에서 새로운 인터페이스 구현 객체를 선언. 
	public void methodC02 () {
		InterfaceA IntA02 = new InterfaceA() {
			@Override
			public void intMethodA() {
				System.out.println("intMethodA of InterfaceA in methodC02 as anonymous");
			}
		};
		IntA02.intMethodA();
	}
	
//	매개변수로 선언.
	public void methodC03 (InterfaceA val) {
		val.intMethodA();
	}
}

public class AnonymousClass {
	public static void main(String[] args) {
		ClassB B01 = new ClassB();
		ClassA A01 = new ClassA();
		ClassC C01 = new ClassC();
		
		B01.methodB01();
		System.out.println("-----------");
		B01.methodB02();
		System.out.println("-----------");
		B01.methodB03(A01);
//		매개변수로 익명객체를 사용할때는 메소드를 불러올때 선언한다. 위의 A01과 동일한 ClassA 객체이지만
//		아래는 익명객체로 선언된 ClassA 의 자식객체가 오버라이딩한 methodA가 실행된다.
		B01.methodB03(new ClassA() {
			@Override
			public void methodA() {
				System.out.println("Anonymous ClassA in parameter");
			}	
		});
		System.out.println("-----------");
		C01.methodC01();
		System.out.println("-----------");
		C01.methodC02();
		System.out.println("-----------");
		C01.methodC03(new InterfaceA() {
			@Override
			public void intMethodA() {
				System.out.println("Anonymous InterfaceA in parameter");
			}
		});
	}
}
