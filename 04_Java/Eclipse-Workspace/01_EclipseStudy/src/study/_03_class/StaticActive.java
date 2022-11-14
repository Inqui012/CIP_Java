package study._03_class;

public class StaticActive {

	public static void main(String[] args) {
		
//		Static 변수와 메소드를 인스턴스를 생성하지 않고 접근할 수 있다.
//		접근방법도 생성한 인스턴스의 변수명이 아니라 본래의 클래스명.변수명 | 메소드명으로 가능.
		System.out.println(StaticMake.plus(5, 8)); 
		System.out.println(StaticMake.pi); 

//		Static 변수가 아닌 변수와 메소드는 인스턴스 생성없이는 실행할 수 없음.
//		System.out.println(StaticMake.minus(5, 8)); 
//		System.out.println(StaticMake.color); 
		
//		인스턴스를 생성하고 Static 변수나 메소드에 물론 접근가능하지만 굳이..?
		StaticMake test01 = new StaticMake();
		System.out.println(test01.color); 
		System.out.println(test01.minus(9, 4)); 
		
		
	}

}
