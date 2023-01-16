package com.Shop.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// 스프링의 설정파일로 사용할 클래스를 지정하는 어노테이션
@Configuration
// 스프링 시큐리티의 필터체인을 사용하기 위한 어노테이션. 자동으로 필터체인을 포함시킨다.
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	WebSecurityConfigurerAdapter 에서 상속받은 메소드를 오버라이드 한다.
//	메소드 안에 내용물이 없을경우 http 요청에 대해 아무런 인증을 요구하지 않게된다.
//	매개변수로 받는 요청에 대해서 어떤 인증을 요구할건지 설정하는 메소드인듯???
//	페이지 권한, 로그인, 로그아웃 기능에 대한 설정.
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	}
	
//	보안을 위해 비밀번호를 암호화를 위해 사용하는 Bean
//	Bean = (스프링 객체, 메소드에 어노테이션으로 붙일경우 객체를 제공하는 역할을 한다고 지정하는 느낌?)
//	암호화의 방법은 다양하지만 여기서는 BCrypt 를 사용한다.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
