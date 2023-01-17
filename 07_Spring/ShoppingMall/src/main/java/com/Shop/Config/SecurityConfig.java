package com.Shop.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Shop.Service.MemberService;

// 스프링의 설정파일로 사용할 클래스를 지정하는 어노테이션
@Configuration
// 스프링 시큐리티의 필터체인을 사용하기 위한 어노테이션. 자동으로 필터체인을 포함시킨다.
@EnableWebSecurity
// APP에 대한 인증과 접근권한을 설정하기 위한 클래스.
// 특정페이지에 대한 접근을 제어하거나, 사용자에게 권한을 부여하거나, 암호화를 진행 할때 사용함.
public class SecurityConfig {

//	해당 상속 클래스는 현재 사용이 권장되고 있지 않아 다른 방법을 사용.
//	WebSecurityConfigurerAdapter 에서 상속받은 메소드를 오버라이드 한다.
//	메소드 안에 내용물이 없을경우 http 요청에 대해 아무런 인증을 요구하지 않게된다.
//	매개변수로 받는 요청에 대해서 어떤 인증을 요구할건지 설정하는 메소드인듯???
//	페이지 권한, 로그인, 로그아웃 기능에 대한 설정.
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	}
	
//	보안을 위해 비밀번호를 암호화를 위해 사용하는 Bean
//	Bean = (스프링 객체, 메소드에 어노테이션으로 붙일경우 객체를 제공하는 역할을 한다고 지정하는 느낌?)
//	암호화의 방법은 다양하지만 여기서는 BCrypt 를 사용한다.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	현재 사용하는 방식의 security 설정방법. 이렇게 사용하라고 규칙으로 정해져있으니 그냥 쓰면된다?
	@Autowired
	MemberService memberService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
//		.formLogin() 로그인에 대한 설정을 시작한다는...메소드...?
//		기본적으로 (로그인에 대한 설정).and().(로그아웃에 대한 설정) 형식을 가지는것 같다.
//		.loginPage(경로) 로그인이 실행되는 페이지의 경로를 지정한다.
		http.formLogin().loginPage("/members/login")
//			.defaultSuccessUrl(경로) 로그인이 성공했을 시 이동할 페이지의 경로
//			.usernameParameter(파라메터명) 로그인 작업에 사용할 파라메터의 이름
//			.failureUrl(경로) 로그인이 실패했을때에 이동할 페이지의 경로
			.defaultSuccessUrl("/").usernameParameter("email").failureUrl("/members/login/error")
//			.logoutRequestMatcher() 로그아웃을 실행할 경로
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
//			.logoutSuccessUrl(경로) 로그아웃에 성공했을 때 이동할 페이지의 경로
			.logoutSuccessUrl("/");
		
//		.authorizeRequests 페이지 접근권한에 대한 설정.
		http.authorizeRequests()
//			.mvcMatchers(경로, 경로 ...) 지정한 경로에 대한 접근권한을 개별로 설정할 수 있다. ** 는 경로의 하위를 의미.
//			.permitAll() 앞에서 지정한 경로에대해, 모든 사용자에 대해 로그인없이 접근할 수 있도록 설정한다.
			.mvcMatchers("/", "/members/**", "/item/**", "/img/**", "/css/**", "/js/**").permitAll()
//			.hasRole() 아ㅠ에서 지정한 경로에대해, 지정한 역할을 가지고 있는 사용자만이 접근할 수 있도록 설정한다.
			.mvcMatchers("/admin/**").hasRole("ADMIN")
//			.anyRequest() 위에서 설정한 것 이외의 모든 다른 경로에 대한 설정.
//			.authenticated() 로그인(인증)이 필요한 접근
			.anyRequest().authenticated();
		
//		인증되지 않은(비로그인) 상태의 사용자가 리소스(페이지, 이미지...)에 접근했을 때의 설정.
//		따로 예외처리를 담당할 클래스를 만들어놓고 거기에서 가져온다. 예외처리는 전부 해당 클래스에서 지정하는건가?
//		아니네, 인증되지 않은 접속의 경우에는 authenticationEntryPoint(401에러)를 사용하고
//		인증은 했는데 권한이 없는 접근의 경우에는 CustomAccessDeniedHandler(403?) 를 사용하는 것 같다.
//		에러마다 전부 메소드가 있는건 아닌것 같고... 특별한 몇몇개만 있는건가?
//		이 처리는 스프링의 ExceptionTranslationFilter 에서 걸러내는? 것이고 여기서는 401, 403 두개만 처리해서 메소드가 저 두개만 있는듯
		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
		return http.build();
	}
}
