package com.Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shop.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
//	이메일로 DB를 검색하여 중복을 확인한다.
	Member findByEmail(String email);
}
