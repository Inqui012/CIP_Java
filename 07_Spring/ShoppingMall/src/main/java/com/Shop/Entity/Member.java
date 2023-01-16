package com.Shop.Entity;

import javax.persistence.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.Shop.Constant.Role;
import com.Shop.DTO.MemberFormDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="member")
@Getter
@Setter
@ToString
@Entity
public class Member {
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@Column(unique = true)
	private String email;
	private String password;
	private String address;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public static Member createMember(MemberFormDTO MemberFormDTO, PasswordEncoder PasswordEncoder) {
		Member member = new Member();
		member.setName(MemberFormDTO.getName());
		member.setEmail(MemberFormDTO.getEmail());
//		시큐리티에서 제공하는 암호화 알고리즘을 통해 비밀번호를 암호화 한 뒤 DB에 저장한다.
		member.setPassword(PasswordEncoder.encode(MemberFormDTO.getPassword()));
		member.setAddress(MemberFormDTO.getAddress());
		member.setRole(Role.USER);
		return member;
	}
}
