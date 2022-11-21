package quiz.Customer;

public class VIPCustomerOther extends Customer {
	private int agentID;
	double saleRatio;
	
	public VIPCustomerOther(int customerId, String customerName, int agentID) {
		super(customerId, customerName);
		super.customerGrade = "VIP";
		super.bonusRatio = 0.03;
		this.agentID = agentID;
		this.saleRatio = 0.2;
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int) (price * saleRatio);
	}

	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo() + ", 담당 상담원 번호:" + agentID;
	}
	 
	public int getAgentID() {
		return agentID;
	}	
}
