package com.Shop.DTO;

import java.time.format.DateTimeFormatter;
import java.util.*;

import com.Shop.Constant.OrderStatus;
import com.Shop.Entity.Orders;

import lombok.*;

@Getter 
@Setter
public class OrderHistDTO {

    public OrderHistDTO(Orders orders){
        this.orderId = orders.getId();
        this.orderDate = orders.getOrderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.orderStatus = orders.getOrderStatus();
    }

    private Long orderId; //주문아이디
    private String orderDate; //주문날짜
    private OrderStatus orderStatus; //주문 상태

    private List<OrderItemDTO> orderItemDtoList = new ArrayList<>();

    //주문 상품리스트
    public void addOrderItemDto(OrderItemDTO orderItemDTO){
        orderItemDtoList.add(orderItemDTO);
    }

}
