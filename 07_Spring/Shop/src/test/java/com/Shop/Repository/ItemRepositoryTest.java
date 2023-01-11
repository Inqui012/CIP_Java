package com.Shop.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import com.Shop.Constant.ItemSellStatus;
import com.Shop.Entity.Item;
import com.Shop.Entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;


// 테스트용으로 사용할 클래스를 선언.
@SpringBootTest
// 테스트용 프로퍼티 파일을 따로 설정하겠다는 선언. classpath는 src/main 루트인...듯?
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

//	의존성주입. @Autowired 는 알아서 해당 클래스의 인스턴스를 생성하여 변수에 대입해준다.
	@Autowired
	ItemRepository itemRepository;
	
//	QueryDsl은 사용하기 위해서 영속성 컨텍스트를 가져와야한다.
//	아래 어노테이션으로 영속성 컨텍스트의 사용을 선언한다.
	@PersistenceContext
	EntityManager em;
	
//	지정된 메소드를 테스트하겠다는 선언.
//	@Test
//	콘솔에 표시되는 이름지정?
//	@DisplayName("저장")
	public void createItemTest() {
		for(int i = 0; i < 10; i++) {
			Item item = new Item();
			item.setItemName("Test Product" + i);
			item.setPrice(8800 + i);
			item.setItemDetail("The cake is fake" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(109);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			
//		JpaRepository 에서 상속받은 메소드 .save()로 Insert를 실행한다.
			Item savedItem = itemRepository.save(item);
//		System.out.println(savedItem.toString());			
		}
	}
	
//	@Test
//	@DisplayName("select test")
//	public void findByItemNameTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemName("Test Product4");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//		itemList = itemRepository.findByPriceGreaterThan(8805);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//		itemList = itemRepository.findByItemNameOrItemDetail("Test Product3", "The cake is fake9");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("Jpql")
//	public void findByItemDeail() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDeail("fake5");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("Jpql native")
//	public void findByItemDeailNative() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDeailNative("fake8");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
	public void createItemTest02() {
		for(int i = 1; i <= 10; i++) {
			Item item = new Item();
			item.setItemName("Test Product" + i);
			item.setPrice(8800 + i);
			item.setItemDetail("The cake is fake" + i);
			if(i < 5) {
				item.setItemSellStatus(ItemSellStatus.SELL);	
				item.setStockNumber(100 + i);
			} else if(i < 8) {
				item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
				item.setStockNumber(0);
			} else {
				item.setItemSellStatus(null);
			}
			item.setRegTime(LocalDateTime.now());
			itemRepository.save(item);
		}
	}
	
	@Test
	@DisplayName("QueryDsl test")
	public void queryDslTest() {
		this.createItemTest();
//		쿼리를 동적으로 생성하기 위한 객체.
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;
//		Dsl을 사용해서 DB의 쿼리문을 메소드 체이닝 형식으로 사용할 수 있다.
		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemSellStatus.eq(ItemSellStatus.SELL)).orderBy(qItem.price.desc());
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}

//	.findAll 과 builder의 동시사용불가? 로 다시작성.
//	@Test
//	@DisplayName("QueryDsl paging")
//	public void queryDslTest2() {
//		this.createItemTest02();
////		쿼리문에 들어갈 조건을 생성해주는 빌더 클래스.
////		where 절에 사용할 조건들을 알아서 생성해주는?
////		import 잘못되는 경우가 있으니 확인필요. queryDsl 에서 가져와야함
//		BooleanBuilder b = new BooleanBuilder();
//		QItem qItem = QItem.item;
//		String itemDetail = "fake";
//		Integer price = 10004;
//		String itemSellStatus = "SELL";
//		
////		.and 함수로 안에 조건들을 쌓아놓을 수 있다. 중첩하여 여러 조건을 계속 작성가능.
//		b.and(qItem.itemDetail.like("%" + itemDetail + "%"));
//		b.and(qItem.price.gt(price));
//		
////		thymeleaf 에서 제공하는 문자열 비교함수?
//		if(StringUtils.equals(itemSellStatus, ItemSellStatus.SELL)) {
//			b.and(qItem.itemSellStatus.eq(ItemSellStatus.SELL));
//		}
//		
////		Spring Data에서 제공하는 객체임. 임포트 주의.
////		PageRequest.of(조회할 페이지번호, 조회할 데이터 갯수); 
////		가져온 총 데이터를 조회할 데이터 갯수만큼으로 나눠서 게시판형식으로 만들어낸다고 함. 만약 위의 쿼리의 결과문이 20행이라면
////		아래 설정대로 5개씩으로 나눠진 페이지의 0번째 페이지를 가져오는것. 즉 1-5 의 데이터만을 가져옴.
//		Pageable page = PageRequest.of(0, 5);		
////		리포지토리.findAll(); JPA에서 제공하여 상속받아 사용할 수 있는 메소드.
////		
////		Page<Item> itemPageResult = itemRepository.findAll(b, page);
//	}
	
	@Test
	@DisplayName("QueryDsl test02")
	public void queryDslTest02() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;
		Pageable page = PageRequest.of(1, 2);
		JPAQuery<Item> query = qf.selectFrom(qItem)
								 .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
								 .where(qItem.itemDetail.like("%fake%"))
								 .where(qItem.price.gt(8802))
//								 페이지의 오프셋? 검색필요
//								 데이터를 어디서부터 가져올것인지 설정하는 메소드...인것 같음.
//								 offset 과 limit를 조합해서 어디서부터 몇개를 가져오는지를 설정해서 페이징하는듯?
								 .offset(page.getOffset())
//								 가져오는 컬럼갯수를 페이지의 사이즈에 맞추어서 가져온다.
								 .limit(page.getPageSize());
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.err.println(item.toString());
		}
	}
}
