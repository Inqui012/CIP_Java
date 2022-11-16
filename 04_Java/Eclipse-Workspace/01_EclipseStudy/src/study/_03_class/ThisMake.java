package study._03_class;

public class ThisMake {
	String model;
	int speed;
	
//	매개변수로 받는 변수명이 필드명과 같기때문에 아래의 경우 this.를 사용하지 않으면 필드와 매개변수를 구분할 수 없음.
	ThisMake(String model) {
		this.model = model;
	}
	
//	매개변수로 받는 변수명과 필드명이 다르면 클래스 내에서 this.가 없어도 잘 인식하네
//	하위의 setSpeed();도 this. 생략 가능. 
	void setSpeed(int spd) {
		speed = spd;
	}
	
//	아래에서도 this.model 에서 this.를 생략할 수 있음. 클래스 내부에서 생성자나 함수까지 들여다보지는 않기 때문에
//	무조건 필드라고 인식하고 제대로 참조해서 오는것 같은데.
	void run() {
		this.setSpeed(100);
		System.out.println(this.model + ", " + this.speed);		
	}
}
