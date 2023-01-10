package com.Shop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Shop.Entity.Item;

// DAO의 역할을 해주는 인터페이스를 사용하게 된다.
// 이 리포지토리 인터페이스가 상속받는 JpaRepository는 엔티티클래스, 해당 엔티티의 기본속성 데이터타입 형을 지정한다.
// 여기서 기본속성 데이터타입은 해당 엔티티에서 @Id로 지정한 필드의 데이터타입이다.
// 이 JpaRepository 에는 기본적인 CRUD, Pagination 를 위한 메소드가 포함되어 있다.
public interface ItemRepository extends JpaRepository<Item, Long> {
//	Repository 인터페이스가 지원하는 네이밍 룰을 이용해 메소드를 작성하면 지정된 select 문을 간단하게 실행할 수 있다.
//	기본적으로 find+엔티티이름(생략가능)+By+변수이름() 이다.
//	변수이름은 쿼리메소드의 네이밍 룰을 참조.
	List<Item> findByItemName(String itemName);
	List<Item> findByPriceGreaterThan(int num);
	List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);
}
