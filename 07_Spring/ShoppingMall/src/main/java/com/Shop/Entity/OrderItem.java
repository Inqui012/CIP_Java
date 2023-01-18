package com.Shop.Entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "order_item")
public class OrderItem {
	@Id
	@Column(name = "order_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name = "order_id")
	@ManyToOne
	private Orders orders;
	
	@JoinColumn(name = "item_id")
	@ManyToOne
	private Item item;
	
	private int orderPrice;
	private int count;
}
