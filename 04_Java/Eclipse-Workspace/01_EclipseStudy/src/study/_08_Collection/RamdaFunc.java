package study._08_Collection;

interface RamdaTest {
	double calc(double x, double y);
}
class ClassTest {
	public void ram(RamdaTest test) {
		double result = test.calc(10, 4);
		System.out.println(result);
	}
}
public class RamdaFunc {
	public static void main(String[] args) {
		ClassTest ramdaTest = new ClassTest();
		ramdaTest.ram((x, y) -> x + y);
	}
}
