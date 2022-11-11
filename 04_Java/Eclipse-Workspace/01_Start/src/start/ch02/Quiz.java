package start.ch02;

import java.util.Arrays;

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
		
		
		int ballArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int ball3[] = new int[3];
		for (int i = 0; i < ballArr.length; i++) {
			int j = (int) (Math.random()  * ballArr.length);
			int tmp = 0;
			tmp = ballArr[i];
			ballArr[i] = j;
			
			for (int k = 0; k < ballArr.length; k++) {
				if(ballArr[k] == j && k != i) {
					ballArr[k] = tmp;
				}
			}
		}
		System.arraycopy(ballArr, 0, ball3, 0, ball3.length);
		System.out.println(Arrays.toString(ballArr));
		for (int i = 0; i < ball3.length; i++) {
			System.out.println(ball3[i]);
		}
	}
}