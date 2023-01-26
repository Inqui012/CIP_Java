package com.Shop.Service;

import java.util.*;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Shop.DTO.OrderDTO;
import com.Shop.Entity.Item;
import com.Shop.Entity.Member;
import com.Shop.Entity.OrderItem;
import com.Shop.Entity.Orders;
import com.Shop.Repository.ItemRepository;
import com.Shop.Repository.MemberRepository;
import com.Shop.Repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
	private final ItemRepository itemRepository;
	private final MemberRepository memberRepository;
	private final OrderRepository orderRepository;
	
	public Long order(OrderDTO orderDTO, String email) {
//		주문한 아이템과 주문자의 정보를 가져온다.
		Item item = itemRepository.findById(orderDTO.getItemId()).orElseThrow(EntityNotFoundException::new);
		Member member = memberRepository.findByEmail(email);
//		주문함 아이템을 리스트에 더한다.... 아이템 하나인데 왜 굳이 리스트를 쓸까...?
		List<OrderItem> orderItemList = new ArrayList<>();
		OrderItem orderItem = OrderItem.createOrderItem(item, orderDTO.getCount());
		orderItemList.add(orderItem);
//		위으 정보를 토대로 주문객체를 생성하고 1차저장.
		Orders orders = Orders.createOrder(member, orderItemList);
		orderRepository.save(orders);
		return orders.getId();
	}
}
