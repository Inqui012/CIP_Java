package study._01_variableType;

public class Acc {

	public static void main(String[] args) {
		int apple = 1;
		double pieceUnit = 0.1;
		float var01 = 0.2f;
		int number = 7;
		double result = apple - number * pieceUnit;
		
//		자바에서 정확한 계산을 하고싶을경우에는 항상 정수를 이용해야한다.
//		더블로 계산할경우 오차가 발생하네. float는 괜찮은데 왤까.
		System.out.println(number * pieceUnit);
		System.out.println(result);
		System.out.println(number * var01);

//		위와 같은 오차를 없애려면 계산은 반드시 정수형으로 할 수 있도록 만든다.
		int banana = 1;
		int totalPiece = banana *10;
		int num01 = 7;
		int result01 = totalPiece - num01;
		System.out.println(result01);

//		정수 0으로 나눈다고 할 경우 값이 무한대가 되어서 에러가 난다.
//		실수형인 double로 계산할경우 infinity 로 뜨면서 오류는 없지만 계산자체는 불가능하다.
//		나누기일경우 infinity, 나머지 계산일경우 NaN 이 뜸.
		int num02 = 5;
//		int num03 = 0;
		double num04 = 0.0;
		double result02 = num02 / num04;
		double result03 = num02 % num04;
		System.out.println(result02);
		System.out.println(result03);
		
//		Double.isInfinite(변수); 더블형의 값이 무한대인지 판단.
//		Double.isNaN(변수); 더블형의 값이 숫자인지 아닌지 판단.
		if(Double.isInfinite(result02) || Double.isNaN(result02)) {
			System.out.println("값 산출 불가");
		} else {
			System.out.println("계산");
		}
		
	}

}
