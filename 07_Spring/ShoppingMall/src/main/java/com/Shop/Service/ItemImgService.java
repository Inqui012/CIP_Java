package com.Shop.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.Shop.Entity.ItemImg;
import com.Shop.Repository.ItemImgRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImgService {
	@Value("${itemImgLocation}")
	private String itemImgLocation;
	
	private final ItemImgRepository itemImgRepository;
	
	private final FileService fileService;
	
//	MultipartFile 는 스프링에서 업로드하는 파일을 다루기 쉽게 도와주는 객체
	public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception {
		String oriImgName = itemImgFile.getOriginalFilename();
		String imgName = "";
		String imgUrl = "";
		
		if(!StringUtils.isEmpty(oriImgName)) {
			imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
			imgUrl = "/img/item/" + imgName;
		}
		
		itemImg.updateItemImg(oriImgName, imgName, imgUrl);
		itemImgRepository.save(itemImg);
	}

//	이미지 수정용 메소드.
	public void modifyImg (Long itemImgId, MultipartFile itemImgFile) throws Exception {
		if(!itemImgFile.isEmpty()) {
			ItemImg savedItemImg = itemImgRepository.findById(itemImgId).orElseThrow(EntityNotFoundException::new);
//			이미지가 이미 존재할경우 서버내의 파일을 먼저 삭제한다. 여기서는 로컬파일.
			if(!StringUtils.isEmpty(savedItemImg.getImgName())) {
				fileService.deleteFile(itemImgLocation + "/" + savedItemImg.getImgName());
			}
			String oriImgName = itemImgFile.getOriginalFilename();
			String imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
			String imgUrl = "/img/item/" + imgName;
			
//			기존에 존재하는 savedItemImg 엔티티의 값들을 수정하는거라 따로 .save 해주지 않아도 됨.
//			해당 엔티티는 영속상태이고, 영속상태의 엔티티는 변화를 감지해서 알아서 update 문이 실행되기 때문에.
			savedItemImg.updateItemImg(oriImgName, imgName, imgUrl);
		}
	}
}
