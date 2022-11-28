package study._06_reflectAnno;

import java.lang.reflect.*;

// Reflection = 메타정보 (클래스의 패키지정보/타입, 멤버/생성자/필드/메소드, 리소스의 경로) 등을 읽고 수정하는 행위
class TestClassA {
	int a = 10;
	void methodB(String a, int b) {
		System.out.println("methodA From TestClassA");
	}
	void methodC(boolean f, double a) {
		System.out.println("methodA From TestClassA");
	}
	void methodA() {
		System.out.println("methodA From TestClassA");
	}
	TestClassA(){
		System.out.println("Const with Nothing");		
	}
	TestClassA(String t){
		System.out.println("Const with String");
	}
}
public class Reflection {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		아래의 Class는 내가 만들던 그 클래스가 아니라 정보를 얻어올때 사용하는 Class 라는 이름의 객체.
//		Class 객체로 클래스 정보를 불러오는 방법에는 세가지 방법이 있다. 
//		Class 변수명 = 클래스이름.class;
		Class refClassTest = TestClassA.class;
		
//		Class 변수명 = Class.forname("패키지이름.클래스이름");
//		해당 방법은 오류처리를 해야하기 때문에 try/catch 문을 쓰거나 오류를 던져아함.
		Class refClassTest01 = Class.forName("study._06_reflection.TestClassA");
		
//		Class 변수명 = 인스턴스변수명.getClass();
//		일반적인 방법으로 일단은 해당객체의 인스턴스를 생성하고 해당 인스턴스에서 객체의 정보를 얻어오는 방법.
		TestClassA testClass = new TestClassA();
		Class refClassTest02 = testClass.getClass();
		
//		.getPackage(); 지정된 클래스가 소속되어 있는 패키지의 정보를 가져온다.
//		.getName(); 지정된 클래스나 패키지의 이름을 가져올때. 안쓰면 다른 정보도 같이 표시되나 본데.
		System.out.println(refClassTest.getPackage());
		System.out.println(refClassTest.getPackage().getName());
		System.out.println(refClassTest.getName());		
		
		Object testClass01 = new TestClassA();
		System.out.println("------");
//		Object 형태로 자동 형변환이 된 클래스라서 TestClassA 가 가지고 있는 메소드는 자식메소드이기 때문에 가져올 수 없음.		
//		testClass01.methodA();
		Class refClassTest03 = testClass01.getClass();
//		Constructor 객체로는 지정된 객체가 가지고 있는 생성자의 정보를 가져온다. 보통 생성자가 여러개 있을 수도 있으니 반환값은 배열.
//		매개변수에 똑같이 생성자에 들어가는 매개변수의 테이터타입.class 를 넣어줄 수 있는것 같은데 이러면 해당 매개변수를 가지는 생성자만을 불러오나?
//		만들어진 constructor 객체로 새로운 인스턴스를 만드는것도 가능.
//		.newInstance(생성자에 필요한 매개변수); 형태를 사용하고 만들고싶은 객체를 Constructor 형으로 만들어내니까 다시 강제 형변환이 필요.
		Constructor[] refConstTest01 = refClassTest03.getDeclaredConstructors();
		Constructor refConstTest02 = refClassTest03.getDeclaredConstructor(String.class);
		TestClassA testClass02 = (TestClassA) refConstTest02.newInstance("a");
		System.out.println(refConstTest02.getName());
		System.out.println("------");
		
//		Field 객체로는 지정된 객체의 필드정보를 받아올 수 있음. for문으로 받아온 값을 전부 돌릴 수도 있고....
		Field[] refFieldTest01 = refClassTest03.getDeclaredFields();
		for(int i = 0; i < refFieldTest01.length; i++) {
			System.out.println(refFieldTest01[i].getType().getName() + " : " + refFieldTest01[i].getName());
		}
		System.out.println("------");
		
//		Method 객체로 지정된 객체가 가지고 있는 메소드를 가져올 수 있다. 클래스에는 메소드가 여러개 있기 때문에 보통은 배열로 받아옴.
//		.getDeclaredMethods(); 매개변수가 없다면 배열로 받아오고, 매개변수가 있다면 지정된 메소드만을 받아옴.
//		("불러올 메소드명", 해당 메소드에 필요한 매개변수타입.class); 형태의 매개변수를 넣어줄 수 있음.
		Method[] refMethodTest01 = refClassTest03.getDeclaredMethods();
		
//		.getParameterTypes(); 로 해당 메소드나 생성자가 가지고 있는 매개변수의 정보를 배열로 Class[] 로 받아올 수 있다.
//		이걸 응용해서 다른 메소드를 만들어서 메소드의 이름과 해당 메소드에 무슨 타입의 매개변수를 필요로 하는지 알 수 있음.
//		근데 이거 왜 찍히는 순서가 bca 야. 찍을때마다 순서가 다른데?
//		Method 객체가 메소드를 가져오는거에 딱히 순서가없고 그냥 있는거 무작위로 가져오나보지....? 
//		getDeclaredMethod 를 사용해서 Method 객체로 받은 메소드를 실행하기 위해서는
//		메소드객체변수명.invoke(new 메소드의기존객체()); 로 사용한다.
		for(int i = 0; i < refMethodTest01.length; i++) {
			System.out.print(refMethodTest01[i].getName() + " (");
			Class[] params = refMethodTest01[i].getParameterTypes();
			printParam(params);
			System.out.println(")");
		}
		System.out.println("------");
		
//		이외에도 리소스(외부 파일)들의 경로(url)를 얻어올수도있다.	
//		.getResouce("파일명.확장자"); 로 지정한 리소스 파일을 가져온다. 앞에 클래스는 왜쓰는거지
//		.getPath(); 가져온 리소스파일의 절대경로를 가져옴. 이건 더 알아봐야할듯.
		String refRrcTest01 = refClassTest03.getResource("simpleXivLogo.png").getPath();
		System.out.println(refRrcTest01);
		System.out.println("------");
	}
	
	private static void printParam (Class[] param) {
		for (int i = 0; i < param.length; i++){
			System.out.print(param[i].getName());
			if(i < param.length - 1) {
				System.out.print(", ");
			}
		}
	}
}
