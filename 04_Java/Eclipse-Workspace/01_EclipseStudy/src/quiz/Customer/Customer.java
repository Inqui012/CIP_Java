package quiz.Customer;

public class Customer {
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
//	아이디와 이름 값 없이 생성할때.
	public Customer() {
		initCustomer();
	}
	
	public Customer(int customerId, String customerName) {
		this.customerID = customerId;
		this.customerName = customerName;
		initCustomer();
	}
	
	private void initCustomer() {
		this.customerGrade = "Silver";
		this.bonusRatio = 0.01;
	}
	
//	값계산하면서 보너스포인트까지 한꺼번에 하네.
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName + "님의 등급: " + customerGrade + ", 보너스 포인트: " + bonusPoint + "점";
	}
	
//	getter, setter
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	
	
}
