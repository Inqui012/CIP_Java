package study._07_modeling;


// 일반화관계 (상속관계). 상속은 부모클래스의 kind of 이냐로 생각하는게 좋다?
// 클래스 B, C 는 A 를 상속받은 관계이고, 클래스가 상속관계를 가져야 하는지 판단할때는 B, C 가 A의 한 종류인지 생각하는게 좋음.
// 추상클래스도 같지만 interface 는 다름. 같은 상속이란 말을 써도 관계성으로는 다르게 보는듯.
class InheritClassA {
}

class InheritClassB extends InheritClassA{
}

class InheritClassC extends InheritClassA{
}

public class Inherit {
	public static void main(String[] args) {

	}
}
