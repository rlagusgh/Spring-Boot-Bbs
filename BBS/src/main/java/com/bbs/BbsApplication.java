package com.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/*
 *(1)@EnableAutoConfiguration
 *-> 이 애너테이션을 붙으면 다양한 설정이 자동으로 수행되고 
 *-> 기존의 스프링 애플리케이션에 필요했던 설정파일이 필요 없게 된다.
 *
 *(2)@ComponentScan
 *-> 이 애너테이션을 붙이면 이 클래스의 패키지 내부에 있는 모든 클래스를 검색한다.
 *-> 대상 패키지를 변경하려면 basePackages 속성에 패키지를 지정한다.
 *
 *(3)SpringApplication.run(BbsApplication.class, args);
 *-> 스프링 부트 애플리케이션을 실핸하는데 필요한 처리를 main() 메서드안에 작성한다. 
 *-> @EnableAutoConfiguration 애너테이션이 붙은 클래스를 
 *-> SpringApplication.run() 메서드의 첫 번째 인자로 지정한다.
 * */

@EnableAutoConfiguration	//(1)
@ComponentScan				//(2)
public class BbsApplication {
    
	public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);	//(3)
    }
}
