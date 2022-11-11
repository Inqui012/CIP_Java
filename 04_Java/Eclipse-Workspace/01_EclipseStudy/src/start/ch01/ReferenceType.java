package start.ch01;

import java.util.Arrays;

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
//		primitive 의 비교와 같이 변수안의 값을 비교하는 개념은 똑같지만 reference는 1차적으로 들어있는 값이 
//		'메모리 주소'이고 이걸 거슬러 올라가서 heap 영역의 값까지 찾아가지 않기 때문에 의도하는 값비교가 안되는 개념같음.
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
		
		int arr01[];
		int arr02[];
		int arr03[];
		
		arr01 = new int[] {1, 2, 3};
		arr02 = new int[] {1, 2, 3};
		arr03 = arr02;
		
//		arr01 과 arr02 는 값이 같고 형태도 같은 배열이지만 찍히는바와 같이 참조하는 메모리가 다르다. 각각 다른 객체로 생성되어있다는 의미.
//		arr03 은 arr02 를 참조하고 있기 때문에 두 배열이 참조하는 메모리주소는 결과적으로 같다.
		System.out.println(arr01);
		System.out.println(arr02);
		System.out.println(arr03);
		
//		null 값을 가지고 있는 변수는 참조하는 메모리가 존재하지 않기 때문에 값을 넣을수가 없다.
//		int[] testArr = null;
//		testArr[0] = 10;
		
		String strArr01[] = new String[3];
		strArr01[0] = "Java";
		strArr01[1] = "Java";
		strArr01[2] = new String("Java");
		
//		strArr01 이 참조하고 있는 메모리의 0번과 1번 인덱스는 같은 주소를 가지는 String 객체를 가르키고 있지만
//		2번 인덱스는 같은 문자를 가지는 새로운 String 객체를 생성했기 때문에 주소가 다르다
//		그래서 첫줄의 비교는 참이지만 두번째 줄의 비교는 거짓으로 나옴. 값은 같지만 String 객체의 주소가 다름.
		System.out.println(Arrays.toString(strArr01));
		System.out.println(strArr01[0] == strArr01[1]);
		System.out.println(strArr01[0] == strArr01[2]);
		System.out.println(strArr01[0].equals(strArr01[2]));		
		
	}

}
