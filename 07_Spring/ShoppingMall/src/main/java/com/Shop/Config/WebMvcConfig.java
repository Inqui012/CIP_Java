package com.Shop.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 업로드된 파일을 읽어오는 경로를 설정하는 클래스
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//	apllication.poperty 에서 설정한 uploadPath 의 값을 가져오는 어노테이션.
	@Value("${uploadPath}")
	String uploadPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		handler 에서 지정하는 경로상의 리소스는 전부 location 에서 지정한 경로에서만 불러오겠다는 설정.
//		이미지파일을 프로젝트 내부가 아닌, uploadPath로 지정한 경로에 저장하면 볼 수 있음.
		registry.addResourceHandler("/img/**").addResourceLocations(uploadPath);
	}
	
}
