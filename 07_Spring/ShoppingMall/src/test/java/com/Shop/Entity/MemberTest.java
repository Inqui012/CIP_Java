package com.Shop.Entity;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.Shop.Repository.MemberRepository;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	@DisplayName("Auditing")
	@WithMockUser(username = "test01", roles = "USER")
	public void auditingTest() {
		Member newMember = new Member();
		memberRepository.save(newMember);
		em.flush();
		em.clear();
		
//		한번 값을 바꾸면 update 시간이 약간이지만 바뀐다.
		Member member = memberRepository.findById(newMember.getId()).orElseThrow(EntityNotFoundException::new);
		member.setName("test02");
		memberRepository.save(member);
		em.flush();
		em.clear();
		
		member = memberRepository.findById(newMember.getId()).orElseThrow(EntityNotFoundException::new);
		System.out.println("regTime : " + member.getRegTime());
		System.out.println("regBy : " + member.getCreateBy());
		System.out.println("newName : " + member.getName());
		System.out.println("updateTime : " + member.getUpDateTime());
		System.out.println("modifiBY : " + member.getModifiedBy());
	}
}
