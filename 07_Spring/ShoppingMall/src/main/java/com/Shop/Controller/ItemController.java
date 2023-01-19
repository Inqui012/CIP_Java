package com.Shop.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Shop.DTO.ItemFormDTO;
import com.Shop.Service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	
	@GetMapping("/admin/item/new")
	public String itemForm(Model model) {		
		model.addAttribute("itemFormDTO", new ItemFormDTO());
		return "item/shop_ItemForm";
	}
	
	private final ItemService itemService;
	
//	받아온 값으로 상품정보를 생성하는 메소드
	@PostMapping("/admin/item/new")
//	@RequestParam으로 지정한 name 을 가진 input 값을 가져오는데 이게 여러개일 경우 List 타입으로 받아올 수 있다.
//	여기서는 파일을 리스트형태로 받아오고, 이 타입은 form 의 enctype 에서 지정하는 객체인듯함.....
	public String itemNew(@Valid ItemFormDTO itemFormDTO, BindingResult bindingResult, Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFile) {
		if(bindingResult.hasErrors()) {
			return "item/shop_ItemForm";
		}
		
//		이미지 업로드시 첫번째 이미지를 업로드했는지(필수 입력), 받아온 DTO에 id 가 없을것.
//		getId() 를 했는데 null 이라는건 아직 DB에 없는 데이터라는 소리임. ID 값은 자동생성으로 DB에서 생성되는 값이라
//		DB에 들어가지 않는 이상은 null 이 기본. 따라서 아래의 == null 의 의미는 DB에 이미 존재하는 데이터가 아님을 증명하는듯?
//		즉 첫번째 이미지가 없고, 새로 등록하려는 아이템일경우를 물어보는것.
//		Id 값이 있다면 그건 DB에 있는 값이라는 소리니까, 수정하는 경우의 입력값일테고, 그러면 첫번째 이미지가 이미 있겠...지?
		if(itemImgFile.get(0).isEmpty() && itemFormDTO.getId() == null) {
			model.addAttribute("errorMessage", "대표이미지를 업로드해 주세요");			
			return "item/shop_ItemForm";
		}
		
		try {
			itemService.saveItem(itemFormDTO, itemImgFile);
		} catch (Exception e) {
//			이렇게 throws 메소드를 타고 들어가면서 실행할경우 예외가 발생하면 어디서 발생하는지 찾기 진짜 힘드네
			model.addAttribute("errorMessage", "상품등록 중 에러가 발생함");			
			return "item/shop_ItemForm";			
		}
		
		return "redirect:/";
	}
}
