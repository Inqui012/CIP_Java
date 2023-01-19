package com.Shop.DTO;

import org.modelmapper.ModelMapper;

import com.Shop.Entity.ItemImg;

import lombok.*;

@Getter
@Setter
public class ItemImgDTO {
	private Long id;
	private String imgName;
	private String oriImgName;
	private String imgUrl;
	private String repImgYn;
	
//	DTO <-> 엔티티 변환을 위한 필드와 메소드
	private static ModelMapper modelMapper = new ModelMapper();
	public static ItemImgDTO of (ItemImg  itemImg) {
//		현재 DTO 와 매개변수로 받아오는 ItemImg 엔티티사이에서의 변환을 해주는 기능인듯.
		return modelMapper.map(itemImg, ItemImgDTO.class);		
	}
}
