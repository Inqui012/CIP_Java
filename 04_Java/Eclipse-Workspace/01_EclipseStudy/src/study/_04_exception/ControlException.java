package study._04_exception;

//	사용자 정의 예외. java에서 기본으로 제공하지는 않지만 개발자가 발생할 수 있는 예외를 상정하고 이에 따른 예외를 처리하기 위함.
//	Exception 이나 RuntimeException 을 상속받은 새로운 예외객체를 생성한다.
class CustomExecption extends Exception {
	public CustomExecption(){
		System.out.println("create new CustomException");
		methodTest();
	}
	public void methodTest () {
		
	}
	public CustomExecption(String msg) {
//		받아온 매개변수 문자열은 만들어놓은 에러가 왜 발생한 에러인지를 설명하는 문구를 넣어야함.
//		상위 클래스 Exception 의 Message 필드에 값을 집어넣음. 
//		아마도 Exception 생성자에 문자열이 하나인 오버라이드는 setMessage() 를 실행하는거 아닐까?
//		그래서 이 에러가 발생했을시에 에러의 원인을 알려주는 .getMessage(); 함수를 실행시키면 내가 지정한 에러 발생 원인을 출력해줌.
		super(msg);
	}
}

public class ControlException {
//  자바의 예외에는 두가지 종류가 있다. 오류는 코드의 오타같이 코드 자체에서 문제가 생긴것을 말한다.
//	예외는 코드에는 문제가 없지만 실행하는 도중에 문제가 생기는것. 컴파일이 되냐 안되냐?
//	Exception 일반예외  = 컴파일러가 예외처리코드의 존재여부를 검사하는 것. 없을경우 컴파일이 안됨.
//	Runtime Exception 실행예외 = 컴파일러가 예외처리코드의 존재여부를 검사하지 않음.
//	컴파일러에 의존하지 않기 때문에 이경우 발생하는 예외를 처리하기 위해서는 개발자가 직접 예외처리코드를 작성해야한다.
//	예외처리 코드가 없어도 컴파일은 진행되고, 실행도 되지만 예외를 만나게되었을 때 처리코드가 없으면 프로그램이 종료됨.
//	자바에서의 모든 예외들은 이미 선언된 Throwable 객체를 상속하는 자식객체들임.	
//	대강의 상속관계는 Objects > Throwable > Exception, Error 형식임.	
	public static void printLength(String data) {
		System.out.println("length of String : " + data.length());
	}
	
	public static void printArrayLength01(int[] data) {
		try {
			System.out.println(data.length);
		} catch (Exception e) {
			System.out.println("exeption");
		}
	}
	
//	printArrayLength 의 메소드를 실행할때 NullPointerException 예외가 발생한다면 실행하는 곳에서 예외처리를 해야함.
//	throws 뒤의 예외객체는 쉽표구분으로 여러개 붙일 수 있음.
//	throws 는 main 메소드에도 붙일 수 있는데 이경우에는 main을 실행하는 JVM 에 오류를 던지고, JVM은 발생한 오류를 출력한다.
	public static void printArrayLength02(int[] data) throws NullPointerException {
		System.out.println(data.length);
	}	
	
