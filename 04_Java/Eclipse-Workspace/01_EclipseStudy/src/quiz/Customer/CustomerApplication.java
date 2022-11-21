package quiz.Customer;

import java.util.ArrayList;

// 클래스다이어그램 읽기. Customer문제 ppt 참조.
// 다이어그램 형식으로 클래스명, 필드와 메소드의 접근제어, 데이터타입, 필드명, 메소드명, 매개변수, 상속여부 등을 표시한 형식.
// <<Create>> = 생성자, 밑줄 = static, + = public, - = private, # = protected, ~ = default
// 다중성표기? 1 = 오로지 1만. 1..* = 1또는 그 이상. 1,2,5 = 1 or 2or 5;
// .. 랑 , 는 or(또는) 의 의미인것 같고 *는 전체를 뜻하나. 쉼표는 보통 연속되지 않는 숫자를 표시하고 .. 은 시작과 끝 사이에 있는 모든 숫자에 또는을 붙이는...
// 보통 화살표에 표시해서 몇개의 객체를 가지는지 표시하는듯.

public class CustomerApplication {
//	ArrayList를 Customer 데이터타입으로 생성해서 customerList 라는 변수에 저장.
	public static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public static void main(String[] args) {
		Customer customerLee = new Customer(10010, "이순신");
		Customer customerShin = new Customer(10020, "신사임당");
		Customer customerHong = new GoldCustomer(10030, "홍길동");
		Customer customerYul = new GoldCustomer(10040, "정약용");
		Customer customerKim = new VIPCustomer(10050, "이율곡", 12345);
		
//		리스트의 제일 마지막에 값을 추가함.
		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerHong);
		customerList.add(customerYul);
		customerList.add(customerKim);
		
		showAllCustomer();

		Customer customer = findCustomer(10050); //이율곡
		
		if (customer == null) {
			System.out.println("====== 경고 =======");
			System.out.println("존재하지 않는 회원입니다.");
		} else {			
			showPriceBonus(customer, 10000); //10000: 상품 가격
		}
	}
	
	public static void showAllCustomer() {
		System.out.println("======모든 고객 정보 출력=======");
		
		for( Customer customer : customerList){
			System.out.println(customer.showCustomerInfo());
		}
	}
	
	public static Customer findCustomer(int customerID) {
		Customer Resultcustomer = null;
		for( Customer customer : customerList){
			if (customer.getCustomerID() == customerID) {
				Resultcustomer = customer;				
			}
		}		
		return Resultcustomer;
	}
	
	public static void showPriceBonus(Customer customer, int price) {
		System.out.println("====== 해당 고객의 할인율과 보너스 포인트 계산=======");
		int cost = customer.calcPrice(price);
		System.out.println(customer.getCustomerName() +"님의 지불금액: " + cost + "원");
		System.out.println(customer.getCustomerName() +"님의 현재 보너스 포인트: " + customer.bonusPoint + "점");
	}

}
