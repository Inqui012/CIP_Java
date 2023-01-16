package com.Shop.Controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Shop.DTO.MemberFormDTO;
import com.Shop.Entity.Member;
import com.Shop.Service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
//	회원가입 페이지로 넘어가는 부분
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("memberFormDTO", new MemberFormDTO());
		return "member/shop_memberForm";
	}
	
//	Post 방식으로 요청이 올때의 메소드.
//	회원가입 페이지의 form 태그의 버튼을 눌러 submit을 했을때 실행하는 메소드.
	@PostMapping("/register")
	public String register(MemberFormDTO memberFormDTO) {
		Member member = Member.createMember(memberFormDTO, passwordEncoder);
		memberService.saveMember(member);
//		새로고침등으로 데이터가 다시 들어가는것을 방지하기 위해 데이터를 초기화하고 새로운 페이지로 넘어간다.
//		redirect:경로 형식으로 지정한다.
		return "redirect:/";
	}
}
