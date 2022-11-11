package start.ch02;

public class CompareOperator {

	public static void main(String[] args) {
		int num01 = 10;
		int num02 = 10;
		boolean result01 = (num01 == num02);
		System.out.println("Result01 : " + result01);
		
//		문자일경우 유니코드 수치를 비교해서 값을 정한다.
		char char01 = 'A';
		char char02 = 'B';
		boolean result02 = (char01 == char02);
		System.out.println("Result02 : " + result02);
		
//		정수와 소수의 비교도 일반적
		int num03 = 1;
		double num04 = 1.0;
		boolean result03 = (num03 == num04);
		System.out.println("Result03 : " + result03);
		
//		float 의 0.1f 와 double의 0.1 다른값으로 인식한다. 데이터타입의 정밀도로 인한 오차?
//		부동소수점 관련한 오차발생인것 같다.
//		double의 값을 강제로 float로 만들어서 비교하면 같은값으로 인식.
		float num05 = 0.1f;
		double num06 = 0.1;
		boolean result04 = (num05 == num06);
		boolean result05 = (num05 == (float) num06);
		System.out.println("Result04 : " + result04);
		System.out.println("Result05 : " + result05);
		
//		문자열 비교는 반드시 .equals() 사용.
		String str01 = "JAVA";
		String str02 = "HELLO";
		boolean result06 = (str01.equals(str02));
		boolean result07 = (!str01.equals(str02));
		System.out.println("Result06 : " + result06);
		System.out.println("Result07 : " + result07);
		
	}

}
