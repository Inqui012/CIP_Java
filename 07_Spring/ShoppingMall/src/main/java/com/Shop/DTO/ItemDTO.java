package com.Shop.DTO;

import java.time.LocalDateTime;
import com.Shop.Constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;

// DB작업을 위한 엔티티클래스와는 별개로 뷰단과의 데이터 전달을 목적으로하는 DTO 클래스를 따로 만들어줘야한다.
// 필드 내용은 똑같고 어노테이션의 유무가 좀 다른듯
@Getter
@Setter
public class ItemDTO {
		private Long id;
		private String itemName;
		private int price;
		private int stockNumber;
		private String itemDetail;
		private ItemSellStatus itemSellStatus;
		private LocalDateTime regTime;
		private LocalDateTime updateTime;
}
