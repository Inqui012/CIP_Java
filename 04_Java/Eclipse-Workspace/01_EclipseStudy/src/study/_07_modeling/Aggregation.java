package study._07_modeling;

// 합성관계. 실선과 색이 있는 마름모.
// AggClassA 는 합성관계로 필드에 넣는 객체들을 생성자 안에서 새로 생성해주고 있다.
// AggClassA 가 가지고 있는 객체들 a, b, c 는 객체 AggClassA 가 사라지면 전부다 사라진다. 라이프타임이 의존적이다.
// 부분객체(a, b, c)는 공유가 불가능하고, 전체객체(AggClassA)에 의존적이다. 
class AggClassA {
	private AggClass_a class_a;
	private AggClass_b class_b;
	private AggClass_c class_c;
	public AggClassA() {
		this.class_a = new AggClass_a();
		this.class_b = new AggClass_b();
		this.class_c = new AggClass_c();
	}
}

// 집약관계. 실선과 색이 없는 마름모.
// AggClassB 는 집약관계로 객체를 생성할때 A와 동일한 필드에 동일한 값을 넣지만 여기서는 객체생성이 아니라 매개변수를 받는다.
// 즉 AggClassB 에 저장되는 a, b, c 객체들은 외부에서 이미 생성되어 있고, 이를 받아와서 저장하고 있을 뿐이다.
// AggClassB 가 사라진다고 해도 외부에 생성되어 있었던 a, b, c 는 사라지지 않고, 같은 객체를 다른 클래스에 또 사용가능하다.
// 부분객체(a, b, c)가 공유가 가능하고, 전체객체(AggClassB)에 의존적이지 않다. 
class AggClassB {
	private AggClass_a class_a;
	private AggClass_b class_b;
	private AggClass_c class_c;
	public AggClassB(AggClass_a a, AggClass_b b, AggClass_c c) {
		this.class_a = a;
		this.class_b = b;
		this.class_c = c;
	}
}

class AggClass_a {
}
class AggClass_b {
}
class AggClass_c {
}
public class Aggregation {
	public static void main(String[] args) {

	}
}
