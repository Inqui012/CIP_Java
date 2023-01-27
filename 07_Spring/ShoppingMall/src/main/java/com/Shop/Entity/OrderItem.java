package com.Shop.Entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity {
	@Id
	@Column(name = "order_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name = "order_id")
//	지연로딩.
	@ManyToOne(fetch = FetchType.LAZY)
	private Orders orders;
	
	@JoinColumn(name = "item_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;
	
	private int orderPrice;
	private int count;
	
//	주문할 상품과 수량을 통해 객체생성
	public static OrderItem createOrderItem (Item item, int count) {
		OrderItem orderitem = new OrderItem();
		orderitem.setItem(item);
		orderitem.setCount(count);
		orderitem.setOrderPrice(item.getPrice());
		item.removeStock(count);
		return orderitem;
	}
	
	public int getTotalPrice() {
		return orderPrice * count;
	}
	
	public void cancleItem() {
		this.getItem().restoreStock(count);
	}
}
