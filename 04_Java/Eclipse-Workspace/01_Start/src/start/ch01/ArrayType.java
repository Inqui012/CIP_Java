package start.ch01;

import java.util.Arrays;

public class ArrayType {

	public static void main(String[] args) {
//		자바에서의 배열선언 방법은 세가지. 배열도 하나의 객체라서 객체 선언식으로 만들수도 있다.
//		배열임을 표시하는 [] 는 데이터타입 뒤거나 변수명 뒤에 선언한다.
		String intArr01[] = {"Spring", "Summer", "Fall", "Winter"};
//		아래는 배열객체를 생성하면서 배열의 '길이'만을 지정한 형태인데 데이터타입이 int라서 초기값인 0으로 모든 인덱스를 채우는듯?
		int intArr02[] = new int[3];
		int intArr03[] = new int[] {4, 5, 6};
		
//		배열은 그냥 출력하면 아마... 메모리 주소가 출력된느거 같음.
//		배열을 한꺼번에 출력하려면 Array 유틸을 임포트해서 Arrays.toString(배열) 로 문자열로 변형해야하는것같네
		System.out.println(intArr01);
		System.out.println(intArr01[0]);
		System.out.println(Arrays.toString(intArr01));

//		인덱스번호를 지정해서 값을 바꾸는것도 가능.
		intArr01[2] = "Change";
		System.out.println(intArr01[2]);
		System.out.println(Arrays.toString(intArr01));
		System.out.println(Arrays.toString(intArr02));
		System.out.println(Arrays.toString(intArr03));
		
		int arr03sum = 0;
		for (int i = 0; i < intArr03.length; i++) {
			arr03sum += intArr03[i];
		}
		double arr03avg = (double) arr03sum / intArr03.length;
		System.out.println("총합 : " + arr03sum + " / 평균 : " + arr03avg);
	}

}
