package study._07_modeling;

// 싱글톤 패턴 = 하나의 객체만 생성해서 사용한다. 객체를 하나밖에 생성할 수 없도록 제한하는법. 객체지향 패턴중 하나.
// 객체를 하나만 생성할 수 있기 때문에 메모리 낭비가 없다? 보통은 static 으로 선언하기 때문에 여러 클래스에서 사용하기 쉽다.
// 근데 여러 클래스에서 싱글톤에 동시에 접근하면 문제가 될수도 있다? 이런 문제를 관리하기 위해 코드가 많이 필요하다.
// 자식클래스 생성불가, 내부적으로 상태를 변경하기 어려움등의 문제점도 많음. 찾아볼것.
class SingleT{
//	좀 더 확실하게 외부에서 변경하지 못하게 하려면 final 도 붙여주면 됨. 이렇게 할거면...enum 에 선언해도 되지 않을까?
//	외부에서는 클래스를 생성할 수 없기 때문에 직접 클래스 안에 자기 자신을 생성한 인스턴스를 가지게 만든다.
//	이걸 외부에서 사용할 수 있도록 static 으로 선언해줘서 이 인스턴스를 외부에서 사용함. 외부에서 쉽게 접근할 수 없도록 private.
	private static SingleT test01 = new SingleT();
// 클래스의 생성자가 private 라 외부에서 생성을 못함.
	private SingleT() {}
//	private로 선언한 인스턴스는 static 이어도 직접적으로는 호출하지 못하니 해당 인스턴스를 반환하는 get메소드를 public static으로 선언.
//	외부에서 이 메소드를 호출하면 결과적으로 SingleT 객체로 생성된 인스턴스를 사용할 수 있다.
	public static SingleT getSingleT() {
		return test01;
	}
//	이외에도 필드에는 null 로 선언한 뒤 메소드에서 if문으로 null일경우 생성하도록 할 수 있다. 
//	이걸 지연초기화(lazy initialization) 이라고 하는듯.
//	동시사용을 방지하기 위해 boolean 값의 필드를 하나 선언하고 사용시작, 종료하는 메소드에 해당 값을 지정해서
//	이걸 토대로 다른 클래스가 접근했을때 현재 해당 인스턴스가 사용중인지 확인하여 실행할 수 있도록 할 수 있다.
}

// enum 형식으로 구현한 싱글톤객체. 안에 변수도넣을 수 있고, 메소드도 넣을 수 있으니 이렇게 해도 되겠네.
// 호출할때는 SingleTT.INSTANCE 로 호출하면 해당 enum으로 한번 생성자를 통과해서 인스턴스를 생성하고 걔네를 사용하게됨.
enum SingleTT{
	INSTANCE;
}
public class SingletonPattern {
	public static void main(String[] args) {

	}
}
