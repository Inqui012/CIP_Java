package start.ch01;

public class ReferenceType {

	public static void main(String[] args) {
//		Runtime Data Area = Method Area + Heap Area + Stack
//		Reference Type 참조타입 = 변수에 직접 값을 저장하는것이 아니라 값을 가지고 있는 객체의 주소를 저장한다.
//		ex) String name = "john"; 일 경우 name에는 "john"이라는 값을 가지고 있는 String 객체의 위치정보를 저장.
//		Non-Primitive 타입의 데이터들을 전부 참조타입인가? 그러가보네. 변수는 Primitive 와 Reference로 나뉘는듯.
//		String 함수의 값이 같을경우 같은 객체를 가진다.
		String str01 = "John";
		String str02 = "John";
		String str03 = "Root";		
		
//		아래의 조건식의 경우 String의 값을 비교하는게 아니라 각 변수가 참조하는 메모리 주소를 비교한다.
		if (str01 == str02) {
			System.out.println("str01 Refer same as str02");
		} else {
			System.out.println("str01 not Refer same as str02");
		}
		if (str01 == str03) {
			System.out.println("str01 Refer same as str03");
		} else {
			System.out.println("str01 not Refer same as str03");
		}

//		String 의 값을 비교하기 위해서는 .equals() 를 사용해야한다.
		if (str01.equals(str02)) {
			System.out.println("str01 same as str02");
		} else {
			System.out.println("str01 not same as str02");
		}
		if (str01.equals(str03)) {
			System.out.println("str01 same as str03");
		} else {
			System.out.println("str01 not same as str03");
		}
		
//		String은 객체이기 때문에 아래처럼 새로운 객체로 선언할경우 값이 같아도 다른 주소를 참조하게된다.
		String str04 = new String("Root");
		if (str03 == str04) {
			System.out.println("str03 refer same as str04");
		} else {
			System.out.println("str03 not refer same as str04");
		}
		if (str03.equals(str04)) {
			System.out.println("str03 same as str04");
		} else {
			System.out.println("str03 not same as str04");
		}
	
	}

}
