package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test_Constroller {

//	객체를 리턴해줘서 어떻게 뜰까 싶었는데 객체의 값들을 자동으로 json 형식으로 변환해서 화면에서 보여준다.
//	ToString 도 어노테이션으로 사용해줘서 자동으로 객체의 키와 값들을 콘솔에 찍어줌.
//	json으로 변환했을때 데이터의 순서는 객체에서 필드를 지정한 순서대로 나오는듯.
	@GetMapping(value = "/user")
	public User_DTO User() {
		User_DTO user = new User_DTO();
		user.setName("user001");
		user.setId("001");
		user.setPw("1234");
		System.out.println(user.toString());
		return user;
	}
}
