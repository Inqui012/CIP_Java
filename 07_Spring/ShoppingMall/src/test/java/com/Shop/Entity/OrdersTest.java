package com.Shop.Entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.Shop.Constant.ItemSellStatus;
import com.Shop.Repository.ItemRepository;
import com.Shop.Repository.MemberRepository;
import com.Shop.Repository.OrderItemRepository;
import com.Shop.Repository.OrderRepository;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class OrdersTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@PersistenceContext
	EntityManager em;
	
	
	public Item createItemTest() {
		Item item = new Item();
		item.setItemName("Test Product");
		item.setPrice(8800);
		item.setItemDetail("The cake is fake");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setStockNumber(109);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		return item;
	}
	
	@Test
	@DisplayName("CascadeCreateTest")
	public void cascadeTest() {
		Orders orders = new Orders();
		for(int i = 0; i < 3; i++) {
			Item item = this.createItemTest();
			itemRepository.save(item);
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(item);
			orderItem.setCount(10);
			orderItem.setOrderPrice(1000);
			orderItem.setOrders(orders);
			orders.getOrderItems().add(orderItem);
		}
//		.saveAndFlush() = .save() 메소드와 .flush() 메소드를 합친것.
//		실행을 하면 cascade 설정때문에 orders 테이블만을 생성하는게 아니라 해당 테이블에 필요한
//		ordersItem 테이블도 함께 생성하고, 값을 insert 해준다.
		orderRepository.saveAndFlush(orders);
		em.clear();
		
		Orders savedOrders = orderRepository.findById(orders.getId()).orElseThrow(EntityNotFoundException::new);
		assertEquals(3, savedOrders.getOrderItems().size());
	}
	
	@Autowired
	MemberRepository memberRepository;
	public Orders createOrder() {
		Orders orders = new Orders();
		for(int i = 0; i < 3; i++) {
			Item item = this.createItemTest();
			itemRepository.save(item);
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(item);
			orderItem.setCount(10);
			orderItem.setOrderPrice(1000);
			orderItem.setOrders(orders);
			orders.getOrderItems().add(orderItem);
		}
//		상품을 주문할 임의의 고객을 생성
		Member member = new Member();
		memberRepository.save(member);
		
//		주문정보에 위에서 생성한 회원정보를 묶는다.
		orders.setMember(member);
		orderRepository.save(orders);
		
		return orders;
	}
	
	@Test
	@DisplayName("Orphan Delete Test")
	public void orphanRemoveTest() {
		Orders orders = this.createOrder();
//		실행하면 리스트에서 삭제된 orderItem 엔티티를 하나 delete 하는 쿼리문을 실행하는것을 알 수 있다.
		orders.getOrderItems().remove(0);
		em.flush();
		em.clear();
	}
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Test
	@DisplayName("LazyLoad")
	public void lazyLoadingTest() {
		Orders orders = this.createOrder();
		Long orderItemId = orders.getOrderItems().get(0).getId();
		em.flush();
		em.clear();
//		lazy 설정을 해주면 관계성이 있다고 해도 필요한 엔티티만을 선택하여 select 문을 실행하는것을 알 수 있다.
		OrderItem orderItem = orderItemRepository.findById(orderItemId).orElseThrow(EntityNotFoundException::new);
	}
}
