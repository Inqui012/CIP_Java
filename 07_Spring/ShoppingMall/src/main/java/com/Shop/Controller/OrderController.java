package com.Shop.Controller;

import java.security.Principal;
import java.util.*;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Shop.DTO.OrderDTO;
import com.Shop.DTO.OrderHistDTO;
import com.Shop.Entity.Item;
import com.Shop.Service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;
	
	@PostMapping("/order")
//	비동기 통신(순서없이 일을 진행함, 화면의 새로고침 없이 진행)에서 사용하는 @ResponseBody, @RequestBody 어노테이션.
//	사용하는 위치가 특이하네. 메소드의 리턴타입 앞, 받아오는 데이터를 지정한 매개변수 앞에 써줌.
//	@RequestBody 어노테이션이 있을경우 Spring 에서 자체적으로 ajax 임을 인지하고 http의 body 에 있는 데이터라고 인식한다?
//	@ResponseBody 생성된 자바객체 데이터를 http 에 담아서 돌려준다.
//	HTTP의 Body 에 요청내용이나 응답객체를 담아 사용하고, 주로 JSON 형태로 데이터를 주고받는다.
//	ResponseEntity 객체. HTTP 의 header, body 를 가지고 있는 클래스.
//	HTTP를 객체로 만들어놓은 느낌?
//	Principal 객체는 Spring Security 에서 사용하는 객체로 유저의정보를 얻어올 수 있다.
//	상속상으로 최상위에 있기 때문에 사용할 수 있는 메소드가 얼마 없음... ID 정보만을 가져온다는 개념?
	public @ResponseBody ResponseEntity order(@RequestBody @Valid OrderDTO orderDTO, BindingResult bindingResult, Principal principal) {
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
//			FieldError 유효성체크를 한 뒤에, 모든 발생한 에러를 해당 타입으로 반환한다.
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			fieldErrors.forEach(e -> sb.append(e.getDefaultMessage()));
//			새로운 ResponseEntity 객체를 생성해서 보낸다.
//			보내는 내용은 에러메세지이기 때문에 제네릭은 String이 되는듯.
//			오류코드는 httpStatus 라는 객체 안에 정리되어 있는것들을 보면서 찾아내면 되는듯. 없으면 만들어야하고.
			return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
		}
//		로그인한 사용자의 정보를 가지고 있는 principal 에서 사용자의 이름으로 지정한 email을 가져올 수 있음.
//		아이디로 이메일로 지정했으니 이메일이고, 그냥 일반 아이디일 경우 아이디, 성명일경우 성명 등을 가져옴.
		String email = principal.getName();
		Long orderId;
		try {
			orderId = orderService.order(orderDTO, email);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Long>(orderId, HttpStatus.OK);
	}
	
	@GetMapping({"/orders", "/orders/{Page}"})
	public String getOrders (@PathVariable("Page") Optional<Integer> page, Model model, Principal principal) {
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
		Page<OrderHistDTO> pages = orderService.orderList(principal.getName(), pageable);
		model.addAttribute("orders", pages);
		model.addAttribute("page", pageable.getPageNumber());
		model.addAttribute("maxPage", 5);
		return "member/shop_orderList";
	}
}
