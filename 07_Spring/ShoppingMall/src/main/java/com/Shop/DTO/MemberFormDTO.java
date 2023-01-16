package com.Shop.DTO;

import lombok.Getter;
import lombok.Setter;

// 회원가입화면에서 받아올 정보를 담을 DTO.
@Getter
@Setter
public class MemberFormDTO {
	private String name;
	private String email;
	private String password;
	private String address;
}
