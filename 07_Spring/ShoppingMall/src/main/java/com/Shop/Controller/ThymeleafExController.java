package com.Shop.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Shop.Constant.ItemSellStatus;
import com.Shop.DTO.ItemDTO;

// MVC패턴의 컨트롤러의 역할을 하는 클래스를 선언하는 어노테이션.
// JSP와는 다르게 서블릿이 아니라 일반 클래스로 생성한다.
@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {
	
	@GetMapping(value = "/ex01")
	public String thymeleafEx01(Model model) {
//		서블릿 컨트롤러에서 Request 에 값을 저장하는것과 똑같다.
//		Model = HttpRequest 라고 생각하면 편함.
		model.addAttribute("data", "example for thymeleaf");
//		리턴값은 이동할 html 페이지 경로.
		return "thyemleafEx/thymeleafEx01";
	}
	
//	프로젝트를 스프링서버로 열어놓은 후에 http://localhost/thymeleaf/ex02 로 접속
	@GetMapping("/ex02")
	public String thymeleafEx02(Model model) {
		List<ItemDTO> dtoList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			ItemDTO itemDto = new ItemDTO();
			itemDto.setItemName("Test Product " + i);
			itemDto.setPrice(8800);
			itemDto.setItemDetail("The cake is fake");
			itemDto.setRegTime(LocalDateTime.now());	
			dtoList.add(itemDto);
		}
		model.addAttribute("dtoList", dtoList);
		return "thyemleafEx/thymeleafEx02";
	}
	
	@GetMapping("/ex03")
	public String thymeleafEx03(Model model) {
		return "thyemleafEx/thymeleafEx03";
	}
	
	@GetMapping("/ex04")
	public String thymeleafEx04(String day, String name, Model model) {
		model.addAttribute("day", day);
		model.addAttribute("name", name);
		return "thyemleafEx/thymeleafEx04";
	}

}
