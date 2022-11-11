package start.ch01;

public class MethodMake {
//	메소드(함수)를 파일로 만들경우에는 mian void 사용하면 안됨.
//	void = return 하는값이 없다. return 값이 있는 메소드를 생성할경우에는 쓰면 안됨.
//	public (반환할 값의 데이터타입) 메소드이름 (매개변수(데이터타입 기재필수)) {기능 return 반환값}; 형태
//	데이터타입을 반드시 지정해줘야 하는 부분 말고는 대부분 JS와 동일. 반환값과 미리 선언한 데이터타입이 일치해야한다.
	
//	메소드를 호출하는건 클래스 호출과 동일함.
//	호출하고싶은 위치의 void main 안에서 (지정한 데이터타입) 값을넣을 변수명 = 메소드명(매개변수); 로 선언하면 사용가능.
//	매개변수, 반환값의 갯수와 데이터타입이 반드시 일치해야한다. 데이터타입이 제일 신경 많이 쓰는거같아.
	
//	메소드는 클래스와 다르에 스택영역안에서 생성되고 사라짐. 실행시키는 main 메소드보다 먼저 영역에 공간을 가지고
//	실행이 완료된 후에는 메인메소드를 남기고 소멸됨. 선입후출?
		public int add (int x, int y) {
			return x + y;
		}
		public double divide (int x, int y) {
			return (double) x / (double) y;
		}
		
		void powerOn() {
			System.out.println("POWER ON");
		}
		void powerOff () {
			System.out.println("POWER OFF");
		}

}
