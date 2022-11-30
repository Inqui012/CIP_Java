package study._07_modeling;


// 일반화관계 (상속관계). 상속은 부모클래스의 kind of 이냐로 생각하는게 좋다? 실선에 색이 없는 삼각형
// 클래스 B, C 는 A 를 상속받은 관계이고, 클래스가 상속관계를 가져야 하는지 판단할때는 B, C 가 A의 한 종류인지 생각하는게 좋음.
// 추상클래스도 같지만 interface 는 다름. 같은 상속이란 말을 써도 관계성으로는 다르게 보는듯.
class InheritClassA {
	void methodA() {
		
	}
}

class InheritClassB extends InheritClassA{
	@Override
	void methodA() {
		super.methodA();
	}
}

// 위임관계. 상속을 할 경우의 단점으로는 자식클래스에 굳이 필요하지 않은 필드나 메소드까지 전부 가져온다는 것이다.
// 이를 방지하고 필요한 필드나 메소드만 가져오도록 하기 위한 관계가 위임관계.
// 아래처럼 상속표시인 extends 를 없애고 필드나 메소드를 가져오고싶은 클래스를 내부 필드에서 생성하여 사용한다.
// 코드가 자주 바뀌는 상황이거나 객체간의 결합도를 낮춰야할 상태에서 주로 사용한다.
// 물론 상속이 더 유리하거나 유지보수에 편리하다고 판단되면 상속을 사용함.
// 아래처럼 코드를 만들어놓으면 C 클래스에서 사용하는 metA 는 C가 A를 상속해서 오버라이딩 하는것과 별반 다를것 없...나?
// A 클래스의 메소드를 일단 실행하고, 그 뒤에 덮어씌우는 느낌으로 돌아가는건가?
class InheritClassC{
	InheritClassA test01 = new InheritClassA();
	void methodA() {
		test01.methodA();
	}
}

public class Inherit {
	public static void main(String[] args) {

	}
}
