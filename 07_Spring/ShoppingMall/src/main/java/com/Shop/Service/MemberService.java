package com.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Shop.Entity.Member;
import com.Shop.Repository.MemberRepository;

import lombok.RequiredArgsConstructor;

// 해당 클래스를 서비스로서 사용하겠다는 어노테이션.
// 서비스는 컨트롤러에서 요청을 받아 Repository를 통해 DB와의 연결로 기능을 수행하는 객체이다.
// 결과값을 다시 컨트롤러로 돌려보내 컨트롤러에서 view 를 생성할 수 있게 한다.
@Service
// 서비스 객체에 붙일 수 있는 어노테이션. 해당 서비스 클래스를 실행하는 도중 오류가 발생했을 경우
// 자동으로 Rollback 을 실행하여 실행전 상태로 되돌아가게 된다.
@Transactional
// final 속성이 붙은 객체에 의존성주입을 할 경우에 사용하는 어노테이션.
// @Autowired 를 사용하지 않아도 동일한 기능을 사용할 수 있다.
@RequiredArgsConstructor
public class MemberService {
//	필드에 final 이 붙었을 경우 의존성 주입을 하기 위해서는 생성자를 이용하는 방법밖에 없었는데
//	이를 편하게 하기 위해서 lombok 에서 제공하는 @RequiredArgs 어노테이션을 사용한다.
//	MemberService(MemberRepository memberRepository) 생성자의 작성을 자동으로 해준다.
	private final MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
//		회원가입창에서 받은 정보 -> DTO -> MemberEntity 생성 -> memberRepository 에서 저장
		validateMember(member);
		return memberRepository.save(member);
	}
	
	public void validateMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
}
