package study._06_reflection;

// Reflection = 메타정보 (클래스의 패키지정보/타입, 멤버/생성자/필드/메소드, 리소스의 경로) 등을 읽고 수정하는 행위
class TestClassA {
	int a = 10;
	void methodA() {
		System.out.println("methodA From TestClassA");
	}
}
public class Reflection {
	public static void main(String[] args) {
//		아래의 Class는 내가 만들던 그 클래스가 아니라 정보를 얻어올때 사용하는 Class 라는 이름의 객체.
		Class refClassTest = TestClassA.class;
//		.getPackage(); 지정된 클래스가 소속되어 있는 패키지의 정보를 가져온다.
//		.getName(); 지정된 클래스나 패키지의 이름을 가져올때. 안쓰면 다른 정보도 같이 표시되나 본데.
		System.out.println(refClassTest.getPackage());
		System.out.println(refClassTest.getPackage().getName());
	}
}
