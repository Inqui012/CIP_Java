package com.Shop.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.Shop.Constant.ItemSellStatus;
import com.Shop.Entity.Item;

// 테스트용으로 사용할 클래스를 선언.
@SpringBootTest
// 테스트용 프로퍼티 파일을 따로 설정하겠다는 선언. classpath는 src/main 루트인...듯?
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

//	의존성주입. @Autowired 는 알아서 해당 클래스의 인스턴스를 생성하여 변수에 대입해준다.
	@Autowired
	ItemRepository itemRepository;
	
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
	
	@Test
	@DisplayName("select test")
	public void findByItemNameTest() {
		this.createItemTest();
		List<Item> itemList = itemRepository.findByItemName("Test Product4");
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
		itemList = itemRepository.findByPriceGreaterThan(8805);
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
		itemList = itemRepository.findByItemNameOrItemDetail("Test Product3", "The cake is fake9");
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
}
