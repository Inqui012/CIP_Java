package com.Shop.DTO;

import javax.validation.constraints.*;

import org.modelmapper.ModelMapper;

import com.Shop.Constant.ItemSellStatus;
import com.Shop.Entity.Item;

import lombok.*;
import java.util.*;

@Getter
@Setter
public class ItemFormDTO {
	
	private Long id;

	@NotBlank(message = "상풍명은 필수 입력 사항입니다.")
	private String itemName;
	
	@NotNull(message = "상품가격은 필수 입력 사항입니다.")
	private int price;
	
	@NotNull(message = "상품재고는 필수 입력 사항입니다.")
	private int stockNumber;
	
	@NotBlank(message = "상품 상세설명은 필수 입력 사항입니다.")
	private String itemDetail;
	
	private ItemSellStatus itemSellStatus;
	
//	상품의 이미지 정보를 저장할 리스트.
	private List<ItemImgDTO> itemImgDTOList = new ArrayList<>();
	
//	상품의 이미지 id 넘버를 저장할 리스트.
//	이미지 수정할 때 id 를 담아두는 용도.
	private List<Long> itemImgIds = new ArrayList<>();
	
	private static ModelMapper modelMapper = new ModelMapper();
	public Item createItem() {
		return modelMapper.map(this, Item.class);
	}
	
	public static ItemFormDTO of(Item item) {
		return modelMapper.map(item, ItemFormDTO.class);
	}
}
