package com.Shop.Repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.Shop.Service.FileService;
import com.Shop.Service.ItemImgService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@SpringBootTest
class ItemImgRepositoryTest {

	private final ItemImgRepository itemImgRepository;
	@Test
	public void testing() {
		itemImgRepository.findByItemOrderByIdAsc((long) 21);
	}

}
