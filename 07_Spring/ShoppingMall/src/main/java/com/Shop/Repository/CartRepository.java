package com.Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shop.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
