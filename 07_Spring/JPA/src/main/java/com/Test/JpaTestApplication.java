package com.Test;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Test.Constant.MemberClass;
import com.Test.Entity.Member;
import com.Test.Entity.Emf.UniqueEntityManagerFactory;
import com.Test.Service.MemberService;

@SpringBootApplication
public class JpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
//		지정한 이름으로 EMF를 생성. 해당 이름은 JPA의 persistence.xml 에서 설정한 persistence-unit 이름과 동일해야한다.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//		미리생성한 EMF 클래스의 상수 emf 에 생성한 매니저 팩토리 객체를 저장한다.
		UniqueEntityManagerFactory.emf = emf;
		
//		영속성 컨텍스트에 저장되지 않은상태의 비영속 엔티티.
		Member member1 = new Member();
		member1.setName("Nisikigi");
		member1.setMemberClass(MemberClass.VIP);
		member1.setDate(new Date());
		
		Member member2 = new Member();
		member2.setName("Inoue");
		member2.setMemberClass(MemberClass.USER);
		member2.setDate(new Date());
		
//		생성한 Member 객체를 보내서 DB에 저장한다.
		MemberService ms = new MemberService();
		ms.save(member1);
		ms.save(member2);
		
//		작업이 끝난다면 어플리케이션 종료와 함께 EMF를 종료시켜줘야한다.
		UniqueEntityManagerFactory.emf.close();
	}

}
