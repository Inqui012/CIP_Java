package study._01_variableType;

import java.util.Arrays;

public class ArrayType {

	public static void main(String[] args) {
//		자바에서의 배열선언 방법은 세가지. 배열도 하나의 객체라서 객체 선언식으로 만들수도 있다.
//		배열임을 표시하는 [] 는 데이터타입 뒤거나 변수명 뒤에 선언한다.
		String strArr01[] = {"Spring", "Summer", "Fall", "Winter"};
//		아래는 배열객체를 생성하면서 배열의 '길이'만을 지정한 형태인데 데이터타입이 int라서 초기값인 0으로 모든 인덱스를 채우는듯?
//		맞는것 같다. primitive 일경우 초기값이 들어가고 reference면 null 값인가?
//		int, short, byte = 0 / long = 0L / char = '\u0000' / float = 0.0f / double = 0.0 / boolean = false;
		int intArr02[] = new int[3];
		int intArr03[] = new int[] {4, 5, 6};
		String strArr02[] = new String[3];
		float floArr01[] = new float[3];
		
//		배열은 그냥 출력하면 아마... 메모리 주소가 출력되는거 같음.
//		배열을 한꺼번에 출력하려면 Array 유틸을 임포트해서 Arrays.toString(배열) 로 문자열로 변형해야하는것같네
		System.out.println(strArr01);
		System.out.println(strArr01[0]);
		System.out.println(Arrays.toString(strArr01));

//		인덱스번호를 지정해서 값을 바꾸는것도 가능.
		strArr01[2] = "Change";
		System.out.println(strArr01[2]);
		System.out.println(Arrays.toString(strArr01));
		System.out.println(Arrays.toString(strArr02));
		System.out.println(Arrays.toString(floArr01));
		System.out.println(Arrays.toString(intArr02));
		System.out.println(Arrays.toString(intArr03));
		
		int arr03sum = 0;
		for (int i = 0; i < intArr03.length; i++) {
			arr03sum += intArr03[i];
		}
		double arr03avg = (double) arr03sum / intArr03.length;
		System.out.println("총합 : " + arr03sum + " / 평균 : " + arr03avg);
		
//		다차원배열. 엑셀등의 행열을 생각하면 편한가? 다차원배열의 행길이는 다 똑같지 않을수도 있음.
//		아래의 경우는 1차원배열의 길이는 2 이고 2차원배열의 길이는 5와 3ㄴ이다.
		int multArr01[][] = new int[][] {{1, 2, 3, 4, 5}, {9, 8, 7}};
		System.out.println("1차원 배열 길이 : " + multArr01.length + " / 2차원 길이 : " + multArr01[0].length + ", " + multArr01[1].length);
		System.out.println(Arrays.toString(multArr01[0]));
		System.out.println(Arrays.toString(multArr01[1]));
		
		int totalSum = 0;
		int totalNumSum = 0;
		for (int i = 0; i < multArr01.length; i++) {
			int multArrSum = 0;
			for (int j = 0; j < multArr01[i].length; j++) {
				multArrSum += multArr01[i][j];
			}
			totalSum += multArrSum;
			totalNumSum += multArr01[i].length;
			System.out.println(i + "번 배열 총합 : " + multArrSum + " / 학생수 : " + multArr01[i].length + " / 평균 : " + ((double) multArrSum / multArr01[i].length));
		}
		System.out.println("전체 총합 : " + totalSum + " / 학생수 : " + totalNumSum + " / 평균 : " + ((double) totalSum / totalNumSum));
		
//		자바에서 배열의 길이를 늘이는 방법. 기존 배열과 원하는 길이의 빈 배열을 생성하고 새 배열에 기존 배열값을 넣어준다.
//		배열을 길이로 생성할때는 모든값이 초기값으로 되어있기 때문에 복사한 배열 이외에는 초기값으로 채워진 새로운 길이의 배열이 완성.
//		for문을 이용한 방법 말고 java에서 제공하는 System.arraycopy(복사하고싶은 배열)을 사용.
		int oldIntArr01[] = {1, 2, 3};
		int newIntArr01[] = new int[5];
		int newIntArr02[] = new int[5];
		
		for (int i = 0; i < oldIntArr01.length; i++) {
			newIntArr01[i] = oldIntArr01[i];
		}
//		System.arraycopy(원본배열, 복사를 시작할 인덱스, 새로 저장할 배열, 저장을 시작할 인덱스, 복사할 인덱스 갯수)
		System.arraycopy(oldIntArr01, 0, newIntArr02, 0, oldIntArr01.length);
		System.out.println(Arrays.toString(newIntArr01));
		System.out.println(Arrays.toString(newIntArr02));
		
//		향상된 for 문. js의 rest 로 가져오는 것 같은 느낌인가.
//		for (int 아이템변수명 : 참조할 배열) {}; 배열의 각각의 아이템들을 새로운 변수에 넣어서 for문을 돌린다. 
		int forArr01[] = {95, 75, 15, 85, 35};
		int forSum = 0;
		for (int forArr : forArr01) {
			System.out.println(forArr);
			forSum += forArr;
		}
		System.out.println(forSum);
	}

}
