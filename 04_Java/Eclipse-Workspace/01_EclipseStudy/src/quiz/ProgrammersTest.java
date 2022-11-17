package quiz;

public class ProgrammersTest {
//	최대공약수 구하는 유클리드 호제법 알고리즘.
//	값 a 와 b 가 있고 a > b 일때, a / b = r 일경우. a, b의 공약수는 b, r의 공약수이다???
//	a % b = r, b % r = r2, r % r2 = r3, r2 % r3 = r4..... 로 반복해서 나머지가 0이될때까지.
//	나머지가 0일경우의 값이 최대공약수이다.
	static int gcd(int a, int b) {
//		b 가 0이 아닐때 반복이니까 b는 공식에서 말하는 나머지...가 아닌데. 아니 맞는....데
//		반복문 함수 안에서 b = t % b; 를 반복해서 b값은 계속 바뀌니까, 계산하는 t 를 받아온 매개변수 b 로나눈 나머지가 0 이면
//		b = 0 되서 반복문이 끝난다. 그럼 반복문을 안들어가니 a에는 다음 계산을 위해 미리 넣어둔 전번의 b 가 들어가 있으니
//		결과적으로 최대공약수는 a 가 되는듯.
		while (b != 0) {
//			함수에서 매개변수로 받아오는 a, b로 계산을 계속할거니까 여기서 미리 여분의 변수 t를 설정해서
//			t=a, 로해서 계산은 t로 하고 a값은 다음번 계산에 쓰일 b를 미리 저장해놓음.
			int t = a;
			a = b;
//			b값을 계속 새로운 나머지값으로 대체하면서 나누게됨.
			b = t % b;
		}
		return a;
	}
	
	public static void main(String[] args) {
//		String my_string = "hello";
//		String answer = "";
//        for(int i = 0; i < my_string.length(); i++){
//        	for(int j = 0; j < 3; j++) {
//        		answer += my_string.charAt(i);    		
//        	}
//        }
//        System.out.println(answer);
		
//		int[] sides = {30, 30, 30};
//        int answer = 2;
//        int maxSides = 0;
//        int sum = 0;
//        for(int i = 0; i < sides.length; i++){
//            if(maxSides < sides[i]){
//                maxSides = sides[i];
//            }
//            sum += sides[i];
//        }
//        sum -= maxSides;
//        System.out.println(maxSides);
//        
//        System.out.println(sum);
//        if (maxSides < sum) {
//            answer = 1;
//        }
		
//		String my_string = "abcdef";
//		String letter = "f";
//		String answer = "";
//        for(int i = 0; i < my_string.length() - 1; i++){
////        	if(my_string.charAt(i) == Character.)
//            answer += my_string.charAt(i);       
//        }
		
//		String my_string = "bread";
//		String answer = "";
//		length(); 문자열의 길이를 반환. 배열의 .length 랑은 괄호차이
//		charAt(); 으로 문자열을 배열처럼 인덱스번호에 맞는 문자를 가져온다.
//        for(int i = my_string.length() - 1; i >= 0; i--){
//            answer += my_string.charAt(i);
//        }
		
//		이거 카운트로만 되나??? 포문돌리면 안되는데..흠....
//		int[] num_list = {1, 2, 3, 4, 5};
//		int[] answer = new int [num_list.length];
//		int cnt = 0;
//		
//        for (int i = num_list.length - 1; i >= 0; i--){
//        	answer[cnt] = num_list[i];
//        	cnt++;        	
//        }

//		int denum1 = 500;
//		int denum2 = 24;
//		int num1 = 95;
//		int num2 = 48;
//        int[] answer = {0, 0};
//        
//        answer[0] = (denum1 * num2) + (denum2 * num1);
//        answer[1] = (num1 * num2);
//        int a = gcd(answer[0], answer[1]);
//        answer[0] /= a;
//        answer[1] /= a;        
//        

	}

}
