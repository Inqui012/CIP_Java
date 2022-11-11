package start.ch02;

public class If_For_while {

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

//		자바에서는 for 문의 변수와 증감변수를 한번에 두개 선언할 수 있다. 조건식은 반드시 하나.
//		int j = 0;
//		for (int i = 0; i < 5; i ++, j++)
//		위처럼 변수를 밖으로 빼놓고 증감을 두개 쓰는것도 가능. 
		int sum01 = 0;
		for (int i = 0, j = 0; i < 5; i ++, j++) {
			int num02 = (int) (Math.random() * 100) + 1;
//			+= 같은 연산자를 사용할경우 반드시 한번 초기화가 필요한듯?
			sum01 += num02;
			System.out.println((i + 1) + "번째 num02 : " + num02);
			System.out.println((j + 1) + "번째 sum01 : " + sum01);
		}
		
//		부동소수점은 오차때문에 값이 정확하지 않음.
		for (float i = 0.1f; i < 1.0f; i += 0.1f) {
			System.out.println("test : " + i);
		}
		
//		구구단 찍는 이중for문
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " X " + j + " = " + i * j);
			}
		}
		
//		while(조건식){} for 랑 다르게 조건식 안에 바로 int 선언 불가능.
		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i++;
		}
		
//		while 로 1-100 합계 구하기. 증감연산자가 sum보다 먼저인지 후인지에 따라 결과값이 다르네.
		int j = 1;
		int sum = 0;
		while (j <= 100) {
			sum += j;
			j++;
		}
		System.out.println(sum);
		
//		일단 do를 한번 실행하고 while문의 조건식이 false가 될때까지 do를 반복
		do {
			j++;
			System.out.println(j);
		} while (j <= 10);
	}

}
