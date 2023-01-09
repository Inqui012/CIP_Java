package com.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok을 사용한 getter/setter 설정.
// 자동으로 임포트할 수 있다. 이렇게 하면 확실히 코드가 많이 줄어들고 보기가 좋네
@Getter
@Setter
@ToString
public class User_DTO {
	private String name;
	private String id;
	private String pw;

}
