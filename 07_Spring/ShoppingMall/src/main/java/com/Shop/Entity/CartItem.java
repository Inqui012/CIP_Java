package com.Shop.Entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cart_item")
public class CartItem {

	@Id
	@Column(name = "cart_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	두개의 FK.
//	자식이 되는 CartItem 은 부모인 Cart, Item 과 다대일 관계를가진다.
	@JoinColumn(name = "cart_id")
//	아래 관계를 나타내는 어노테이션을 작성할때의 기준은 현재 엔티티. CartItem 으로 생각해야한다.
//	장바구니 1 과 여러개의 cartItem, 아이템 1 과 여러개의 cartItem 이기 때문에 여기서는 다대일, ManyToOne을 사용
	@ManyToOne(fetch = FetchType.LAZY)
	private Cart cart;
	
	@JoinColumn(name = "item_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;
	
	private int count;
}
