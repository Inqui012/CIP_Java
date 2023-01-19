package com.Shop.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 설정클래스를 지정하거나 내부에서 bean 등록을 위한 어노테이션 등록하는 bean 이 싱글톤이 되도록 보장한다.
@Configuration
// Jpa의 Auditing 기능을 활성화시키는 어노테이션
@EnableJpaAuditing
public class AuditConfig {
	
	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}
}
