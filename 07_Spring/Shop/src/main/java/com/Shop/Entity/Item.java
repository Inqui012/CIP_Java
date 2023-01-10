package com.Shop.Entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;
import com.Shop.Constant.ItemSellStatus;

@Entity
// 생성할 테이블의 이름을 지정할 수 있다. DB와의 매핑기능도 겸함.
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String itemName;
	
	@Column(nullable = false, name = "price")
	private int price;
	
	@Column(nullable = false)
	private int stockNumber;
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	
	private LocalDateTime regTime;
	private LocalDateTime updateTime;
}
