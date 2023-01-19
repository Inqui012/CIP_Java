package com.Shop.Entity;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.*;

@Getter
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public class BaseEntity extends BaseTimeEntity {
	@Column(updatable = false)
	@CreatedBy
	private String createBy;
	
//	마지막으로 수정한 사용자의 이름을 저장한다.
	@LastModifiedBy
	private String modifiedBy;
}
