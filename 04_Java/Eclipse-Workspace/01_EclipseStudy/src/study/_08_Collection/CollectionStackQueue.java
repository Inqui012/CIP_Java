package study._08_Collection;

import java.util.*;

public class CollectionStackQueue {
	public static void main(String[] args) {
//		Stack. 데이터를 차곡차곡 쌓아넣는다는 느낌. 맨 마지막에 넣은 데이터가 맨 처음으로 나오는 LIFO 타입.
		String strTest = "String for Testing.";
		Stack<Character> stkTest = new Stack<>();
		for(int i = 0; i < strTest.length(); i++) {
			stkTest.push(Character.valueOf(strTest.charAt(i)));
		}
		String outputTest = "";
		for(int i = 0; i < strTest.length(); i++) {
//			.pop(); 메소드는 스택에서 자료를 제거하면서 해당 값을 반환해주기 때문에 이걸 for문으로 계속 돌리면
//			넣었던 데이터를 역순으로 뽑아낸다.
			outputTest += stkTest.pop();
		}
		System.out.println(outputTest);
		
	}
}
