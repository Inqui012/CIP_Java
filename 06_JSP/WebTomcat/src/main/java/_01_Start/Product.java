package _01_Start;

// BD를 대신하는 Product_Service 에서 데이터를 가져오고 반환할 클래스. DO. Data Objects.
// DO는 오로지 필드와 getter/setter 만을 가진다.
// 실제 데이터베이스를 연동해서 가져오게되면 DB의 컬럼이 필드명으로 들어가는 객체를 DB 행만큼 생성하는 느낌인듯??
public class Product {
	private String id;
	private String name;
	private String maker;
	private int price;
	private String date;
	
	public Product(String id, String name, String maker, int price, String date){
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
