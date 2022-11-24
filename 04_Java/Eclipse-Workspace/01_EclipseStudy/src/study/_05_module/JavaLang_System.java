package study._05_module;

import java.io.IOException;

public class JavaLang_System {
	public static void main(String[] args) throws IOException {
//		System 객체의 err 필드. 에러를 표현할때 쓸 수 있고 콘솔에서는 붉은 글자로 나옴.
//		이것도 Object 상속받은 객체네.
		System.err.println("error print");
		
		int speed = 0;
		int keyCode = 0;
		while(true) {
//			System.in.read(); Scanner 처럼 키 입력을 하나씩 받음. 하나씩?
//			하나씩?????? +를 네개를 입력하면 while문을 네번을 도는데....흠....
//			버퍼에 순서대로 저장되고 .read() 를 통해 순서대로 읽는다는데 버퍼는 뭐지.
//			esc 키는 27번이라는데 이거 못읽는데... 뭘까
			keyCode = System.in.read();
			if(keyCode != 13 && keyCode != 10) {
				if(keyCode == 43) {
					speed++;
					System.out.println(speed);
				} else if (keyCode == 45) {
					speed--;
					System.out.println(speed);
				} else if (keyCode == 48) {
					System.out.println("0");
					break;
				}
			}
		}
		
//		시스템을 종료시키는 메소드. 매개변수로 들어가는 int 값 스테이터스는 보통 0 = 정상종료 / 1 , -1 = 비정상종료 를 의미함.
//		이 스테이터스값을 처리하는건 JVM인듯?
//		System.exit(0);
		
//		1970.1.1 부터 시작된 날자를 long 형태로 리턴함. 밀리초와 나노초...???? 
//		엑셀처럼 프로그램이 얼마동안 실행됬는지 같은 수치를 계산할때 사용됨.
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
	}
}
