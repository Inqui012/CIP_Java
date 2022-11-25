package study._05_module;

public class JavaLang_String {
	public static void main(String[] args) {
//		.getBytes(); 지정된 문자열이 가지고있는 문자를 하나씩 ASCII 코드 숫자로 변환해서 Byte 타입의 변수로 저장한다.
//		일반적인 숫자와 영문, 특수문자는 ASCII 코드인데 한글은 마이너스 숫자로 바뀐다.
//		더 정확하게는 문자열(기본 유니코드?)을 utf-8 로 인코딩해준다고 한다.
//		보통 데이터베이스에 인코딩 방법을 지정해놓는데 한글같은 문자를 그대로 저장할경우, 저장 과정에서 글자가 깨지거나 해서
//		데이터가 손상되는 경우가 있기 때문에 이런경우를 방지하기 위해서 사용하는듯. 보통 utf-8이 많지만 다른것도 있다.
		String test01 = "abcdefg012345ABCDE +-/ 자바아아?";
		byte[] getByteArr = test01.getBytes();
		for(int i = 0; i < getByteArr.length; i++) {
//			System.out.println(getByteArr[i]);
		}
		
//		utf-8 로 인코딩된 배열을 다시 문자열로 디코딩. 기본이 utf-8 에서 디코딩하는거라 생략했지만 원래는
//		String(인코딩된 배열, 배열의 인코딩 규칙); 이다.
//		String test02 = new String(getByteArr);
//		System.out.println(test02);
		
//		StringBuilder 문자열에 관련한 클래스. String 객체는 한번 생성되면 내용을 바꿀 수 없다?
//		예를들어 두개의 String을 str1 + str2 이렇게 연산할경우 연산하는 두개의 String과 결과값을 가지는 새로운 String 객체가 생성됨.
//		이걸 반복하게 되면 메모리 관리에 비효율적이기 때문에 그럴경우에는 체이닝을 사용할 수 있는 StringBuilder 를 사용하는듯.
//		.append(새 문자열); 문자열 맨 끝에 새로운 문자열을 붙여넣는다.
//		.insert(넣을 위치의 인덱스, 넣을 문자열); 지정된 위치에 문자열을 끼워넣는다.
//		.delete(삭제 시작위치, 삭제 끝위치 + 1); 지정된 위치의 문자열을 지운다.
		String test03 = new StringBuilder().append("TEST").append(" 12").delete(1, 4).toString();
		System.out.println(test03);
		
	}
}
