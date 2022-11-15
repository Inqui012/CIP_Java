package study._03_class;

public class FinalType {

//	final [데이터타입] [변수명] = 초기값; = 프로그램 실행중에 수정할 수 없는 최종값. 선언이나 생성자상에서 선언가능.
//	private 는 getter / setter 로 변경 가능하니 절대로 바뀌면 안되는 값에는 final을 사용.
//	메소드에 사용하면 오버라이드를 불가능하게 만들고 클래스 자체에 사용하면 상속을 불가능하게 한다.
//	static 과 함께 사용할경우 변하지 않는, 여러 클래스에서 공통적으로 사용하는 값을 지정하는용도로 쓴다.
//	값을 절대로 바뀌지 않게 할 경우 private static final 을 자주 쓰는듯? 
//	직접적으로 접근 불가 = private, 프로그램 통틀어서 = static, 바뀌지 않음 = final

//	final 변수는 반드시 초기화를 시켜줘야 사용가능하다. 변수에 직접 하던지, 생성자에서 하던지 반드시.
//	생성자로 초기화를 시키면 객체를 생성할때마다 값을 바꿀 수 있네
	final String nation = "Korea";
	final String ssn;
	String name;
	
	FinalType(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	public static void main(String[] args) {
		FinalType kr01 = new FinalType("social security number", "your name");
		System.out.println(kr01.nation);
		System.out.println(kr01.ssn);
		System.out.println(kr01.name);
		FinalType kr02 = new FinalType("Social Security Number", "Your Name");
		System.out.println(kr02.nation);
		System.out.println(kr02.ssn);
		System.out.println(kr02.name);
	}

}
