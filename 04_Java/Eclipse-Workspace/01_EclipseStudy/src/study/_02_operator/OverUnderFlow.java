package study._02_operator;

public class OverUnderFlow {

	public static void main(String[] args) {
		byte var01 = 125;
		for (int i = 0; i < 5; i++) {
			var01++;
//			양수 128까지 밖에 표현할 수 없은 byte가 값을 넘어갈경우 최댓값을 넘어간 후에는 최솟값 -128으로 돌아간다.
//			숫자가 범위안에서 루프한다고 생각하면 편하려나. byte = -128 ~ 127
//			양수 최댓값을 넘어서 음수 최솟값으로 가는경우를 오버플로우
//			음수 최솟값을 넘어서 양수 최댓값으로 가는경우를 언더플로우
			System.out.println((i + 1) + "번째 Var01 : " + var01);
		}
	}

}
