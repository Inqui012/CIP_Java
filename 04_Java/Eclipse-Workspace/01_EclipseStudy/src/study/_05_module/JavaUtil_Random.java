package study._05_module;

// 유틸의 랜덤객체는 임포트 필요
import java.util.Random;

public class JavaUtil_Random {
	public static void main(String[] args) {
//		생성할때 생성자에 매개변수로 long 타입의 초기 seed 값을 넣어줄 수 있다.
//		하지만 이렇게 하면 같은 seed 를 가진 난수는 항상 같은 값을 반환하는듯.
//		매개변수 없을경우 기본값은 시스템의 nanotime 으로 계산.
		Random test01 = new Random();
		
//		.nextInt(); 랜덤객체로 생성된 난수를 int 형으로 뽑아오는 메소드. 메소드니까 호출할 때 마다 난수를 생성.
//		매개변수자리에는 범위를 지정할 수 있는데 0 부터 지정한 숫지 미만까지를 범위로 잡는다.
		for(int i = 0; i < 5; i++) {
			System.out.print(test01.nextInt(10) + ", ");		
		}
		System.out.println("");
		System.out.println("-------------");
		
//		.nextDouble(); 난수를 double 형으로 반환받는 메소드. 범위지정 불가능한듯.
//		.nextFloat();, nextLong(); nextBoolean(); 도 존재하고 마찬가지로 범위지정은 불가능.
//		.nextBytes(byte타입의 배열); 난수를 생성해서 지정한 배열에 집어넣는다?
//		위는 전부 균등분포
		for(int i = 0; i < 5; i++) {
			System.out.print(test01.nextDouble() + ", ");		
		}
		System.out.println("");
		System.out.println("-------------");
		
//		.nextGaussian(); 이 있는데 이건 정규분포로 난수를 생성한대.
//		정규분포라는건 평균과 표준편차를 사용하게 되는 것 같은데... 느낌상으로는 평균치에 가까운 숫자가 생성될 확률이 높은?
//		아무런 지정도 없을경우 기본은 평균 0, 표준편차 1 인 랜덤한 값을 반환. double 형인듯? 실수네.
		for(int i = 0; i < 5; i++) {
			System.out.print(test01.nextGaussian() + ", ");		
		}
		System.out.println("");
		System.out.println("-------------");
		
//		만약 정규분포에서 평균값을 지정하고 싶다면 + 로 지정할 값을 더해주면 되는듯.
//		표준편차는 값과 값 사이의 거리...? 기본 1.0(근사) 값이라는데 그럼 실수가 안나오지 않...나....?
//		만약 이렇게 해서 짝수만 뽑고싶다면 그냥 if 문 쓰는걸까
		for(int i = 0; i < 5; i++) {
			System.out.print(10 + test01.nextGaussian() + ", ");		
		}
		System.out.println("");
		System.out.println("-------------");

//		.setSeed(); 매개변수로 long 타입의 수치를 지정하고 해당 수치로 Random 객체의 seed 값을 지정해서 사용한다.
//		이렇게 하면 같은 seed 를 가지는 모든 난수는 같은 값을 반환함.
		for(int i = 0; i < 5; i++) {
			test01.setSeed(100);
			System.out.print(10 + test01.nextInt() + ", ");		
		}
		System.out.println("");
		System.out.println("-------------");

//		이외에도 .ints(); .longs(); ... 같이 지정하지 않으면 거의 무한에 가까운 난수를 가지는 Stream 형태의 데이터도 만드는 것 같은데
//		Stream 은 어떻게 출력하는지 모르겠네. 매개변수로 넣을 수 있는 값은 스트림의 길이, 범위의 시작, 끝 값인듯.		
		
	}
}
