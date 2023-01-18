package com.Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shop.Entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
