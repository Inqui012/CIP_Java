package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Restful API를 위한 어노테이션
// 어노테이션중에서도 Controller 가 붙은 것들은 서블릿 컨트롤러의 역할을 하는 어노테이션이다.
// RestController는 그중에서도 컨트롤러의 역할과 응답을 묶어놓은 어노테이션? 
@RestController
@SpringBootApplication
public class SpringDemoApplication {

//	스프링의 메인메소드.
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}
	
//	서블릿에서 하던 주소매핑을 어노테이션으로 간단하게 하네
//	기본적으로는 @RequestMapping 이 서블릿의 매핑기능을 하는거고 세부로 나뉘는
//	Get, Post, Put, Delete, Patch 로 나뉘는것 같은데. 이건 데이터를 전달하는 메소드방식을 지정하는듯?
//	경로주소뿐만 아니라 params 나 headers 같은 다른 정보들을 기반으로 매핑할수도 있다.
	@GetMapping(value = "/")
	public String Hello() {
//		html의 body 안에 문자열을 그대로 넣어줌. 태그를 넣어주면 태그도 잘 적용되네
//		body 안에 자동으로 들어가는데 그럼... head 태그에는 어떻게 넣으려나
//		react 에서 return 으로 태그를 사용하는 느낌하고 비슷한것 같아.
		return "<h1>HELLO SPRING</h1>";
	}
	
//	여러개의 경로를 지정하고 싶을경우 배열형식으로 지정할 수 있음.
	@GetMapping(value = {"/hi", "/hi2"})
	public String Hi() {
		return "<h1>HI SPRING</h1>";
	}
	
}
