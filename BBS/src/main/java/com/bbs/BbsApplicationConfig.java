package com.bbs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*
 *(1)@Component
 *-> 이 애너테이션을 붙여 이 클래스가 JavaConfig용 클래스임을 컴파일러한테 알림
 *
 *(2)@Autowired
 *-> DI 컨테이너가 주입해야할 필드를 의미
 *-> DI 컨테이너는 관리하고 있는 객체 중에서 @Autowired 애너테이션이 붙은 필드에 
 *-> 맞는 객체를 자동으로 찾아내어 주입함.
 *
 *(3)
 *-> 스프링 데이터가 제공하는 데이터 소스용 팩토리 클래스를 사용하여 DataSource 인스턴스를 생성.
 *
 *@Bean
 *-> DI 컨테이너가 관리할 Bean을 생성하는 메서드에는 @Bean 애너테이션을 붙임
 *-> 기본으로 메서드 이름이 Bean이 된다.
 *-> 기본적으로 이 메서드가 생성한 인스턴스가 싱글톤이 되며, DI 컨테이너별로 인스턴스 한 개가 생성된다.
 * */

@Component		//(1)
public class BbsApplicationConfig {
	@Autowired	//(2)
	DataSourceProperties properties;	//(3)
	DataSource dataSource;
	
	@Bean		//(4)
	DataSource realDataSource(){
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.properties.getClassLoader())
				.url(this.properties.getUrl())
				.username(this.properties.getUsername())
				.password(this.properties.getPassword());
		this.dataSource = factory.build();
		return this.dataSource;
	}
}
