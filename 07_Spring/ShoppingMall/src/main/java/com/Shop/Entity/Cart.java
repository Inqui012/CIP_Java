package com.Shop.Entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@Table(name = "cart")
@Entity
public class Cart {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	참조키를 생성하는 방법. 참조할 엔티티(테이블)을 생성하여 @JoinColumn 어노테이션을 사용한다.
//	이 어노테이션은 테이블간의 연관관계를 설정할때 사용하는것 같은데
//	속성인 name 은 지정한 엔티티 Member 에서 참조해올 컬럼을 엔티티 cart 상에서 어떤 이름으로 표시할것인지 설정.
//	referencedColumnName 속성이라는게 있는데, 이걸로 부모가 되는 엔티티에서 어떤 컬럼을 참조할것인지를 지정할 수 있다.
//	설정하지 않으면 기본값으로 부모의 PK 값을 자동으로 참조해와서 FK 로 사용하는듯.
	@JoinColumn(name = "member_id")
//	엔티티 Memeber 와 Cart 의 관계가 일대일임을 지정함.
//	Member 가 부모, Cart 가 자식. 연관관계 지정은 자식이 될 엔티티(테이블)에서 설정해준다.
	@OneToOne
	private Member member;
}
