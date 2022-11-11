package start.ch02;

public class Operator {

	public static void main(String[] args) {
		int x = -100;
		int y = 10;
		int z = 10;
		int q;
		x = -x;
		System.out.println(x);
		
		y++;
		++y;
		System.out.println("y = " + y);

		z--;
		--z;
		System.out.println("z = " + z);
		
//		후위연산자. 값을 먼저 대입한 다음에 증감한다.
		q = y++;
		System.out.println("q = " + q);
		System.out.println("y = " + y);
		
//		위에서 13이 된 y는 먼저 14가 된 후 대입되고 8이었던 z를 먼저 대입후 결과값 q=22 가 나온다음 증가하여 9가 된다.
		q = ++y + z++;
		System.out.println("y = " + y);
		System.out.println("z = " + z);
		System.out.println("q = " + q);
		
	}

}
