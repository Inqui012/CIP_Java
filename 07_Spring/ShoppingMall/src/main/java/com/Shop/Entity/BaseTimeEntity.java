package com.Shop.Entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.*;

@Getter
// 이 클래스에 auditing 적용을 지정하는 어노테이션. 해당 엔티티가 em 에 persist, remove, update, load 되어 질때의
// 전 후에 콜백 메소드를 진행한다.
@EntityListeners({AuditingEntityListener.class})
// 해당 클래스를 상속받는 자식 클래스에게 매핑 정보만 제공한다. 엔티티로서 취급은 안되고 자식에게 생성되어 있는 필드의 정보만을 주는 느낌?
@MappedSuperclass
public class BaseTimeEntity {
//	updatable. 해당 컬럼의 데이터가 수정이 가능한지의 여부. 등록은 가능하나 이후의 수정은 불가능하다.
	@Column(updatable = false)
//	Auditing 에서 생성된 날짜를 해당 필드에 지정한다는 어노테이션.
//	엔티티가 생성되어 저장될때의 시간을 자동으로 지정된 필드에 저장한다.
	@CreatedDate
	private LocalDateTime regTime;
	
	@LastModifiedDate
	private LocalDateTime upDateTime;
	
}
