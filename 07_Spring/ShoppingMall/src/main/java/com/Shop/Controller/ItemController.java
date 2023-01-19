package com.Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Shop.DTO.ItemFormDTO;

@Controller
public class ItemController {
	
	@GetMapping("admin/item/new")
	public String register(Model model) {		
		model.addAttribute("itemFormDTO", new ItemFormDTO());
		return "item/shop_ItemForm";
	}
}
