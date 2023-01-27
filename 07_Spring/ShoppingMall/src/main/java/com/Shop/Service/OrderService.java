package com.Shop.Service;

import java.util.*;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.Shop.DTO.OrderDTO;
import com.Shop.DTO.OrderHistDTO;
import com.Shop.DTO.OrderItemDTO;
import com.Shop.Entity.Item;
import com.Shop.Entity.ItemImg;
import com.Shop.Entity.Member;
import com.Shop.Entity.OrderItem;
import com.Shop.Entity.Orders;
import com.Shop.Repository.ItemImgRepository;
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
	private final ItemImgRepository itemImgRepository;
	
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
	
	@Transactional(readOnly = true)
	public Page<OrderHistDTO> orderList(String email, Pageable pageable) {
		List<Orders> ordersList = orderRepository.findOrders(email, pageable);
		Long countTotal = orderRepository.countOrder(email);
		List<OrderHistDTO> orderHistDTOList = new ArrayList<>();
		for(Orders orders : ordersList) {
			OrderHistDTO orderHist = new OrderHistDTO(orders);
			List<OrderItem> orderItemList = orders.getOrderItems();
			for(OrderItem item : orderItemList) {
				ItemImg itemImg = itemImgRepository.findByItemIdAndRepImgYn(item.getItem().getId(), "Y");
				OrderItemDTO orderItem = new OrderItemDTO(item, itemImg.getImgUrl());
				orderHist.addOrderItemDto(orderItem);
			}
			orderHistDTOList.add(orderHist);			
		}
		return new PageImpl<OrderHistDTO>(orderHistDTOList, pageable, countTotal);
	}
	
//	현재 사용자와 주문자가 같은 인물인지 확인
	@Transactional(readOnly = true)
	public boolean validateOrder(Long orderId, String email) {
		Member curMember = memberRepository.findByEmail(email);
		Orders curOrder = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
		if(!StringUtils.equals(curMember.getEmail(), curOrder.getMember().getEmail())) {
			return false;			
		}
		return true;
	}
	
//	주문 취소
	public void canceling(Long orderId, String email) {
		Orders order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
		order.cancleOrder();
	}
	
//	주문 삭제
	public void deleting(Long orderId) {
//		엔티티에 관계성을 설정해놓았기 때문에 Orders 항목을 삭제하면 동시에 포함하던 OrderItem 테이블도 삭제가 진행된다.
		orderRepository.deleteById(orderId);
//		아래 코드랑 동일한 일을 하는것 같은데. 한줄로 끝낼 수 있네.
//		Orders order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
//		orderRepository.delete(order);
	}
}
