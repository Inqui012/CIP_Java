package start.ch01;

public class If {

	public static void main(String[] args) {
		int score01 = 85;
		if (score01 >= 90) {
			System.out.println("90이상입니다.");
		} else {
			System.out.println("90미만입니다.");
		}

//		if문 사용할때 js 처럼 결과값이 한줄일경우 {} 생략 가능
		int score02 = 74;
		if (score02 >= 90) {
			System.out.println("90이상입니다.");
		} else if (score02 >= 80) {
			System.out.println("80 over");
		} else if (score02 >= 70) {
			System.out.println("70 over");
		} else {
			System.out.println("70 under");
		}

//		Math.random(); = 0.0 ~ 1.0 사이의 값이기 때문에 double 형 데이터이다.
//		아래는 주사위범위를 가지기 위해 6을 곱하고 0을 방지하기 위해 1을 더한다.
		int num01 = (int) (Math.random() * 6) + 1;
//		switch 에 들어가는 매개변수는 byte, char, short, int, long, String 사용가능.
//		실수형 데이터인 float 와 double 은 정확성에서 오차가 발생할 가능성이 있기때문에 switch문에서 사용불가.
		switch (num01) {
		case 1: 
			System.out.println("num01 : 1");
			break;
		case 2: 
			System.out.println("num01 : 2");
			break;
		case 3:
			System.out.println("num01 : 3");
			break;
		case 4: 
			System.out.println("num01 : 4");
			break;
		case 5: 
			System.out.println("num01 : 5");
			break;
		default: 
			System.out.println("num01 : 6");
		}

	}

}
