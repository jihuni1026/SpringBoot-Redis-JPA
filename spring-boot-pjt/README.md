# Shortening URL 제공, Redirect 처리 서비스.


> 서비스 개발 내용.

[과제내용]
- URL 입력폼 제공 및 결과 출력.
- URL Shortening Key는 8 Character 이내 생성.
- 동일 URL 요청은 동일한 Shortening Key로 응답.
- 동일 URL에 대한 요청 수 정보 보관.
- Shortening된 URL을 요청받으면 원래 URL로 Redirect 처리.
- Database 사용은 필수는 아님.
  
[가산점]
- Unit Test 및 Intergration Test 작성.
  
[결과물]
- Github 소스제공 ([Github 주소](https://github.com/jihuni1026/SpringBoot-Redis-JPA))
- Readme에는 해당 웹서버를 리눅스 기준으로 실행하기 위해 필요한 설치/빌드 방법 작성


> 서비스 개발 환경.

프로젝트 개발 환경은 다음과 같습니다.
- IDE : VSCode
- Git Tools : Source Tree
- OS : Window10
- SprinBoot : 2.3.3
- JDK 1.8
- Gradle
- Redis
- 화면구성 : Mustache, Bootstrap, JQuery ...


> 설치/빌드 방법 (리눅스 기준).

[사전작업]
- JDK 1.8 설치
- Tomcat 8.5 이상 설치
- Redis 설치

### 1. Git 설치
```c
#git version 및 설치 확인
git --version

#git 설치
yum install git
```

### 2. GitHub 소스 Clone
```c
git clone https://github.com/jihuni1026/SpringBoot-Redis-JPA.git
```

### 3. War 파일 생성
```c
# Clone한 소스로 이동 후 build
./gradlew build

# ../build/lib 경로에 war파일 생성 확인
```

### 4. War 파일 배포
```c
# 설치한 Tomcat 경로 webapps에 war 파일 배포
```
