package com.Shop.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Shop.Entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
//	현재 사용자의 주문데이터
	@Query("SELECT o FROM Orders o WHERE o.member.email = :e ORDER BY o.orderDate DESC")
	List<Orders> findOrders(@Param("e") String email, Pageable pageable);
	@Query("SELECT COUNT(o) FROM Orders o WHERE o.member.email = :e")
	Long countOrder(@Param("e") String email);
}
