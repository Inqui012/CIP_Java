package com.Shop.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Shop.DTO.ItemSearchDTO;
import com.Shop.Entity.Item;

// 페이네이션을 사용하기 위해 사용자정의 인터페이스를 만든다.
// DSL 과 Spring 을 같이 사용하기 위해서는 이렇게 해야한다는 규칙같은거??
public interface ItemCustomRepository {
	Page<Item> getAdminItemPage(ItemSearchDTO itemSearchDTO, Pageable pageable);
}
