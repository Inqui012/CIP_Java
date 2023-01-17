package com.Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	
	@GetMapping("admin/item/new")
	public String register() {
		return "item/shop_ItemForm";
	}
}
