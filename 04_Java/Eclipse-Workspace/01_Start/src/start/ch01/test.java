package start.ch01;

public class test {

	public static void main(String[] args) {
		int prev01 = 1;
		int prev02 = 1;
		int current = 0;
		for (int i = 1; i <= 8; i++) {
			current = prev01 + prev02;
			prev02 = prev01;
			prev01 = current;
			System.out.println(current);
		}
		
	}
}