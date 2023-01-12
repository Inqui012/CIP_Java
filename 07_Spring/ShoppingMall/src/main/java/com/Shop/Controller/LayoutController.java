package com.Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class LayoutController {
	
	@GetMapping("/page01")
	public String layoutEx01(Model model) {
		return "/Layouts/page01";
	}
}
