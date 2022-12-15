package _01_Start;

import java.util.*;

// BD를 대신하는 클래스
public class Product_Service {
	Map<String, Product> products = new HashMap<>(); 
	
	Product_Service(){
		Product p = new Product("101", "Computer", "SAMSUNG", 25000000, "2020.02.04");
		products.put("101", p);
		p = new Product("102", "Phone", "Apple", 2000000, "2022.12.25");
		products.put("102", p);
		p = new Product("103", "Machine", "Lg", 29500000, "1994.07.24");
		products.put("103", p);
		p = new Product("104", "Tool", "Hitachi", 1200000, "1975.03.18");
		products.put("104", p);
	}
	
	public List<Product> selectAll(){
		return new ArrayList<>(products.values());
	}
	
	public Product selectOne(String key) {
		return products.get(key);
	}
}
