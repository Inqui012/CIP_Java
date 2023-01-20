package com.Shop.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Shop.DTO.ItemFormDTO;
import com.Shop.DTO.ItemSearchDTO;
import com.Shop.Entity.Item;
import com.Shop.Repository.ItemRepository;
import com.Shop.Service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;
	
	@GetMapping("/admin/item/new")
	public String itemForm(Model model) {		
		model.addAttribute("itemFormDTO", new ItemFormDTO());
		return "item/shop_ItemForm";
	}
	
	
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
	
//	주소에서 지속적으로 변하는 값이 있다면 {} 로 값이 변동되는 위치를 지정해줄 수 있다.
//	이후 재정한 메소드에서 매개변수에 @PathVariable 어노테이션을 설정해주면 변동되는 값을 가져올 수 있다.
//	주소값은 String 이라고 생각했는데 숫자로 고정된다면 매개변수에서 형변환이 가능한건가?? Long 으로 지정하네
//	앞단에서 숫자를 붙일때 itemFormDTO.id 로 붙였으니, 그 데이터형식을 그대로 가져오는건가?
//	주소를 url 에서 읽는게 아니라 좀더... 어............컴퓨터적으로?????? 읽는.....
	@GetMapping("/admin/item/{itemId}")
	public String modItemForm(@PathVariable("itemId") Long itemId, Model model) {
		try {
			model.addAttribute("itemFormDTO", itemService.findModItem(itemId));
		} catch (Exception e) {
			model.addAttribute("errorMessage", "상품을 불러오는 중 에러가 발생함");
			model.addAttribute("itemFormDTO", new ItemFormDTO());
			return "item/shop_ItemForm";
		}
		return "item/shop_ItemForm";
	}
	
	@PostMapping("/admin/item/{itemId}")
	public String modItem(@Valid ItemFormDTO itemFormDTO, BindingResult bindingResult, @RequestParam("itemImgFile") List<MultipartFile> itemImgFile, Model model) {
		if(bindingResult.hasErrors()) {
			return "item/shop_ItemForm";
		}
		if(itemImgFile.get(0).isEmpty() && itemFormDTO.getId() == null) {
			model.addAttribute("errorMessage", "대표이미지를 업로드해 주세요");			
			return "item/shop_ItemForm";
		}
		try {
			itemService.modifyItem(itemFormDTO, itemImgFile);
		} catch (Exception e) {
			model.addAttribute("errorMessage", "상품을 수정하는 중 에러가 발생함");
			model.addAttribute("itemFormDTO", itemFormDTO);
			return "item/shop_ItemForm";
		}
		return "redirect:/";
	}
	
	@GetMapping({"/admin/items", "/admin/items/{Page}"})
//	Page 파라메터를 받아오는 객체는 Optional 타입으로 받네.......
	public String itemManage(ItemSearchDTO itemSearchDTO, Model model, @PathVariable("Page") Optional<Integer> page) {
//		PageRequest.of(페이지번호, 한페이지당 리스르갯수); 
//		Optional 로 받아온 페이지 파라메터가 존재할경우 해당 숫자를, 없을경우 0 을 반환.
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 2);
		Page<Item> pages = itemService.getAdminItemPage(itemSearchDTO, pageable);
		System.out.println(pages.getTotalPages());
		model.addAttribute("items", pages);
		model.addAttribute("itemSearchDTO", itemSearchDTO);
		model.addAttribute("maxPage", 5);
		return "item/shop_itemBoard";
	}
	
//	내가 혼자 만들어본 아이템 리스트 보여주는 페이지. 선생님거하고 다름.
//	아직 자세히는 아니지만 좀 감이 잡히는거 같기도 하고....
	@GetMapping("/item")
	public String itemList (Model model) {
		try {
			List<ItemFormDTO> itemList = itemService.itemList();
			model.addAttribute("itemList", itemList);
		} catch (Exception e) {
			model.addAttribute("errorMessage", "상품리스트를 불러오는 중 에러가 발생함");
			return "redirect:/";
		}
		return "item/shop_ItemList";
	}
}
