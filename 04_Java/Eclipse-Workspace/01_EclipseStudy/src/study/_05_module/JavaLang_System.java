package study._05_module;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class JavaLang_System {
	public static void main(String[] args) throws IOException {
//		System 객체의 err 필드. 에러를 표현할때 쓸 수 있고 콘솔에서는 붉은 글자로 나옴.
//		이것도 Object 상속받은 객체네.
//		System.err.println("error print");
		
		int speed = 0;
		int keyCode = 0;
//		while(true) {
////			System.in.read(); Scanner 처럼 키 입력을 하나씩 받음. 하나씩?
////			하나씩?????? +를 네개를 입력하면 while문을 네번을 도는데....흠....
////			버퍼에 순서대로 저장되고 .read() 를 통해 순서대로 읽는다는데 버퍼는 뭐지.
////			esc 키는 27번이라는데 이거 못읽는데... 뭘까
//			keyCode = System.in.read();
//			if(keyCode != 13 && keyCode != 10) {
//				if(keyCode == 43) {
//					speed++;
//					System.out.println(speed);
//				} else if (keyCode == 45) {
//					speed--;
//					System.out.println(speed);
//				} else if (keyCode == 48) {
//					System.out.println("0");
//					break;
//				}
//			}
//		}
		
//		시스템을 종료시키는 메소드. 매개변수로 들어가는 int 값 스테이터스는 보통 0 = 정상종료 / 1 , -1 = 비정상종료 를 의미함.
//		이 스테이터스값을 처리하는건 JVM인듯?
//		System.exit(0);
		
//		1970.1.1 부터 시작된 날자를 long 형태로 리턴함. 밀리초와 나노초...???? 
//		엑셀처럼 프로그램이 얼마동안 실행됬는지 같은 수치를 계산할때 사용됨.
//		System.out.println(System.currentTimeMillis());
//		System.out.println(System.nanoTime());
//		코드를 실행하는 순간의 시간을 받아오는듯. time1 과 time2 사이에는 for 를 실행한만큼의 차이가 있다.
		long time1 = System.nanoTime();
		long sum = 0;
		for (int i = 0; i < 99999; i++) {
			sum += i;
		}
		long time2 = System.nanoTime();
		System.out.println("add : " + sum + " / Time : " + (time2 - time1));
		
//		.getProperties(); 시스템의 속성들을 받아오는 메소드. 실행되는 자바의 경로, 버전, 현재 os의 이름, 유저의 국가 등의 정보가 나오네?
//		반환값이 Properties 타입의 객체이기 때문에 변수에 저장할경우 해당 데이터타입으로 생성해야함. import 필요.
//		.keyset(); 해당 객체가 가지고 있는 키값을 추출해오는 메소드. 키값이 뭐지.... 필드명하고는 다른가?
		System.out.println(System.getProperties());
		Properties props = System.getProperties();
		Set keys = props.keySet();
		System.out.println(keys);

//		.getproperty(키값); 위에서 표시하는 정보들중에 원하는 정보의 키값으로 지정해서 받아오는 메소드.
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));		
	}
}
