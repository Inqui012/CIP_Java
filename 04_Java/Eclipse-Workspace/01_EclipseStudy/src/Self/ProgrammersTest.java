package Self;


import java.util.Arrays;
import java.util.Collections;

public class ProgrammersTest {

	public static void main(String[] args) {

		String my_string = "abCdEfghIJ";
		String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) >= 'a' && my_string.charAt(i) <= 'z') {
            	answer += Character.toString(my_string.charAt(i)).toUpperCase();
            } else {
            	answer += Character.toString(my_string.charAt(i)).toLowerCase();          	
            }
        }
        System.out.println(answer);
		
//		  String my_string = "p2o4i8gj2";
//        my_string = my_string.replaceAll("[a-z]","");
//        int[] answer = new int[my_string.length()];
//        for(int i = 0; i < answer.length; i++){
//            answer[i] = Character.getNumericValue(my_string.charAt(i));
//        }
//        Arrays.sort(answer);
        

//		String my_string = "aAb1B2cC34oOp";
//		int answer = 0;
//		my_string = my_string.replaceAll("[a-z,A-Z]", "");
//		for(int i = 0; i < my_string.length(); i++) {
//			answer += Character.getNumericValue(my_string.charAt(i));
//		}
		
		//		int n = 100;
//		loop01 : for(int i = 1; i <= n; i++) {
//			for(int j = n; j > 0; j--) {
//				if(i == j) {
//					break loop01;
//				}
//				if(i * j == n) {
//					answer++;
//				}
//			}
//		}
		
//		int n = 15;
//		int[] answer;
//		
//        if(n % 2 != 0){
//            answer = new int[(n / 2) + 1];
//        } else {
//            answer = new int[(n / 2)];
//        }
//        for(int j = 0; j < answer.length; j++) {
//        	첫번째 인덱스 = 첫번째 홀수 니까 같은 for문안에서 해결할 수 있네
//        	answer[j] = 2 * (j + 1) - 1;
//        }
		
		//		int[] array = { 1, 2, 3, 3, 3, 4};
//		int answer = 0;
//		int maxNum = 0;
//		int maxIdx = 0;
//		Arrays.sort(array);
//		int[] count = new int[array[array.length - 1] + 1];
//		for (int i = 0; i < array.length; i++) {
//			count[array[i]]++;
//		}
//		for (int i = 0; i < count.length; i++) {
//			if (maxNum < count[i]) {
//				maxNum = count[i];
//				maxIdx = i;
//			}
//		}
//		answer = maxIdx;
//		loop01: for (int i = 0; i < count.length; i++) {
//			for (int j = 0; j < count.length; j++) {
//				if (count[i] == count[j] && i != j) {
//					answer = -1;
//					break loop01;
//				}
//			}
//		}
//		
//		for(int i = 0; i < count.length; i++) {
//		}

//		int[] array = {-1, -9, 0, 1, 7};
//        Arrays.sort(array);
//        for(int i = 0; i < array.length; i++) {
//        	System.out.println(array[i]);
//        }

//		int k = 5;
//		int[] numbers = {1, 2, 3, 4, 5, 6};
//        int num = 2 * k - 1;
//        while(num > numbers.length){
//            num = num % numbers.length;
//            System.out.println(num);
//        }

//		String my_string = "hello";
//		String answer = "";
//        for(int i = 0; i < my_string.length(); i++){
//        	for(int j = 0; j < 3; j++) {
//        		answer += my_string.charAt(i);    		
//        	}
//        }

//		Arrays.sort(배열, 시작할 인덱스, 끝낼 인덱스, 정렬조건); 기능으로 배열을 간단하게 크기순으로 정렬할 수 있음. 기존배열을 다시 덮어씌우는 형식
//		배열만 넣으면 기본값인 오름차순으로 정렬하고, 내림차순으로 하고 싶을경우 정렬조건에 Collections.reverseOrder(); 를 넣네
//		  int[] sides = {30, 30, 30};
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
