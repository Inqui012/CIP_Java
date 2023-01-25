package com.Shop.Controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Shop.DTO.ItemSearchDTO;
import com.Shop.DTO.MainItemDTO;
import com.Shop.Service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
//	페이지 레이아웃 html. 본문만을 작성한 html 으로 연결했는데도 헤더랑 푸터가 나오네.
//	그럼 본문만 있는 page01_Section 으로 갔다가, layout을 보고 헤더와 푸터를 지정한 page01 까지 가는건가?
//	@GetMapping("/")
//	public String main(Model model,@AuthenticationPrincipal User user) {
//		if(user != null) {
//			model.addAttribute("User", user.getUsername());			
//		}
//		return "shop_Main";
//	}
	
	private final ItemService itemService;
	
	@GetMapping("/")
	public String mainItem (ItemSearchDTO itemSearchDTO, Model model, Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
		Page<MainItemDTO> pages = itemService.getMainItemPage(itemSearchDTO, pageable);
		model.addAttribute("items", pages);
		model.addAttribute("itemSearchDTO", itemSearchDTO);
		model.addAttribute("maxPage", 5);
		return "shop_Main";
	}
}
