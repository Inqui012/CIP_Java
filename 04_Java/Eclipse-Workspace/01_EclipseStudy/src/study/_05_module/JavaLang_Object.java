package study._05_module;

class TestingClassA implements Cloneable{
	public String testStr;
	public int[] testArr = {1, 2, 3};
	public TestingClassA(String str) {
		this.testStr = str;
	}
//	사용자가 생성하는 모든 클래스는 java.lang.Objects 를 상속하기 떄문에 Object의 모든 메소드를 오버라이딩이 가능.
//	임의로 .equals(); 메소드를 두 객체가 상속관계인지 확인하는 메소드로 오버라이딩.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TestingClassA ) {
			TestingClassA target = (TestingClassA) obj;
			if(testStr.equals(target.testStr)) {
				return true;				
			}
		} 
			return false;
	}
	public void hashTest() {
		
	}
//	Object 의 clone() 메소드를 오버라이딩 하면서 오류는 던짐. 해당 메소드가 protected 여서 이렇게 사용해야하는것 같음.
//	또한 보안상의 문제? 로 clone 을 사용할 클래스에는 Cloneable 이라는 인터페이스를 상속받아야 한다고 하네.
//	인터페이스의 상속이 없을경우 CloneNotSupportedException 에러발생.
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}

interface TestingInterfaceA {
	int A = 0;
}

