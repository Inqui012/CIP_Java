package study._03_class;

public class StaticMake {
//	Static 변수 = 모든 객체 안에서 동일하게 사용될 수 있는 변수.
//	외부에서 인스턴스를 생성하지 않고도 접근할 수 있다. 필드, 메소드 모두 가능. static 멤버.
//	반대로 인스턴스를 생성해야지만 접근하고 사용할 수 있는 일반적인 필드, 메소드는 인스턴스멤버 라고함.
	static double pi = 3.14519;
	String color = "black";
	
	static int plus (int x, int y) {
		return x + y;
	}
	
	int minus (int x, int y) {
		return x - y;
	}
	
//	정적블록 = 정적필드에 초기화 작업이 필요할때 사용한다. 정적필드를 지정할때 this 사용이 불필요.
//	this. 는 해당 객체를 지징하는것이고 정적필드는 클래스와는 별개로 구분되기 때문에 에러남.
	static String model = "calc01";
	static String number = "1";
	static String info;
	
	static {
		info = model + "_" + number;
	}

}
