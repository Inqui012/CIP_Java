package com.Shop.Config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

// 인증되지 않은 사용자가 리소스를 요청할경우의 처리를 설정하는 클래스를 따로 생성해야한다.
// 인증되지 않은 사용자가 요청하는건 예외로 처리되고, Spring 에서 자연스럽게 이 클래스로 처리를 위임하나?
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
//		.sendError(int, String); 에러를 보내는 메소드?
//		int형은 http서블릿의 상수형 값으로 지정하고, 이거가 에러페이지에서 보이는 403, 404 같은 숫자인듯
//		이건 http 상태코드 라고하며 서버가 어떻게 응답하는지에 따라 번호가 지정되어 있다. 
//		서버 프로그램에서는 기억해두는게 좋음? 일단 이런게 있다는 수준으로. 
//		문자열은 해당 에러와 함께 표시할 문자열을 임의로 지정할 수 있는듯.
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UnAuthorized User");
	}

}
