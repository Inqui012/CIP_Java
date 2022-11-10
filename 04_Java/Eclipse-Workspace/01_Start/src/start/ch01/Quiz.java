package start.ch01;

public class Quiz {

	public static void main(String[] args) {
//		피보나치 수열 출력
		int prev01 = 0;
		int prev02 = 0;
		int current = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.println(current);
			prev02 = prev01;
			prev01 = current;
			current = prev01 + prev02;
		}
		
	}
}