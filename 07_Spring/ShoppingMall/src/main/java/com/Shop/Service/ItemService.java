package com.Shop.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.Shop.DTO.ItemFormDTO;
import com.Shop.DTO.ItemImgDTO;
import com.Shop.DTO.ItemSearchDTO;
import com.Shop.Entity.Item;
import com.Shop.Entity.ItemImg;
import com.Shop.Repository.ItemImgRepository;
import com.Shop.Repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
	private final ItemRepository itemRepository;
	private final ItemImgService itemImgService;
	private final ItemImgRepository itemImgRepository;
	
	public Long saveItem(ItemFormDTO itemFormDTO, List<MultipartFile> itemImgFileList) throws Exception {
//		상품등록		
		Item item = itemFormDTO.createItem();
		itemRepository.save(item);
		
		for(int i = 0; i < itemImgFileList.size(); i++) {
			ItemImg itemImg = new ItemImg();
			itemImg.setItem(item);
			if(i == 0) {
				itemImg.setRepImgYn("Y");
			} else {
				itemImg.setRepImgYn("N");
			}
			
			itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
		}
		return item.getId();
	}
	
//	select 만 해오는 메소드의 경우는 읽기전용으로 트랜잭션을 설정해주면 성능향상이 도움이 된다.
//	이 설정은 강제로 em.flush() 를 하지 않는이상 플러시가 일어나지 않게 설정하는듯.
//	따라서 의도치 않은 등록,수정,삭제가 동작하지 않고 오로지 읽어오기만 감지하고 영속성 컨텍스트에서 성능향상을 기대할 수 있다...?
	@Transactional(readOnly = true)
	public ItemFormDTO findModItem(Long itemId) throws Exception {
//		find 메소드 오타주의.....
		List<ItemImg> itemImgList = itemImgRepository.findByItemIdOrderByIdAsc(itemId);
		List<ItemImgDTO> itemImgDTOList = new ArrayList<>();
		for(ItemImg img : itemImgList) {
//			Mapper 로 자동으로 DB에서 가져온 데이터와 DTO 의 데이터를 변환한다.
			ItemImgDTO itemImgDTO = ItemImgDTO.of(img);
			itemImgDTOList.add(itemImgDTO);
		}
//		아이템 테이블하고 이미지 테이블하고는 일방적 참조라서 DTO도 나눠져있네...
//		아이템 정보하고 이미지 정보를 따로 가져와서 FormDTO 에서 하나로 합치는 느낌?
//		이렇게 데이터를 가져와서 원하는 형태로 합치거나 하는걸 가공을 하는 과정이라고 표현하나봐.
//		그래서 서비스에서 하는 일을 '비즈니스 로직을 수행한다' 라고 하는건가
		Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
		ItemFormDTO itemFormDTO = ItemFormDTO.of(item);
		itemFormDTO.setItemImgDTOList(itemImgDTOList);
		return itemFormDTO; 
	}
	
	public Long modifyItem(ItemFormDTO itemFormDTO, List<MultipartFile> itemImgFileList) throws Exception {
		Item modifyItem = itemRepository.findById(itemFormDTO.getId()).orElseThrow(EntityNotFoundException::new);
		modifyItem.updateItem(itemFormDTO);
		List<Long> itemImgId = itemFormDTO.getItemImgIds();
		for(int i = 0; i < itemImgFileList.size(); i++) {
			itemImgService.modifyImg(itemImgId.get(i), itemImgFileList.get(i));			
		}
		return modifyItem.getId();
	}
	
	@Transactional(readOnly = true)
	public Page<Item> getAdminItemPage(ItemSearchDTO itemSearchDTO, Pageable pageable){
		return itemRepository.getAdminItemPage(itemSearchDTO, pageable);
	}
	
//	혼자만든 DB의 아이템을 전부 불러오는 메소드.
	@Transactional(readOnly = true)
	public List<ItemFormDTO> itemList() throws Exception {
		List<ItemFormDTO> itemList = new ArrayList<>();
		List<Item> allItem = itemRepository.findAll();
		for(int i = 0; i < allItem.size(); i++) {
			ItemFormDTO listedItem = ItemFormDTO.of(allItem.get(i)); 
			ItemImgDTO refImg = ItemImgDTO.of(itemImgRepository.findByItemIdOrderByIdAsc(allItem.get(i).getId()).get(0));
			listedItem.getItemImgDTOList().add(refImg);
			itemList.add(listedItem);
		}
		return itemList;
	}
}
