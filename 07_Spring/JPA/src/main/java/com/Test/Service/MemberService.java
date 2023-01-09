package com.Test.Service;

import javax.persistence.EntityManagerFactory;

import com.Test.Entity.Member;
import com.Test.Entity.Emf.UniqueEntityManagerFactory;

public class MemberService {
	public void save(Member member) {
		EntityManagerFactory emf = UniqueEntityManagerFactory.emf;
	}
}
