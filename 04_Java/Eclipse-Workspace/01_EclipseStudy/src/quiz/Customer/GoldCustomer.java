package quiz.Customer;

public class GoldCustomer extends Customer {
	double saleRatio;
	
	public GoldCustomer(int customerId, String customerName) {
		super(customerId, customerName);
		super.bonusRatio = 0.02;
		super.customerGrade = "Gold";
		this.saleRatio = 0.1;
	}
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	}
	
}
