package quiz;

import java.util.Scanner;

public class BApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("------------------------");
			System.out.println("1.생성 | 2.목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------");
			System.out.print("선택 > ");
			String selecNum = scan.nextLine();
			
			switch (selecNum) {
			case "1" : 
				System.out.println("--------");
				System.out.println("계좌생성");
				System.out.println("--------");
				System.out.print("계좌번호 		: ");
				String accNum = scan.nextLine();
				System.out.print("계좌주 		: ");
				String accName = scan.nextLine();
				System.out.print("초기입금액 	: ");
				String accInitBalance = scan.nextLine();
				Account accList = new Account(accNum, accName, Integer.parseInt(accInitBalance));
				
			default :
				break;
				
			}
		}
	}

}
