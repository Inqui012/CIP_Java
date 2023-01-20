package com.Shop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.Shop.Entity.Item;

// DAO의 역할을 해주는 인터페이스를 사용하게 된다.
// 이 리포지토리 인터페이스가 상속받는 JpaRepository는 엔티티클래스, 해당 엔티티의 기본속성 데이터타입 형을 지정한다.
// 여기서 기본속성 데이터타입은 해당 엔티티에서 @Id로 지정한 필드의 데이터타입이다.
// 이 JpaRepository 에는 기본적인 CRUD, Pagination 를 위한 메소드가 포함되어 있다.
// QuerydslPredicateExecutor<Item>, ItemCustomRepository 는 페이징을 이용한 게시판형식의 출력을 위해 상속받는다.
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>, ItemCustomRepository {
//	Repository 인터페이스가 지원하는 네이밍 룰을 이용해 메소드를 작성하면 지정된 select 문을 간단하게 실행할 수 있다.
//	기본적으로 find+엔티티이름(생략가능)+By+변수이름() 이다.
//	변수이름은 쿼리메소드의 네이밍 룰을 참조.
	List<Item> findByItemName(String itemName);
	List<Item> findByPriceGreaterThan(Integer num);
	List<Item> findByPriceGreaterThanOrderByPriceDesc(Integer num);
	List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);
	
//	JPQL. 메소드에서 실행할 쿼리를 직접 지정할 수 있다.
//	주의할점은 DB에 생성되는 테이블이 아니라 지정한 엔티티를 대상으로 쿼리문을 작성해야 한다는것.
//	컬럼명을 엔티티에 설정해준 이름대로 해야한다. 소문자로 작성한 부분이 엔티티를 대상으로 하는 부분.
//	대소문자 구분함. 메소드에서 넘겨오는 매개변수를 쿼리문에 사용할경우 받아오는 매개변수를 @param을 이용해 파라메터로 설정해야하고
//	JPQL 구문 안에서 설정한 파라메터를 불러올 때는 :파라메터명 으로 불러온다.
	@Query("SELECT I FROM Item I WHERE I.itemDetail LIKE %:itemDetail ORDER BY I.price DESC")
	List<Item> findByItemDeail(@Param("itemDetail") String itemDetail);

//	아래처럼 파라메터를 순서로 찾아가도록 지정할수도 있지만 코드의 가독성을 이유로 권장되지 않는다.
//	@Query("SELECT I FROM Item I WHERE I.itemDetail LIKE %?1 ORDER BY I.price DESC")
//	List<Item> findByItemDeail2(String itemDetail);
	
//	속성으로 nativeQuery 설정을 줄 수 있다. 이경우 사용하는 DB에서 실행가능한 쿼리문을 바로 지정해줄 수 있다.
//	이경우는 DB에서 직접 쿼리문을 작성하는것과 동일하게 테이블명과 컬럼명을 테이블에 맞추어주어야한다.
	@Query(value = "SELECT * FROM ITEM I WHERE I.ITEM_DETAIL LIKE '%:itemDetail' ORDER BY I.PRICE DESC", nativeQuery = true)
	List<Item> findByItemDeailNative(@Param("itemDetail") String itemDetail);
	
	
}
