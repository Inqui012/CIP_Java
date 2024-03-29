package com.Shop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shop.Entity.ItemImg;

public interface ItemImgRepository  extends JpaRepository<ItemImg, Long>{
	List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);
	ItemImg findByItemIdAndRepImgYn(Long itemId, String repImgYn);
}
