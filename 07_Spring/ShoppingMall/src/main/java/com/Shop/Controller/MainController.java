package com.Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
//	페이지 레이아웃 html. 본문만을 작성한 html 으로 연결했는데도 헤더랑 푸터가 나오네.
//	그럼 본문만 있는 page01_Section 으로 갔다가, layout을 보고 헤더와 푸터를 지정한 page01 까지 가는건가?
	@GetMapping("/")
	public String main() {
		return "shop_Main";
	}
}
