package com.Shop.Repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.Shop.Constant.ItemSellStatus;
import com.Shop.DTO.ItemSearchDTO;
import com.Shop.Entity.Item;
import com.Shop.Entity.QItem;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ItemCustomRepositoryImpl implements ItemCustomRepository {
	
	private JPAQueryFactory queryFactory;
	
//	생성자를 사용한 의존성 주입
	public ItemCustomRepositoryImpl (EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

//	동적으로 쿼리를 만들때 사용하는 객체타입? 일반적으로는 BooleanBuilder 를 사용하지만 가독성이 떨어진다는 이유로 이쪽을 쓴다.
//	이 객체의 특징은 null 을 반환할경우 이 값을 받은 queryFactory 에서는 해당 조건절을 아예 제거한다.
//	where() 에서 직접 쓰지 않고 이 객체를 쓰는이유는 조건에 null 이 발생할경우를 대비해서인듯.
	private BooleanExpression regDtsAfter(String searchDateType) {
		LocalDateTime dateTime = LocalDateTime.now();
		if(StringUtils.equals(searchDateType, "all") || searchDateType == null) return null;
		if(StringUtils.equals(searchDateType, "1d")) dateTime = dateTime.minusDays(1); 
		if(StringUtils.equals(searchDateType, "1w")) dateTime = dateTime.minusWeeks(1); 
		if(StringUtils.equals(searchDateType, "1m")) dateTime = dateTime.minusMonths(1); 
		if(StringUtils.equals(searchDateType, "6m")) dateTime = dateTime.minusMonths(6);
		return QItem.item.regTime.after(dateTime);
	}
	
	private BooleanExpression sellStatus(ItemSellStatus sellStatus) {
		return sellStatus == null ? null : QItem.item.itemSellStatus.eq(sellStatus);
	}
	
	private BooleanExpression searchBy(String searchBy, String searchQuery) {
		String qry = "%" + searchQuery + "%";
		if(StringUtils.equals(searchBy, "itemName")) return QItem.item.itemName.like(qry);
		if(StringUtils.equals(searchBy, "createBy")) return QItem.item.createBy.like(qry);
		return null;
	}
	
	@Override
	public Page<Item> getAdminItemPage(ItemSearchDTO itemSearchDTO, Pageable pageable) {
		List<Item> content = queryFactory.selectFrom(QItem.item)
										 .where(regDtsAfter(itemSearchDTO.getSearchDateType()), 
												sellStatus(itemSearchDTO.getSearchSellStatus()),
												searchBy(itemSearchDTO.getSearchBy(), itemSearchDTO.getSearchQuery()))
										 .orderBy(QItem.item.id.desc())
//										 데이터를 가져올 시작번호와 최대갯수 지정으로 페이징을 한다.
										 .offset(pageable.getOffset())
										 .limit(pageable.getPageSize())
										 .fetch();
//		지정한 검색조건으로 찾아낸 총 리스트의 갯수.
		long total = queryFactory.selectFrom(QItem.item)
				 				 .where(regDtsAfter(itemSearchDTO.getSearchDateType()), 
				 						sellStatus(itemSearchDTO.getSearchSellStatus()),
				 						searchBy(itemSearchDTO.getSearchBy(), itemSearchDTO.getSearchQuery()))
				 				 .fetch().size();
//		페이지에 관련된 정보를 처리하는 spring data 의 객체.
//		Page 인터페이스를 상속받고 있는 객체인데, 알아서.......이것저것 처리를....해준다...........
//		total 값은 페이징 없이 그냥 모든 리스트의 크기를 넣어줘야 앞단에서 제대로 페이지네이션이 된다.
		return new PageImpl<>(content, pageable, total);
	}

}
