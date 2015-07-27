package com.bbs.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * (1)@Data
 * -> 이 애너테이션을 붙이면 컴파일할 때 각 필드의 세터(setter)/게터(getter)와 toString(),
 * -> equals(),hashCode()메서드가 생성됨.
 * (2)@NoArgsConstructor
 * ->JPA의 명세에 엔티티 클래스는 인자를 받지 않는 기본 생성자를 만들어야 하기 때문에 사용
 * (3)@AllArgsConstructor
 * -> 롬복이 제공하는 @AllArgsConstructor 애너테이션을 붙여서 모든 필드를 
 * -> 인자로 받는 생성자를 만든다.
 * (4)@Entity
 * -> @Entity 애너테이션을 붙여서 JPA 엔티티임을 표시한다.
 * (5)@Table(name="")
 * -> @Table 애너테이션을 붙이여 엔티티에 대응하는 테이블 이름을 지정한다. 
 * -> 기본적으로 테이블 이름을 클래스 이름과 동일하게 맞춤
 * (6)@Id
 * -> 엔티티 클래스에는 인자를 받지 않는 기본 생성자를 만들어야 한다.
 * -> 롬복으로 기본 생성자를 만들려면 @NoArgsContrustor 애너테이션이 있어야한다. 
 * (7)@JsonIgnore
 * ->JPA와는 관계없지만 REST API로 User 클래스를 JSON 형식으로 출력할 경우,
 * ->암호필드를 제외하기 위해  @JsonIgnore을 붙인다.
 * */

@Data					//(1)
@NoArgsConstructor		//(2)
@AllArgsConstructor		//(3)
@Entity					//(4)
@Table(name="user")		//(5)
public class User {
	@Id					//(6)
	private String id;
	
	@JsonIgnore			//(7)
	private String password;
}
