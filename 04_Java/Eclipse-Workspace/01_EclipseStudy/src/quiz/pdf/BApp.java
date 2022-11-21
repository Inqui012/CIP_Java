package quiz.pdf;

import java.util.Scanner;

public class BApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Account[] accList = new Account[100];
		int count = 0;
		boolean flag = true;
		
		while(flag) {
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
				System.out.print("계좌번호		: ");
				String accCreateNum = scan.nextLine();
				System.out.print("계좌주 		: ");
				String accCreateName = scan.nextLine();
				System.out.print("초기입금액 	: ");
				String accInitBalance = scan.nextLine();
				accList[count] = new Account(accCreateNum, accCreateName, Integer.parseInt(accInitBalance));
				count++;
				System.out.println("결과 		: 계좌가 생성되었습니다. ");
				break;
			case "2" : 
				System.out.println("--------");
				System.out.println("계좌목록");
				System.out.println("--------");
				for (int i = 0; i < count; i++) {
					System.out.println(accList[i].accNum + "	" + accList[i].accName + "	" + accList[i].balance);		
				}
				break;
			case "3" : 
				System.out.println("--------");
				System.out.println("예금");
				System.out.println("--------");
				System.out.print("계좌번호		: ");
				String accAddNum = scan.nextLine();
				System.out.print("예금액	 	: ");
				String accAddBalance = scan.nextLine();
				for (int i = 0; i < count; i++) {
					if(accList[i].accNum.equals(accAddNum)) {
						accList[i].balance += Integer.parseInt(accAddBalance);
					} else {
						System.out.println("일치하는 계좌가 없습니다.");						
					}
				}				
				break;
			case "4" : 
				System.out.println("--------");
				System.out.println("출금");
				System.out.println("--------");
				System.out.print("계좌번호		: ");
				String accSubNum = scan.nextLine();
				System.out.print("출금액	 	: ");
				String accSubBalance = scan.nextLine();
				for (int i = 0; i < count; i++) {
					if(accList[i].accNum.equals(accSubNum)) {
						accList[i].balance -= Integer.parseInt(accSubBalance);
					} else {
						System.out.println("일치하는 계좌가 없습니다.");						
					}
				}				
				break;
			case "5" : 
				System.out.println("프로그램 종료");
				flag = false;
				break;
			default :
				break;
				
			}
		}
	}

}
