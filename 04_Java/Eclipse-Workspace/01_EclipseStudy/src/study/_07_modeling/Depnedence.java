package study._07_modeling;

// 의존관계. 다이어그램에서의 표시는 점선에 화살표.
// 보통 객체가 다른 객체를 생성하거나 다른 객체의 메소드를 호출하는것을 그 객체에 의존한다고 표현한다.
// 아래 A 클래스는 메소드에 a 클래스 객체를 매개변수로 받아서 사용하는데 이렇게 들어오는 a 의 값에 따라 결과가 달라질것.
// 이렇게 다른 객체나 다른 객체의 메소드를 호출해서 나오는 값에 의해 자신의 정보가 변동될 수 있는 관계를 의존관계라고 한다.
// 의존관계와 연관관계는 비슷하지만 차이로는 협력관계의 지속시간에 있다고함.
// 연관관계는 메소드의 메개변수를 사용하거나, 메소드 안에서 객체를 생성할때를 주로 말하는듯?
// 즉 메소드가 돌아가는 동안에만 협력관계를 맺고 메소드가 종료되면 관계가 끝나는 느낌??
class DependClassA {
	private DependClass_a class_a;
	public DependClassA() {
		this.class_a = new DependClass_a();
	}
	private void dependMethod(DependClass_a a) {
	}
}

class DependClass_a {
}

public class Depnedence {
	public static void main(String[] args) {

	}
}
