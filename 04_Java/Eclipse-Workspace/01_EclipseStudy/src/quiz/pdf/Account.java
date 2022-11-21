package quiz.pdf;


public class Account {
	String accNum;
	String accName;
	int balance;
	protected static String testStr01 = "this is Account's Protected Variable";
	
	public Account(String strNum, String strName, int bal){
		this.accNum = strNum;
		this.accName = strName;
		this.balance = bal;
	}
	
}