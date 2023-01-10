package com.Test.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.Test.Entity.Member;
import com.Test.Entity.Emf.UniqueEntityManagerFactory;

public class MemberService {
	public void save(Member member) {
//		생성되어 있는 entity manger factory를 가져옴.
		EntityManagerFactory emf = UniqueEntityManagerFactory.emf;
//		manager를 생성.
		EntityManager em = emf.createEntityManager();
//		Transaction 을 생성한다. 더 이상 분할할 수 없는 하나의 동작. commit 으로 나뉘는 동작단위.
		EntityTransaction tx = em.getTransaction();
		
		try {
//			Transaction 의 시작함과 동시에 DB에 연결한다.
			tx.begin();
//			해당 객체를 영속성 컨텍스트 Persistence Context 에 저장한다. 여기서 바로 실행하는것은 아니고 준비단계?
//			동시에 DB에도 Insert를 실행한다. 
//			컬럼명은 엔티티 클래스에서 이미 지정했고, 테이블은 이 과정에서 자동으로 생성된다.
			em.persist(member);
//			commit을 실행함으로써 지정했던 동작들을 실행시킨다.			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
//			오류가 발생했을경우 rollback을 실행한다.
			tx.rollback();
		} finally {
//			persist로 지정하여 영속성 컨텍스트에 저장했던 엔티티 객체들을 분리한 상태.
//			.close(), .detach(엔티티), .clear() 모두 같은 동작을 한다.
//			저장공간에서의 삭제와는 다르다. 영속성 컨텍스트에 활성/비활성 구역이 있는 느낌? 
//			em.close();
//			영속성 컨텍스트에서 해당 엔티티를 삭제하는 명령어. DB에서도 삭제된다는데...흐음?
//			close를 먼저하면 오류나는듯?
			em.remove(member);
		}
	}
}
