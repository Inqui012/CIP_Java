package com.Shop.DTO;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

// 회원가입화면에서 받아올 정보를 담을 DTO.
@Getter
@Setter
public class MemberFormDTO {
	
//	해당 필드에 들어오는값이 문자열일경우 null, 길이 0, 공백을 확인하여 일치하지 않을경우 에러메세지를 반환한다.
	@NotBlank(message = "이름은 필수 입력 값입니다.")	
	private String name;
	
	@Email(message = "이메일 형식으로 입력해주세요.")
//	blank 와 비슷하지만 공백은 검사하지 않음.
	@NotEmpty(message = "이메일은 필수 입력 값입니다.")
	private String email;
	
	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
	@Length(min = 8, max = 16, message = "최소 8자리, 최대 16자리를 입력하세요.")
	private String password;
	
	@NotEmpty(message = "주소는 필수 입력 값입니다.")
	private String address;
}
