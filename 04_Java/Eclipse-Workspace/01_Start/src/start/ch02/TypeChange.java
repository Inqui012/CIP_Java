package start.ch02;

public class TypeChange {

	public static void main(String[] args) {
//		UpCating
//		자동 형변환 = 덜 정밀한(byte가 작은) 것을 더 정밀한(byte가 큰) 으로 자동으로 바꿔줌.
//		반대로 더 정밀한 데이터를 덜 정밀한 형태로 바꿀경우에는 수동으로 지정해줘야 한다.
//		예외적으로 byte > char, short > char 자동형변환은 불가능하다. char 는 음수를 표현할 수 없기 때문.
		byte byteVal = 10;
		int intVal01 = byteVal;
		System.out.println(intVal01);
		
		char charVal = 'A';
		intVal01 = charVal;
		System.out.println(intVal01);

//		DownCasting
//		long 에서 int 로의 변환할 경우 (자료형) 으로 변환하고 싶은 자료형을 지정해줘야함. 이를 강제 형변환이라고 한다.
//		덜 정밀한 자료형에서 넘어가는 데이터일경우는 최댓값이 표기...인줄 알았는데 아니네.
//		byte 를 잘라서 가져오는거기 때문에 자료손실이 일어남.
//		아래는 8byte long 을 4byte int로 바꾸면서 4byte 만큼의 데이터가 날아가고 남아있는 4byte 만큼의 숫자를 표시하는것.
		long longVal = 1000000000000000000L;
		int intVal02 = (int) longVal;
		System.out.println(intVal02);
		
//		숫자형을 char 로 변환하면 자동으로 유니코드로 인식.
		int intVal03 = 65;
		char charVal01 = (char) intVal03;
		System.out.println(charVal01);
		
//		연산자를 사용하면 변수를 자동으로 int 형으로 변환한다.
//		때문에 결과값의 형을 int로 지정하거나 강제형변환을 사용해야함.
		byte num01 = 10;
		byte num02 = 20;
		byte result = (byte) (num01 + num02);
		System.out.println(result);
	
//		여러 형태를 연산할때 결과값은 가장 정밀한 자료형으로 설정된다.
//		아래에서의 가장 정밀한 값은 long이기 때문에 결과값을 int로 하면 에러가 발생한다.
		byte num03 = 10;
		int num04 = 100;
		long num05 = 2000L;
		long result01 = num03 + num04 + num05;
		System.out.println(result01);
		
//		연산결과를 int로 바꾸기 때문에 결과값은 유니코드의 연산값이 된다.
//		String을 써도 문자열 합치기는 안되네.
		char char01 = 'a';
		char char02 = 5;
		int result03 = char01 + char02;
		System.out.println((char)result03);
		System.out.println(result03);
		
//		String 끼리의 합산은 되기는 되는듯.
//		java에서 제공하는 메소드로 문자형으로 입력된 숫자를 숫자형으로, 숫자형의 숫자를 문자열로 변환할 수 있다.
		String str01 = "hello";
		String str02 = "9";
		byte result06 = Byte.parseByte(str02);
		int result07 = Integer.parseInt(str02);
		double result08 = Double.parseDouble(str02);
		int num07 = 10;
		String result09 = String.valueOf(num07);
		System.out.println(str01 + str02);
		System.out.println(result06);
		System.out.println(result07);
		System.out.println(result08);
		System.out.println(result09);
		
//		결과값의 형은 똑같이 double이지만 결과04는 2.0 결과05는 2.5를 출력한다.
//		04는 정수형인 변수를 정수형 숫자 4로 나누었기 때문에 결과는 정수형 2를 double 형으로 저장한 형태이고
//		05는 정수형인 변수를 실수형 숫자 4.0으로 나누었기 때문에 더 정밀한 double로 된 2.5값을 저장한다.
		int num06 = 10;
		double result04 = num06 / 4;
		double result05 = num06 / 4.0;
		System.out.println(result04);
		System.out.println(result05);
		
	}

}
