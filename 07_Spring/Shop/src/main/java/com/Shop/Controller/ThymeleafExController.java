package com.Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
