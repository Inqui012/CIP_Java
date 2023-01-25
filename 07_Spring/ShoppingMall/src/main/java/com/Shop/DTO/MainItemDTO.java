package com.Shop.DTO;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class MainItemDTO {

    private Long id;

    private String itemName;

    private String itemDetail;

    private String imgUrl;

    private Integer price;

//  쿼리DSL 사용시 결과를 현재 객체로 바로 받아올 수 있다. 바로 변환할 수 있다?
//  테이블에서 원하는 컬럼만 뽑아서 조회하고 싶을 때 사ㅛㅇㅇ?
    @QueryProjection
    public MainItemDTO(Long id, String itemNm, String itemDetail, String imgUrl,Integer price){
        this.id = id;
        this.itemName = itemNm;
        this.itemDetail = itemDetail;
        this.imgUrl = imgUrl;
        this.price = price;
    }

}