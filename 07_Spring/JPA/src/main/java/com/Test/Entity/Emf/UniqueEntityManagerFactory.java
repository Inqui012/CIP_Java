package com.Test.Entity.Emf;

import javax.persistence.EntityManagerFactory;

// JPA에서 엔티티를 관리하기 위해 존재하는 Entity Manager Factory
// 사용자의 요청이 있을경우 엔티티 매니저를 생성하고 해당 매니저가 영속성 컨텍스트에 저장되어 있는 엔티티에 접근한다.
// 매니저 팩토리는 APP 실행시 하나만 생성한다 -> static 으로 선언
// 팩토리에서 생성하는 매니저는 요청이 있을때마다 새로 생성된다.
public class UniqueEntityManagerFactory {
	public static EntityManagerFactory emf;
}
