package com.Shop.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.Shop.Constant.OrderStatus;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name = "member_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
//	일대다 관계인 orderItem 을 가져오기 때문에 여러개의 orderItem을 가지기 위해서 리스트 형태를 가진다.
//	양방향 관계를 설정하기 위해 일대다 어노테이션의 속성으로 mappedBy 속성을 이용해 연관관계의 주인을 지정한다.
//	속성에 지정하는 이름은 참조하는 엔티티 OrderItem 에 선언한 필드 orders 를 지정한다.
//	해당 필드가 fk 의 관리를 한다는 의미...같음
//	cascade 는 부모와 자식객체의 persistence context 에 드나드는 방식을 묶어주는 설정.
//	orphanRemoval 고아객체 삭제.
//	고아객체라는건 부모객체와 관계성이 끊어진 자식객체를 뜻하는데 예를들면 orderItems 중에서 하나의 row를 삭제했을때,
//	삭제된 해당 row는 부모인 orders 리스트에서는 사라지는데 객체로서는 존재하니까....이걸 삭제해주는듯?
//	주의할점은 삭제할 객체를 참조하는곳이 오로지 한곳일 경우에만 사용한다는 점이다.
//	만약 다른곳에서 orderItems 의 목록을 다른곳에서도 참조하고 있다면 orders 에서 끊어졌다고 삭제할경우 그쪽에서 문제가 생길 수 있음.
//	cascade 로 인한 delete 는 부모의 상태변화에 따른 설정이기 때문에 부모에게서 자식을 삭제한다고 해서 해당 자식 엔티티가 사라지지는 않음.
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderItem> orderItems = new ArrayList<>();
	
//	Orders 와 OrderItems 는 양방향 관계이기 때문에 자식객체인 item 를 더해줌과 동시에 자식객체에도 부모객체를 지정해줘야한다.
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrders(this);
	}
	
	public static Orders createOrder(Member member, List<OrderItem> orderItem) {
		Orders newOrders = new Orders();
		newOrders.setMember(member);
		for(OrderItem item : orderItem) {
			newOrders.addOrderItem(item);
		}
		newOrders.setOrderStatus(OrderStatus.ORDER);
		newOrders.setOrderDate(LocalDateTime.now());
		return newOrders;
	}
	
	public int getTotalPrice() {
		int total = 0;
		for (OrderItem item : orderItems) {
			total += item.getTotalPrice();
		}
		return total;
	}
}
