package com.Shop.Repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.Shop.DTO.ItemSearchDTO;
import com.Shop.Entity.Item;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ItemCustomRepositoryImpl implements ItemCustomRepository {
	
	private JPAQueryFactory queryFactory;
	
//	생성자를 사용한 의존성 주입
	public ItemCustomRepositoryImpl (EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	private BooleanExpression regDtsAfter(String searchDateType) {
		LocalDateTime dateTime = LocalDateTime.now();
		if(StringUtils.equals(searchDateType, "all") || searchDateType == null) return null;
		if(StringUtils.equals(searchDateType, "1d")) dateTime = dateTime.minusDays(1); 
		if(StringUtils.equals(searchDateType, "1w")) dateTime = dateTime.minusWeeks(1); 
		if(StringUtils.equals(searchDateType, "1m")) dateTime = dateTime.minusMonths(1); 
		if(StringUtils.equals(searchDateType, "6m")) dateTime = dateTime.minusMonths(6);
		return null;
	}
	@Override
	public Page<Item> getAdminItemPage(ItemSearchDTO itemSearchDTO, Pageable pageable) {
		QueryResults<Item> results = queryFactory.selectFrom(QItem.item)
												 .where(itemSearchDTO.getSearchDateType(), 
														itemSearchDTO.getSearchSellStatus(),
														itemSearchDTO.getSearchBy());
												 
												 
		return null;
	}

}
