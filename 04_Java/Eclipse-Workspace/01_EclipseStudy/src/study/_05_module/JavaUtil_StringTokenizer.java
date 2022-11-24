package study._05_module;

import java.util.StringTokenizer;

public class JavaUtil_StringTokenizer {
	public static void main(String[] args) {
		String test01 = "Test String Split? how  testtt";
//		StringTokenizer 객체. 문자열을 매개변수로 줘서 생성하는 방식의 객체.
		StringTokenizer test02 = new StringTokenizer(test01);
//		문자열에서 띄어쓰기를 하나의 토큰이라고 계산하는것 같음. 띄어쓰기 2개 붙어있는것도 두개로 계산하네.
//		설명으로는 .nextToken(); 으로 에러없이 몇번 할 수 있는지의 수치를 띄운다고 하네.
		System.out.println(test02.countTokens());
//		.nextToken(); 은 다음 토큰(띄어쓰기?) 까지 있는 문자들을 잘라내는? 메소드인것 같네.
//		문자열.split(); 과 비슷하긴 한데... 토큰은 띄어쓰기만 지원하나?
		System.out.println(test02.nextToken());
		System.out.println(test02.nextToken());
		System.out.println(test02.nextToken());
		System.out.println(test02.nextToken());
		System.out.println(test02.nextToken());
		System.out.println("--------");
		
		String test03 = "TEst/token/as/slash";
//		오케이. 토커나이저 객체를 생성할때 매개변수의 두번째에 토큰으로 인식할 문자를 지정할 수 있음.
		StringTokenizer test04 = new StringTokenizer(test03, "/");
		System.out.println(test04.countTokens());
//		현재 상태에서 다음 토큰이 존재하는지의 여부를 true/false 로 반환해준다.
//		= .hasMoreElements(); 와 같음;
		System.out.println(test04.hasMoreTokens());
//		다음 토큰 이전까지의 문자열을 출력. 아마 이거 하면서 지금 찍은 토큰이 어디 위치인지를 계속 기억하고 있는 것 같아.
//		= .nextToken(); 인데 이건 반환타입이 문자열이 아니라 object 객체타입.
		System.out.println(test04.nextElement());
		System.out.println(test04.nextElement());
		System.out.println(test04.nextElement());
		System.out.println(test04.nextElement());
//		현재 상태에서의 토큰 여부니까 위에서 다음 토큰으로 네번 넘어갔으니 다음 토큰이 존재하지 않음. 여기서 false 찍음.
		System.out.println(test04.hasMoreTokens());
//		토큰의 수랑 next 메소드랑 연동되는듯. 여기서 토큰의 갯수를 뽑으면 0 을 찍네. 문자열을 점점 잘라가는것과 같은가?
		System.out.println(test04.countTokens());
//		문자열로 다시 변환하면 객체주소 찍네....
		String test05 = test04.toString();
		System.out.println(test05);
		
	}
}
