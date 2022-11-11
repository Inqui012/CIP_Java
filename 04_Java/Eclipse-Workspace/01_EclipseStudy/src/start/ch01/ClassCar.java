package start.ch01;

//클래스 = 속성과 기능을 포함하는 객체. 멤버변수(속성), 메소드(기능), 생성자를 포함한다.
//파일 생성할때 main 체크 빼고함.
//public class 클래스이름 {}; 으로 선언한다
public class ClassCar {
//	field(멤버변수) = 객체의 데이터가 저장되는 장소. 객체 내부에서 또는 객체를 통해서만 사용가능.
//	모델, 시동여부, 현재 속도를 저장할 필드.
	String company;
	String model;
	String color;
	int maxSpeed;
	int speed;
//	boolean start;
	
//	생성자(매개변수) {}; 로 선언한다. 매개변수를 선언할경우 외부에서 객체를 생성할때 필요한 매개변수를 입력해줘야 오류가 안남.
//	클래스에서 따로 생성자롤 선언하지 않아도 기본적인 생성자는 자바에서 자동으로 생성해줌.
//	객체가 생성되는 순간 실행된다. 생성자는 클래스명과 같은 이름을 가져야한다.
	ClassCar(String model, String color, int speed) {
//		필드 초기화. 객체 안에서 데이터를 지칭할때 this. 사용 가능
		this.model = model;
		this.color = color;
		this.speed = speed;
	}
	
//	생성자 overload. 여러개의 생성자를 설정해놓을 수 있다. 보통 들어오는 매개변수의 갯수/타입에 맞춘 생성자가 실행되는것 같음.
//	생성할때 매개변수의 타입이나 순서 둘중 하나는 다르게 들어가있어야 한다.
//	생성자 안에서 다른 생성자를 실행시키는것도 가능한것 같은데
	ClassCar(String model) {
		this.model = model;
//		아래경우 받아온 매개변수 model을 입력하고 나머지 값을 상위에 있는 다른 생성자로 사용해서 생성.
//		this(model, "red", 204)   
	}
	ClassCar(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
