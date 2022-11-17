package study._03_class;

// 클래스의 상속. 코드의 중복을 방지하거나 유지보수를 위해 사용.
// 공통된 필드, 메소드를 가지는 부모클래스와 그것을 상속해와 다른 필드가 메소드를 추가해서 생성하는 느낌.
// 상속은 위에서 아래로 아기 때문에 자식 클래스에서 위로는 거슬러 올라가서 참조할 수 있지만, 부모클래스에서 자식클래스를 참조할 수는 없음.
// public인경우 생성자를 통해서 클래스를 생성해야 필드나 메소드에 접근할 수 있는건 똑같은데 자식클래스를 생성하고 그 안에서 부모의 필드나 메소드를 참조하는경우는 실행이 되네.
// 이렇게 상속으로 클래스의 기능을 확장할경우 보통 제일 확장된 필요한 클래스의 인스턴스를 생성해서 사용하는듯. 
// 생성자를 선언하지 않으면 자바아 알아서 부모클래스의 생성자를 super(); 로 생성해준다네. 자동으로 만드는구나.
// 클래스 자체에 접근제한자는 안되지만 필드와 메소드에는 그냥 평범하게 쓸 수 있네.

class Parent {
	String parentStr = "부모클래스";
	int cnt = 0;
	private String Test01;
	
	void parentMethod() {
		System.out.println("Parent Class : " + parentStr);
		cnt += 10;
	}
	
	Parent (String str, int cnt) {
		this.parentStr += str;
		this.cnt = cnt;
	}
}

class Child01 extends Parent {
	String childStr01 = "자식01 문자열";
	int count = 0;
	
	void childMethod() {
//		부모클래스에서 선언한 메소드를 사용하고 그 값을 가져온는것도 가능.
		parentMethod();
		System.out.println(childStr01 + " : " + cnt);
	}
	
//	부모객체의 생성자에 매개변수가 필요할경우 자식개체의 생성자 첫줄에 반드시 super();형으로 매개변수를 줘야함.
	Child01(){
		super(" + 자식클래스 생성자", 5);
	}
}

// 자식클래스의 자식클래스도 만들 수 있음. 계속 내려감.
class Child01_02 extends Child01 {
	String childStr02 = "자식01_02 문자열";
	void child01_02Method() {
//		부모클래스에서 선언한 변수에 접근해서 값을 변경할 수 있음.
		count = 50;
		childMethod();
		System.out.println(childStr02 + " : " + count);
	}
	void child02toparent() {
		cnt = 100;
		System.out.println(cnt);
		System.out.println(count);
	}
}


public class InheritClass {
	public static void main(String[] args) {
		Parent A = new Parent(" + 일반생성", 10);
		Child01 B = new Child01();
		Child01_02 C = new Child01_02();
		A.parentMethod();
		System.out.println("----------------------");
		B.childMethod();
		System.out.println("----------------------");
		C.child01_02Method();
		System.out.println("----------------------");
		C.child02toparent();
	}
}