	public static void main(String[] args) {
		System.out.println("Start Program");
		printLength("ThisIsJava");
//		아래의 경우 컴파일에 에러가 없고, 실행은 되지만 중간에 에러를 만나 프로그램이 종료되고 NullPoint 예외문구를 출력한다.
//		즉 실행예외임.
//		printLength(null);
		
//		실행예외처리는 try {실행할 코드} catch(err) {예외발생시 실행할 코드} finally {예외 여부에 관계없이 실행할 코드} 형식을 가진다.
//		아래는 위와 같은 메소드를 실행하지만 catch 에서 Null 값으로 인해 생성되는 NullPointerException 객체를 감지할경우
//		is null 을 출력하고 마지막으로 finally 를 출력함.
//		catch() 의 매개변수로 들어가는것들은 자바에서 제공하는 throwable 의 자식객체들 = 예외가 발생하면 생성되는 객체들임.
//		매개변수 안의 데이터타입을 | 로 구분해서 or 구분으로 여러종류의 예외를 한가지 catch 문으로 제어 가능.
//		catch() 의 매개변수 타입으로 예외처리 객체의 최상위 객체인 Throwable을 넣으면 모든 예외를 잡나? 잡는듯.
//		catch() 문을 여러개 순서대로 작성하여 위에서부터 순서대로 예외를 처리하는 코드를 작성하는 것도 가능. 순서대로인 점에 주의해야할듯.
//		catch() 에서 매개변수로 받는 예외처리 객체 타입의 크기가 아래로 갈 수록 크게 설정해야 모든 예외처리를 순차적으로 돈다.
//		ex) catch(NullPointerException e) -> catch(Throwable e) 로 해야함.
		try {
			printLength(null);			
		} catch (Throwable e) {
			System.out.println("String is NULL");
			System.out.println("---");
//			e.getMessage(); 는 발생한 에러의 원인을 알려주는듯? null 찍네
//			get 함수인거보니까 Message 필드는 private 아니면 protected 인가보다.
			System.out.println(e.getMessage());
			System.out.println("---");
//			e.toString(); 은 에러의 객체명을 출력. 자세한 내용은 없음.
			System.out.println(e.toString());
			System.out.println("---");
//			e.printStackTrace(); 에러로 발생한 throwable 객체명과 상세한 내용을 출력.
			e.printStackTrace();
		} finally {
//			System.out.println("Print Finally");
		}

//		예외를 뒤로 미루기. try catch 문을 테스트할 메소드를 불러오는 쪽에서 실행하도록 하는것.
//		보통 프로그램 내부에서 여러군데에 쓰이는 메소드가 예외를 발생시킬경우 예외가 발생하는 위치에서 손쉽게 파악할 수 있는 장점이 있음.
//		메소드를 사용하려는 개발자가 발생할 수 있는 예외와 예외처리를 손쉽게 작성가능?
//		호출하는 쪽에서 try catch를 하기 때문에 새로운 예외를 처리해야 할 경우 메소드가 있는곳까지 찾아가지 않아도 처리가능.
//		또한 이경우 try 구문의 윗줄부터 차례로 실행하고 예외가 발생했을경우 바로 catch문으로 빠지기 때문에
//		두번째 줄의 예외가 발생하지 않는 printArrayLength(new int[5]); 가 실행되지 않는다.
		System.out.println("---");
		try {
			printArrayLength02(null);
			printArrayLength02(new int[5]);
		} catch (NullPointerException e) {
			System.out.println(e.toString());
			System.out.println("int array is null");
		}
		System.out.println("---");
		
//		에러를 던지지 않은 메소드. try catch를 메소드 안에서 해결하기 때문에 두개의 메소드가 모두 실행이 된다.
		printArrayLength01(null);
		printArrayLength01(new int[5]);
		System.out.println("---");
		
		try {
			if("test".equals("test")) {
//				if문으로 직접 에러를 실행할 조건을 정할 수 있음.
//				throw 는 에러객체를 발생시키는 키워드? new 로 직접 지정한 에러객체를 생성한다.
//				생성하면서 생성자에 sysout 넣어서 확인할 수 있음.
//				이거 객체를 생성하긴 하는데 저장하는곳이 없으니까 익명객체인가? 맞네. 오버라이드 하면 sysout찍는다.
				throw new CustomExecption();
//				throw new CustomExecption() {
//					@Override
//					public void methodTest() {
//						System.out.println("anonymous?");
//					}
//				};				
			}
//			위에서 직접 생성한 에러객체의 타입으로 에러가 발생했을경우의 예외를 지정가능.
		} catch (CustomExecption e) {
//			msg 에 아무것도 안넣었을경우에는 null 을 찍음.
//			에러객체를 생성할때의 매개변수로 문자열을 집어넣으면 해당 문자열을 출력해준다.
			System.out.println(e.getMessage());
		}

	}

}
