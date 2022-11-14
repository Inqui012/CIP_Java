package quiz;


public class Account {
	String accNum;
	String accName;
	int balance;
	
	Account(String strNum, String strName, int bal){
		this.accNum = strNum;
		this.accName = strName;
		this.balance = bal;
		System.out.println("계좌가 생성되었습니다.");
	}
}