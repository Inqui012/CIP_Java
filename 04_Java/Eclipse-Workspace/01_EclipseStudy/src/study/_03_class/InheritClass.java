package study._03_class;

// 클래스의 상속. 코드의 중복을 방지하거나 유지보수를 위해 사용. 기본적으로 자바의 최상위 object 클래스가 최상위 부모.
// 공통된 필드, 메소드를 가지는 부모클래스와 그것을 상속해와 다른 필드가 메소드를 추가해서 생성하는 느낌.
// 상속은 위에서 아래로 아기 때문에 자식 클래스에서 위로는 거슬러 올라가서 참조할 수 있지만, 부모클래스에서 자식클래스를 참조할 수는 없음.
// public인경우 생성자를 통해서 클래스를 생성해야 필드나 메소드에 접근할 수 있는건 똑같은데 자식클래스를 생성하고 그 안에서 부모의 필드나 메소드를 참조하는경우는 실행이 되네.
// 이렇게 상속으로 클래스의 기능을 확장할경우 보통 제일 확장된 필요한 클래스의 인스턴스를 생성해서 사용하는듯. 
// 생성자를 선언하지 않으면 자바아 알아서 부모클래스의 생성자를 super(); 로 생성해준다네. 자동으로 만드는구나.
// 클래스 자체에 접근제한자는 안되지만 필드와 메소드에는 그냥 평범하게 쓸 수 있네.
// 이거 지금 한파일에 만들어서 제한자 못쓰는거 같음. 클래스에 final 설정하면 해당 클래스를 부모클래스로 사용하지 못함.
// 마찬가지로 fianl 이 붙은 메소드는 오버라이딩 불가능.

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
	
//	메소드의 매개변수를 클래스로 지정할수도 있음. 아래의 경우 부모클래스의 메소드의 매개변수를 자식클래스타입의 변수로 받는형식.
//	이렇게 실행할경우 run() 메소드는 매개변수로 받는 자식클래스에 오버라이딩 된 메소드를 호출한다.
//	매개변수로 받는 타입의 클래스에 불러오는 메소드를 오버라이딩 하지 않았을경우 자동으로 부모클래스의 값을 가져오네.
//	자식클래스 child01 형식으로 매개변수를 받는데 여기에 자손클래스인 child01_02 를 넣을경우, 자동으로 child01 형식으로 형변환이 일어남.
//	자기자신을 매개변수 타입으로 받을수도 있네
	void RefClass (Child01 Ref) {
		Ref.run();
	}
	
	void run () {
		System.out.println("부모클래스의 run");
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
	
//@Override
//	void run() {
//		System.out.println("Child01 의 run");
//	}

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
	@Override
	void run() {
		System.out.println("Child01_02 의 run");
	}
}

class Child02 extends Parent {

	Child02(String str, int cnt) {
		super(str, cnt);
		// TODO Auto-generated constructor stub
	}
	
}


public class InheritClass {
	public static void main(String[] args) {
		Parent A = new Parent(" + 일반생성", 10);
		Child01 B = new Child01();
		Child01_02 C = new Child01_02();
		Child02 D = new Child02(null, 0);
		
//		자식타입 > 부모타입 으로 클래스를 형변환 할 수 있다. 변수처럼 자식(작음) > 부모(큼) 방향이면 자동으로 변환함.
//		자식타입의 클래스를 부모타입으로 형변환 할 경우 부모클래스에 선언되어 있는 필드와 메소드에만 접근가능
//		B 인 Child01 에 선언되어 있는 count 변수, childMethod 메소드 에 접근이 불가능해짐.
//		하지만 만약 부모클래스에 있는 메소드가 변환된 자식클래스에서 오버라이딩 되어있다면 불러오는 메소드는 오버라이딩 된 자식의 메소드.
//		만약 개발자가 부모클래스는 알고있지만 자식클래스의 멤버를 자세히 모르고, 하지만 자식클래스의 메소드가 필요할경우 사용?? 교체와 유지보수가 용이하대
//		A1.count;
		Parent A1 = B;

//		매개변수의 타입변환. 
//		아래 의경우 Child01에 run 메소드를 오버라이딩 하지 않아서 부모클래스의 run이 실행됨 
//		자식클래스에서는 부모클래스의 필드와 메소드에 접근할 수 있어서.
		A.RefClass(B);
//		이건 Child01_02에 오버라이딩 된 run 메소드가 있고, 이걸 Child01로 형변환 하면서 '오버라이딩 된 메소드를 불러옴' 특성으로 불러오는거네.
		A.RefClass(C);
//		Child01 의 자식이 아닌 형제격인 child02 클래스는 형변환 안되나보네.
//		A.RefClass(D);
		
//		부모타입 > 자식타입 변환. 자식타입 > 부모타입 변환을 한번 거친 부모타입을 다시 원래의 자식타입으로 돌리는 경우에만 적용된다.
//		자식>부모 를 했을때 자식에 선언된 필드와 오버라이딩 되지 않은 메소드를 사용하고싶을때, 다시 타입을 자식으로 돌려서 사용.
//		전제조건이 한번 자식>부모 타입변환을 거친 클래스이기 때문에 강제타입변환은 if문으로 이 조건을 확인한 다음에 실행해야함.
//		확인하고싶은 객체 instanceof 확인하고싶은 타입; 형식으로 해당객체가 해당타입의 인스턴스인지 확인가능. 출력은 boolean.
//		해당 객체가 해당 타입의 상/하위 클래스인지 확인하는 기능인듯		
		System.out.println(A1 instanceof Child01);
		System.out.println(A instanceof Child01);
		System.out.println(B instanceof Child01);
//		아래 두개는 자식객체가 상위의 부모객체를 참조하고 있기 때문에 true 인것같음.
		System.out.println(B instanceof Parent);
		System.out.println(C instanceof Child01);
//		테스트. 최상위 부모인 Object를 지정해도 true가 나옴. 클래스 상속을 위로 올라가면서 확인하는것 같아.
		System.out.println(C instanceof Object);
				
//		아래 D 는 Child02 클래스이고 Child01의 자식객체가 아니라서 오류나는듯?
//		System.out.println(D instanceof Child01);
		if(A1 instanceof Child01) {
			Child01 B1 = (Child01) A1;
		}
		
	}
}