package com.Shop.Entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "item_img")
public class ItemImg extends BaseEntity {
	@Id
	@Column(name = "item_img_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name = "item_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;
	
	private String imgName;
	private String oriImgName;
	private String imgUrl;
	private String repImgYn;
	
//	원본이미지의 파일명과 업데이트할 이미지의 파일명 / 경로를 파라메터로 이미지 정보를 업데이트하는 메소드.
	public void updateItemImg(String oriImgName, String imgName, String imgUrl) {
		this.oriImgName = oriImgName;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}
}
