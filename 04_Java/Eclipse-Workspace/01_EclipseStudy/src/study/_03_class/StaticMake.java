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
}
