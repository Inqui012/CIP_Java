package start.ch01;

// Scanner 클래스를 자바에서 불러오기 때문에 작성하는 클래스의 파일명이 Scanner로 동일하면 오류남. 주의
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
//		클래스이름 변수명 = new 객체생성; 자바에서는 앞에 변수종류가 아니라 클래스 이름을 줘야한다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("X값 입력 : ");
//		엔터키의 입력이 있을경우 문자열을 읽어온다.
		String strX = scanner.nextLine();
		int x = Integer.parseInt(strX);

		System.out.println("Y값 입력 : ");
		String strY = scanner.nextLine();
		int y = Integer.parseInt(strY);
		
		int result = x + y;
		System.out.println("Result : " + result);
		System.out.println();
		while (true) {
			System.out.println("입력 문자열 : ");
			String data = scanner.nextLine();
//			문자열 변수 data와 "q" 를 비교한다. js의 data === 'q' 와 같음.
//			다른 변수들은 js와 같이 써도 괜찮지만 non-primitive 변수인 String은 안됨.
			if(data.equals("q")) {
				break;
			}
		}
//		'scanner' is never closed 오류가 났을때 아래 구문 추가
		scanner.close(); 
	}

}
