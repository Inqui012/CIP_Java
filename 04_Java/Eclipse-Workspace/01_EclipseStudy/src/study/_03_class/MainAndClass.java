package study._03_class;

public class MainAndClass {

	int speed;
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}
	
//	정적메소드이기 때문에 클래스 안에 있어도 메모리상에서의 취급이 달라서 상위 클래스 생성자를 불러올 수 있다?
//	정적 아니어도 에러 안나는거 같은데? 안나네. 
//	변수명이 같아도 new로 새로운 객체를 만들었기 때문에 에러가 안나나?? 메소드의 외부와 내부는 다른 블록 취급이라서 그런가?
//	서로 다른 메소드안의 변수라서 에러가 안나는것 같음. 메소드는 하나의 블록이니까...
//	원하는 변수를 불러오기 위해선 해당 메소드 안에서 불러야함.
	static void simulate() {
		MainAndClass test01 = new MainAndClass();
		test01.speed = 200;
		test01.run();
	}	
	
//	실행은 항상 main 메소드부터
	public static void main(String[] args) {
		
//		MainAndClass.simulate(); 가 정확한데 현 상황으로는 호출하는 메소드도 같은 클래스 안에 있기 떄문에 지정 불필요.
//		같은 클래스 안에서는 클래스명을 지정하지 않아도 실행가능.
		simulate();
		MainAndClass test01 = new MainAndClass();
//		MainAndClass test01 = new MainAndClass();
		test01.speed = 60;
		test01.run();
		
		System.out.println(test01);

	}

}
