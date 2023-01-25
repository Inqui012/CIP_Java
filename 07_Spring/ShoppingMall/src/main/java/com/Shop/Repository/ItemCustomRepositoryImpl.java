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
import com.Shop.DTO.MainItemDTO;
import com.Shop.DTO.QMainItemDTO;
import com.Shop.Entity.Item;
import com.Shop.Entity.QItem;
import com.Shop.Entity.QItemImg;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
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
//		처음엔 아래처럼 혼자 해봤었는데 size 로 가져오는건 좋지 않다는것 같다.
//		long total = queryFactory.selectFrom(QItem.item)
//				 .where(regDtsAfter(itemSearchDTO.getSearchDateType()), 
//						sellStatus(itemSearchDTO.getSearchSellStatus()),
//						searchBy(itemSearchDTO.getSearchBy(), itemSearchDTO.getSearchQuery()))
//				 .fetch().size();
//		Wildcard.count 는 sql 의 count(*) 를 의미하는 구문이다.
//		.fetchOne() 은 하나의 결과값만을 허용하는 문법. 리턴되는 튜플이 하나가 아닐경우 오류가 발생한다.
//		count 로 총 갯수를 구하는 구문이니까 튜플은 하나인게 맞으니 이거 쓰는듯.
		long total = queryFactory.select(Wildcard.count).from(QItem.item)
                				 .where(regDtsAfter(itemSearchDTO.getSearchDateType()),
                						sellStatus(itemSearchDTO.getSearchSellStatus()),
                						searchBy(itemSearchDTO.getSearchBy(), itemSearchDTO.getSearchQuery()))
                				 .fetchOne();
//		페이지에 관련된 정보를 처리하는 spring data 의 객체.
//		Page 인터페이스를 상속받고 있는 객체인데, 알아서.......이것저것 처리를....해준다...........
//		total 값은 페이징 없이 그냥 모든 리스트의 크기를 넣어줘야 앞단에서 제대로 페이지네이션이 된다.
		return new PageImpl<>(content, pageable, total);
	}

//	메인페이지용 상품리스트 메소드.
	private BooleanExpression itemNameLike (String searchQuery) {
		return StringUtils.isEmpty(searchQuery) ? null : QItem.item.itemName.like("%" + searchQuery + "%");		
	}
	
	@Override
	public Page<MainItemDTO> getMainItemPage(ItemSearchDTO itemSearchDTO, Pageable pageable) {
		QItem item = QItem.item;
		QItemImg img = QItemImg.itemImg;
//		@QueryProjection 어노테이션을 사용했을경우 쿼리문이 이렇게 변하는듯.
//		사용할 DTO 가 일단 DSL에서 Q클래스로 생성이 되어야 하고, select 구문 안에서 새로은 객체를 생성해 매개변수를 넣어준다.
//		from 은 조인을 사용했는데 여기서는 순서를 잘 봐야하는것 같아. DTO 클래스의 관계를 잘 생각해서 어느쪽이 참조하고 있는지를 생각해야함.
//		참조를가지고 있는 테이블의 필드 와 해당 필드와 일치하는 값을 가지고 있는 테이블을 불러오는식인듯.
//		이렇게 사용할때는 불러올 테이블의 Q클래스를 미리 따로 불러와야 하는가봐.
		List<MainItemDTO> content = queryFactory.select(new QMainItemDTO(item.id, item.itemName, item.itemDetail, img.imgUrl, item.price))
												.from(img).join(img.item, item).where(img.repImgYn.eq("Y"))
												.where(itemNameLike(itemSearchDTO.getSearchQuery()))
												.orderBy(item.id.desc())
												.offset(pageable.getOffset())
												.limit(pageable.getPageSize())
												.fetch();
			long total = queryFactory.select(Wildcard.count)
									 .from(img).join(img.item, item).where(img.repImgYn.eq("Y"))
									 .where(itemNameLike(itemSearchDTO.getSearchQuery()))
									 .fetchOne();
			return new PageImpl<>(content, pageable, total);
	}
	
	

}
