package com.musinsa.springbootpjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * [Shortening URL 제공, Redirect 처리 서비스]
 * - URL 입력폼 제공 및 결과 출력.
 * - URL Shortening Key는 8 Character 이내로 생성.
 * - 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답.
 * - 동일 URL에 대한 요청 수 정보 보관.
 * - Shortening된 URL을 요청받으면 원래 URL로 리다이렉트.
 * - Database 사용은 필수는 아님.
 * 
 * [가산점]
 * - Unit Test 및 Intergration Test 작성.
 * 
 * [결과물]
 * - Github 소스제공
 * - Readme에는 해당 웹서버를 리눅스 기준으로 실행하기 위해 필요한 설치/빌드 방법 작성
 */
@SpringBootApplication
public class SpringBootPjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPjtApplication.class, args);
	}

}
