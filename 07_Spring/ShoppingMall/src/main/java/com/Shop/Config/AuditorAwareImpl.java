package com.Shop.Config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

// 자동으로 등록/수정 에대한 시간/인물 에 대한 정보를 입력해주는 Spring Data 의 Auditing 기능을 위한 클래스.
// 상속받은 인터페이스 AuditorAware 로 누가 수정/등록했는지를 설정할 수 있다.
// 보통 현재 로그인한 사용자의 정보를 가져다 사용한다.
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
//		Spring security 의 인증자 객체. 
//		뒤의 체인메소드로 현재 로그인되어 있는 사용자의 정보를 가져올 수 있다.
//		스프링에서 진행해주는 UserDetails 를 이용한 로그인절차를 생각하면 이해가 가능.
//		로그인 인증을 통과하여 생성한 UserDetails 를 받아 저장하는 곳이 SecurityContext 였음.
//		계층구조로 되어 있는듯. 인증된 사용자 정보 Principal 을 Authentication 에서 관리하고
//		해당 auth 를 security context 에서 관리, 해당 context를 holder 에서 관리.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = "";
		if(authentication != null) {
//			사용자의 이름을 가져옴.
			userId = authentication.getName();
		}
//		지정한 사용자의 이름을 등록/수정 한사람의 이름으로 지정한다.
		return Optional.of(userId);
	}

}
