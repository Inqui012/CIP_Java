package study._07_modeling;

// 실체화 관계. 인터페이스와 클래스와의 관계를 보통 실체화 관계라고 함.
// 인터페이스는 실제 작동하는 코드를 가지고 있지 않고 메소드의 타입과 이름만가지고 있고(책임)
// 이 기능들을 실제로 구현하고 실행하는건 인터페이스를 상속하는 클래스이다(책임수행)
// 따라서 책임을 정의만 하는 인터페이스와 실제로 수행하는 클래스와의 관계를 표현하는것이 실체화관계임.
// 자식객체가 can do this 인터페이스 라는 느낌으로 본다. 점선에 삼각형.

// 인터페이스에 지정된 추상메소드 aaa 는 책임으로 실제 기능을 구현하지는 않는다.
// 이를 상속받은 AA 클래스에서 aaa를 재정의하여 기능을 정의하고 실행하기 때문에 이 둘의 관계는 실체화 관계라고 함.
// 형태만 있는 interface 를 구체적으로 기능하도록 실체화시키는 관계?
interface A {
	void aaa();
}
class AA implements A {
	@Override
	public void aaa() {
	}
}
public class Realization {
	public static void main(String[] args) {

	}
}
