package start.ch01;

public class LogicalOperator {

	public static void main(String[] args) {
//		정수형 변수에 문자열'A'로 유니코드 65를 넣음.
		int charCode = 'A';
		
//		&, && 둘다 기능하는것은 같음.
//		& 일경우 앞의 조건이 flase 여도 뒤의 조건을 연산한다. 자주 안씀.
//		&&일경우 앞의 조건이 false 일경우 뒤의 조건을 연산하지 않는다. 효율적.
		if((65 <= charCode) & (charCode <= 90)) {
			System.out.println("대문자.");
		}
		if((97 <= charCode) && (charCode <= 122)) {
			System.out.println("소문자.");
		}
		if((48 <= charCode) && (charCode <= 57)) {
			System.out.println("숫자.");
		}
		
//		|, || 같은기능. 앞의 값이 true일경우 뒤의 값을 연산하느냐의 여부. 역시 ||를 더 사용함.
		int val01 = 6;
		if ((val01 % 2 == 0) | (val01 % 3 == 0)) {
			System.out.println("2또는 3의 배수");
		}
		if ((val01 % 2 == 0) || (val01 % 3 == 0)) {
			System.out.println("2또는 3의 배수");
		}
		
//		비트논리 연산. 수치를 2진수 비트로 표현한 다음 두 비트사이의 값을 비교하여 결과값을 2진수로 도출한다.
//		C의 데이터타입을 Java로 가져오거나 할때 사용하는듯. 두 언어 사이의 데이터타입 범위가 많이 다르구나.
//		숫자로 해서 헷갈리고 2진수로 생각해야 쉬움.
//		45 = 00101101 / 25 = 00011001
//		& = AND. 두 비트의 수치가 모두 1일경우에만 결과가 1
//		| = OR.  두 비트중 하나만 1이어도 결과는 1
//		^ = XOR. 두 비트중 반드시 한쪽만 1이어야 결과가 1
//		~ = NOT. 비트의 1과 0을 반전. 논리부정.
		System.out.println("45 & 25 = " + (45 & 25));
		System.out.println("45 | 25 = " + (45 | 25));
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45 = " + (~45));

//		비트를 비교하는거면.... 아니네 자동으로 int로 변환해서 계산하기 때문에 4byte 까지 가능한듯.
		System.out.println("128 | 10 = " + (128 | 10));
		
//		받아오는 데이터를 변환하는 예시. 받아온 수치가 byte로 표현할 수 없는 -128일경우
//		자바에서 제공하는 Byte.toUnsignedInt(); 함수를 이용해서 자동으로 비트연산을 통해 수치를 받아온다.
		byte recivedData = -128;
		int unSignedInt = Byte.toUnsignedInt(recivedData);
		System.out.println(unSignedInt);
		
//		비트이동연산자.
//		a << b = a값의 비트를 b만큼 왼쪽으로. 빈자리는 0으로 = a * 2^b 과 같은수.
//		a >> b = a값의 비트를 b만큼 오른쪽으로. 빈자리는 부호비트와 같은값으로 = a / 2^b
//		a >>> b = a값의 비트를 b만큼 오른쪽으로. 빈자리는 0으로
//		1 = 00000001 / 8 = 00001000 / -8 = 11111000
		System.out.println("1 << 3 : " + (1 << 3));
		System.out.println("8 >> 3 : " + (8 >> 3));
		System.out.println("-8 >> 3 : " + (-8 >> 3));
		System.out.println("-8 >>> 3 : " + (-8 >>> 3));

		double area = (double)( (5 + 10) * 7 / 2);
		System.out.println(area);

	}

}
