package com.Shop.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.Shop.DTO.MemberFormDTO;
import com.Shop.Entity.Member;
import com.Shop.Service.MemberService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
// 실제객체와 비슷하지만 테스트에 필요한 기능만을 제공하는 가짜 객체를 새성해준다.
// 웹 브라우저에서 요청이 오는것처럼 테스트할 수 있다. 
@AutoConfigureMockMvc
class MemberControllerTest {

	@Autowired
	private MemberService memberService;
		
//	가상의 객체를 사용하기 위한...? 
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	@DisplayName("createMember")
	public Member createMember(String email, String password) {
		MemberFormDTO member = new MemberFormDTO();
		member.setName("MemberName");
		member.setEmail(email);
		member.setPassword(password);
		member.setAddress("서울시 논현역");
		Member memberCreate = Member.createMember(member, passwordEncoder);
		return memberService.saveMember(memberCreate);
	}
	
	@Test
	@DisplayName("loginSuccessTest")
	public void loginSuccessTest() throws Exception {
		String email = "test@email.com";
	    String password = "1234";
	    this.createMember(email, password);
//		웹 브라우저에서 로그인버튼을 누른것 처럼 가상의 요청을 생성해서 테스트할 수 있음.
//		formLogin() 은 시큐리티에서 설정한 로그인 로직....하고 비슷한?
//	    위에서 임의의 아이디와 비밀번호로 유저를 생성하고, 해당 아이디와 비밀번호로 로그인이 되는지 테스트함.
        mockMvc.perform(formLogin().userParameter("email")
                .loginProcessingUrl("/members/login")
                .user(email).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
	}

	@Test
	@DisplayName("loginFailTest")
	public void loginFailTest() throws Exception {
		String email = "test@email.com";
		String password = "1234";
		this.createMember(email, password);
		mockMvc.perform(formLogin().userParameter("email")
				.loginProcessingUrl("/members/login")
//				유저를 생성한 비밀번호와 다른값을 넣어서 제대로 실패하는지 테스트함
				.user(email).password("1234444"))
//		matchers.unauth 로 인해서 로그인이 실패했을 때 테스트코드가 성공했다고 뜰 수 있도록 해준다.
//		Expect() 니까 기대값을 넣는가보지...? 그리고 기대값이 비인가일경우 성공이라고 뜨는거고....
		.andExpect(SecurityMockMvcResultMatchers.unauthenticated());
		
	}
}
