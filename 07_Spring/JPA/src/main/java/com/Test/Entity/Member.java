package com.Test.Entity;

import java.util.Date;
import com.Test.Constant.MemberClass;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

// JPA의 Entity 클래스. JSP의 DTO와 같은 기능을 하는 클래스이다.
// javax.persistence 패키지를 불러와 어노테이션으로 선언하여 사용한다.
// 사용할때 persistence 의 여러 패키지를 같이 사용하는 일이 많은지 * 으로 쓰는게 좋은듯???
@Getter
@Setter
@Entity
public class Member {
	
//	지정한 필드를 JPA 엔티티 객체의 식별자로 사용하겠다는 선언. PK선언.
	@Id
//	DB에서 해당 필드를 지정한 name값을 이름으로가지는 컬럼으로 사용한다는 선언.
//	어노테이션 속성으로 이름을 설정하지 않았을경우에는 필드의 이름을 자동으로 인식해서 지정한다.
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
//	만약 필드에 열거형데이터 Enum을 사용할경우 사용하는 어노테이션.
	@Enumerated(EnumType.STRING)
	@Column
	private MemberClass MemberClass;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
}