class TestingClassB extends TestingClassA implements TestingInterfaceA {
	public TestingClassB(String str) {
		super(str);
	}
}
public class JavaLang_Object {
	public static void main(String[] args) throws CloneNotSupportedException {
//		java.lang.Object 클래스. 객체생성에 사용되는 최상위 클래스. 사용자가 생성하는 모든 객체는 이 클래스를 상속받는다.
//		base module 인 java.lang 에 속해있는 패키지이기 때문에 requires 같은 다른 구문 없이도 해당 패키지의 코드를 사용가능.
//		Object 클래스는 필드가 없고 11개의 메소드로 구성되어 있다.
		Object obj01 = new Object();
		Object obj02 = obj01;
		

//		.toString(); 지정된 객체로 생성된 인스턴스에대한 정보를 문자열로 바꿔주는 메소드.
//		반환되는 문자열은 객체명@인스턴스의 메모리주소값(16진수 hash코드)
//		보통은 사용자가 생성한 객체에서 오버라이딩해서 객체의 간략한 정보를 출력하도록 하는것을 권장한다.
		System.out.println(obj01.toString());
		System.out.println(obj02.toString());
		System.out.println("-------");

//		.equals(); 주로 String 비교할때 많이 쓰던것. 논리적 동등을 비교하는 메소드.
//		이거 같은거라고 생각하고있었는데 객체비교하는 equals랑 문자열 비교하는 equals는 다른애...인듯?
//		소속된 패키지가 다른가보다.jlava.lang.Object 의 equals, java.lang.String 의 equals.
//		논리적동등 = 객체자체가 아닌 객체가 저장하는 데이터가 같은것.
//		객체(String) 을 비교할때 객체가 가르키는 메모리주소값이 아니라 객체가 저장하고있는 값을 비교하는 느낌.
		System.out.println("Object's equals obj01 & obj02 : " + obj01.equals(obj02));
		System.out.println("-------");
		
		TestingClassA test01 = new TestingClassA("Black");
		TestingClassA test02 = new TestingClassA("Black");
		TestingClassA test03 = new TestingClassA("Blue");
//		오버라이딩한 객체비교 equals는 id 값으로 비교하기 때문에 서로 다른 객체인 첫줄에서 true가 나옴.
		System.out.println("TestingClassA Overrided equals test01 & test02 : " + test01.equals(test02));
		System.out.println("TestingClassA Overrided equals test01 & test03 : " + test01.equals(test03));
		System.out.println("-------");
		
//		.hashCode(); 객체가 참조하고있는 메모리의 주소값. 16진수이다.
//		객체자체의 메모리, 객체가 가지고 있는 필드의 메모리를 참조하는것도 가능.
//		서로 다른 인스턴스라도 같은 객체로 생성되었다면 필드가 가지는 메모리의 hashCode 는 같은수치네.
//		obj01 과 obj02는 같은 객체를 참조하고 있기 때문에 같은 수치가 나옴.
		System.out.println("hash Code : " + obj01.hashCode());
		System.out.println("hash Code : " + obj02.hashCode());
		System.out.println("hash Code : " + test01.hashCode());
		System.out.println("hash Code : " + test01.testStr.hashCode());
		System.out.println("hash Code : " + test02.testStr.hashCode());
		System.out.println("-------");
		
		TestingClassB test04 = new TestingClassB("RED");
		TestingInterfaceA test05 = new TestingInterfaceA() {};
		TestingClassA test06 = test04;
		TestingClassB test07 = (TestingClassB) test06;
		String test08 = "is it work?";
//		.getClass(); 해당 객체의 클래스 타입을 반환한다는데 찍히는거 보면 패키지 경로와 생성된 클래스의 명까지 나오네.
//		extends 나 implements 값이 나오는것도 아니고, 인터페이스인지 클래스인지 찍히는것도 아니고.
//		형변환이 일어났을경우에도 기존에 생성되었을때의 데이터타입을 반환하는것 같은데. 맞는듯.
		System.out.println(test01.getClass());
		System.out.println(test04.getClass());
		System.out.println(test05.getClass());
		System.out.println(test06.getClass());
		System.out.println(test07.getClass());
		System.out.println(test08.getClass());
		
//		.clone(); Object 클래스의 객체를 복사해서 새로운 객체를 반환하는 메소드. 인데 protected 여서 못쓴다?  
//		기본적으로 팰요 클래스에 오버라이딩 해서 사용하는 메소드인가?
//		Object obj03 = (Object) obj01.clone();
//		위에서 생성한 test01을 그대로 복제해서 test09를 만듬. 같은 TestingClassA 객체이지만 .clone(); 을 실행하면서
//		자동으로 Object 형으로 형변환이 일어나기 때문에 다시 강제 형변환으로 바꿔줘야 한다.		
		TestingClassA test09 = (TestingClassA) test01.clone();
//		.clone(); 가 필드의 값만 단순하게 복제한다는게 무슨소린가 했더니 이건가보네
//		test01 에 정의된 배열 testArr이 있고, 이걸 복사해서 만든 test09 에도 똑같이 배열 testArr 이 있는데
//		나는 test09 의 testArr[0] 을 변경했는데 아래에서 찍어보면 test01 의 배열값도 똑같이 바뀌어 있음.
//		이게 지금 testArr = 배열 = 배열객체의 인스턴스. 이고, 클론으로 복제해 오는건 인스턴스가 저장하고 있는 값이 아니라
//		인스턴스의 주소값임. 그러니까 testArr 이라는 배열이 있는 주소를 복제해서 만들었기 떄문에 test09에서 값을 바꾸면
//		testArr의 주소로 가서 값을 바꾸는거니, 같은 주소를 참조하고 있는 tset01 에 있는 배열의 값도 같이 바뀜.
		test09.testArr[0] = 9;
		System.out.println(test09.testStr);
		System.out.println(test01.testArr[0] + ", " + test01.testArr[1] + ", " + test01.testArr[2]);
		System.out.println(test09.testArr[0] + ", " + test09.testArr[1] + ", " + test09.testArr[2]);
		
//		.notify(); .notifyAll(); .wait(); .wait(long timeout); .wait(long timeout, int nanos);
//		이 다섯개는 쓰레드 thread 와 관련된 메소드인듯. thread 는 하나의 프로세스(프로그램) 내에서 여러 기능을 동시에 수행할 수 있게 해줌.
//		보통 클래스의 extends 로 Thread 를 상속받아서 생성한다. run(); 메소드를 반드시 구현해야한다.
//		클래스.start(); 로 thread 를 실행시킬 수 있고, 이렇게 되면 스레드가 run(); 메소드를 자동으로 실행???
//		특이점은 여러개가 동시에 실행되면서 순차적이지 않다는거...???
		
//		.finalize(); 해당 객체가 더이상 참조되지 않아서 정리할때...? protected.
	}
}
