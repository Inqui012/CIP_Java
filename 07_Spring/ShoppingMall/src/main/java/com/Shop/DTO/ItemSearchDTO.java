package com.Shop.DTO;

import com.Shop.Constant.ItemSellStatus;

import lombok.*;

@Getter
@Setter
public class ItemSearchDTO {
	private String searchDateType;
	private ItemSellStatus searchSellStatus;
	private String searchBy;
	private String searchQuery;
}
