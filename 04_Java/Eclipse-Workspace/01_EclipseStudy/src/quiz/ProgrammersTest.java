package quiz;

public class ProgrammersTest {
//	최대공약수 구하는 유클리드 호제법 알고리즘.
//	으으으으으으으ㅡㅡㅡㅡㅡㅡ
	static int gcd(int a, int b) {
		while (b != 0) {
			int t = a;
			a = b;
			b = t % b;
		}
		return a;
	}
	public static void main(String[] args) {
		
		int denum1 = 500;
		int denum2 = 24;
		int num1 = 95;
		int num2 = 48;
        int[] answer = {0, 0};
        
        answer[0] = (denum1 * num2) + (denum2 * num1);
        answer[1] = (num1 * num2);
        System.out.println(answer[0] + ", " + answer[1]);
        int a = gcd(answer[0], answer[1]);
        System.out.println(a);
        answer[0] /= a;
        answer[1] /= a;        
        
        System.out.println(answer[0] + ", " + answer[1]);
        
	}

}
