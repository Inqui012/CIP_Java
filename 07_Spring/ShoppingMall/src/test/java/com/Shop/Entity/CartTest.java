package com.Shop.Entity;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.Shop.DTO.MemberFormDTO;
import com.Shop.Repository.CartRepository;
import com.Shop.Repository.MemberRepository;
import com.Shop.Service.MemberService;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class CartTest {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PersistenceContext
	EntityManager em;
	
	public Member createMember() {
		MemberFormDTO member = new MemberFormDTO();
		member.setName("MemberName");
		member.setEmail("testing@t");
		member.setPassword("1234");
		member.setAddress("서울시 논현역");
		return Member.createMember(member, passwordEncoder);
	}
	
	@Test
	@DisplayName("CartMappingTest")
	public void findCartAndMemberTest() {
//		임의로 생성한 멤버객체를 저장한다.
		Member member = createMember();
//		save() 함수는 이미 있는 데이터라면 변화를 update, 없다면 insert 해준다.
		memberRepository.save(member);
		Cart cart = new Cart();
//		생성된 카트에 지정한 멤버객체를 연결한다. 
		cart.setMember(member);
//		테이블에 저장을 하는데 이때는 어노테이션으로 인해서 자동으로 member_id 컬럼을 FK로 저장...하는거겠지
		cartRepository.save(cart);
		
//		위에서 실행한 .save()에서 생성하는 update, insert문은 실행되지 않은 상태로 영속성 컨텍스트에 임시 저장되어 있고
//		그걸 flush로 한꺼번에 실행을 한다. 시점은 트랜잭션의 마지막단계. flush 는 자동으로 sql을 실행후 commit을 한다. 
//		여기서 DB에 반영
		em.flush();
//		실행한 후, 영속성 컨텍스트에서 엔티티를 빼준다.
//		후에 장바구니 엔티티를 불러올때, 자동으로 회원 엔티티로 불러오는지 테스트하기 위함.
		em.clear();
		
//		.findById() 반환타입이 java 8부터 제공하는 Optional 객체인데 예외가 발생했을경우 if 사용없이 처리할 수 있도록 해준다.
//		예외가 발생할것 같은 객체를 Optional 객체로 처리한 후, 예외처리를 람다식으로 지정할 수 있는것 같은데.
//		.orElseThrow(); Optional 객체에서 예외를 처리하기 위한 메소드.
//		괄호안에 발생할것 같은 예외객체를 생성해서 지정하면, 해당 예외가 발생했을때 throw 를 해준다.
//		::new....는.....생성자를 나타내는 람다...식?
//		이외에도 .orElse(파라미터) 로 throw가 아니라 예외발생시 미리 생성되어 있던 파라미터를 반환할 수도 있고
//		orElseGet() 으로 예외발생시 지정한 파라미터를 생성하여 반환할수도 있다.
//		위 두개의 차이는 반환할 파라메터를 미리 생성하느냐의 차이인듯?
		Cart savedCart = cartRepository.findById(cart.getId()).orElseThrow(EntityNotFoundException::new);
		
		assertEquals(savedCart.getMember().getId(), member.getId());
	}

}
