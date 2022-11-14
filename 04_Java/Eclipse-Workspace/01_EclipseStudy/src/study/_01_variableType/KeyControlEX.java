package study._01_variableType;

import java.util.Scanner;

public class KeyControlEX {

	public static void main(String[] args) {
//		키보드로 1, 2 를 입력받아서 속도를 증감
//		3 입력시 종료
		Scanner inputKey = new Scanner(System.in);
		boolean run = true;
		int speed = 0;

		while (run) {
			System.out.println("----------");
			System.out.println("1 = 증속 / 2 = 감속 / 3 = 종료");
			System.out.println("----------");
			System.out.println("선택 : ");
			String strNum = inputKey.nextLine();

			if (strNum.equals("1")) {
				speed++;
				System.out.println("현재속도 : " + speed);
			} else if (strNum.equals("2")) {
				speed--;
				System.out.println("현재속도 : " + speed);
			} else if (strNum.equals("3")) {
//				break; 도 가능
				run = false;
				System.out.println("종료");
			} else {
				System.out.println("다시 선택 : ");
				strNum = inputKey.nextLine();
			}
		}		
		inputKey.close(); 
	}

}
