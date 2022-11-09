package start.ch01;

public class ConditionalOperator {

	public static void main(String[] args) {
//		삼항연산자. (조건) ? 참 : 거짓;
		int score = 85;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(grade);
	}

}
