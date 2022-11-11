package start.ch01;

public class MethodActive {

	public static void main(String[] args) {
//		MethodMake 에서 생성한 메소드들을 실행한다
//		클래스 실행하는것하고 똑같이 우선은 객체를 생성해주고 그 다음에 메소드를 실행한다.
		MethodMake met01 = new MethodMake();
		int resultMet01 = met01.add(5, 3);
		double resultMet02 = met01.divide(9, 3);
		int x = 19, y = 3;
		
		System.out.println(resultMet01);
		resultMet01 = met01.add(x, y);
		System.out.println(resultMet01);
		System.out.println(resultMet02);

//		void형으로 리턴값이 없는 메소드를 실행하면 안의 기능만 수행한다
//		받아오는값이 없기 때문에 따로 변수를 정해서 저장하는 과정이 생략되는듯??
		met01.powerOn();
		met01.powerOff();
		
	}

}
