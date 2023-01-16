package com.Shop.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.Shop.Constant.Role;
import com.Shop.DTO.MemberFormDTO;
import com.Shop.Entity.Member;

@SpringBootTest
// 테스트 코드에서 이 어노테이션을 적용하면 테스트하는 동안의 모든 DB와의 동작을 rollback 처리한다.
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {

	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	@DisplayName("createMember")
	public Member createMember() {
		MemberFormDTO member = new MemberFormDTO();
		member.setName("MemberName");
		member.setEmail("temp001@test.com");
//		시큐리티에서 제공하는 암호화 알고리즘을 통해 비밀번호를 암호화 한 뒤 DB에 저장한다.
		member.setPassword("1234");
		member.setAddress("서울시 논현역");
		return Member.createMember(member , passwordEncoder);
	}
	
	@Test
	@DisplayName("saveMemberTest")
	public void saveMemberTest() {
		Member member = createMember();
		Member savedMember = memberService.saveMember(member);
//		테스트 코드를 실행할때 사용한느 값을 비교하는 메소드.
//		저장하려고 했던 값과 실제 저장된 값을 비교.
//		일치하지 않을경우 테스트케이스가 실팼다고 표시함.
		assertEquals(member.getEmail(), savedMember.getEmail());
		assertEquals(member.getAddress(), savedMember.getAddress());
		assertEquals(member.getName(), savedMember.getName());
		assertEquals(member.getPassword(), savedMember.getPassword());
		assertEquals(member.getRole(), savedMember.getRole());
	}
	
	@Test
	@DisplayName("validateMemberTest")
	public void validateMemberTest() {
		Member member1 = createMember();
		Member member2 = createMember();
		memberService.saveMember(member1);
//		assert 는 보통 테스트 클래스에서 사용하는 메소드인듯. 아래는 오류를 위한 메소드.
//		람다식으로 실행하는 코드에서 에러가 발생했고, 해당 에러가 지정한 IllegalState 일경우...?
		Throwable e = assertThrows(IllegalStateException.class, () -> {
			memberService.saveMember(member2);			
		});
		assertEquals("이미 가입된 회원입니다.", e.getMessage());
	}
}
