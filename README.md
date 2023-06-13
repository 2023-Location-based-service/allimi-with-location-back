# 요양원 알리미 서비스 with 위치기반

위치기반서비스 '요양원 알리미 + 요양원 둘러보기 앱' 백엔드 리포지토리입니다<br/>
요양원 알리미 GitHub 주소는 아래와 같습니다.<br/>
https://github.com/2023-CreativeDesignProject-clover/care-allimi-back <br/>

## 기존 프로젝트와 다른점
- 요양원 둘러보기 기능 추가
- 요양원 등록 기능 수정
<br/><br/>

## 개요
### 목적


### 사용 언어


## 디렉터리 구조
```
├─main
│  ├─generated
│  ├─java
│  │  └─kr
│  │      └─ac
│  │          └─kumoh
│  │              └─allimi
│  │                  ├─controller
│  │                  ├─domain
│  │                  ├─dto
│  │                  ├─exception
│  │                  ├─repository
│  │                  ├─s3
│  │                  └─service
│  └─resources
│      ├─static
│      │  ├─css
│      │  └─js
│      └─templates
│          └─fragments
└─test
    └─java
        └─kr.ac.kumoh
            └─allimi
                ├─controller
                ├─domain
                └─service
```

### main/java 패키지
#### controller
- 매핑된 url에 해당하는 요청을 받는다.
- POST 매핑의 경우 Body로 DTO를 받는다.
- GET 매핑의 경우 PathVariable로 값을 받는다.
- Controller는 비지니스 로직을 처리하는 Service의 함수를 호출한다. 

#### service
- 비즈니스 로직을 처리한다.
- 입력으로 받은 데이터에 필요한 데이터가 있는지 확인하는 검증 작업을 수행한다.
- 수행에 문제가 발생하면 Exception을 발생시킨다.

#### repository
- 데이터베이스에 매핑되는 Entity 객체에 대해 CRUD 작업을 수행한다. 
- JpaRepository라는 스프링에 이미 정의된 인터페이스를 사용한다.
- Repository의 함수 이름과 SQL문이 매핑되어 데이터베이스 쿼리문이 생성된다.

#### domain
- 데이터베이스 테이블과 직접적으로 매핑되는 객체들이다.
- 내부에 static으로 자신을 생성하여 반환하는 생성메서드가 존재한다.

#### dto
- 필요한 데이터를 받을 수 있는 DTO들이 포함되어 있다. 

#### exception
- 발생한 xception을 받아서 처리해주는 역할을 한다.
- 문제 상황에 맞는 HTTP Status를 응답한다.

#### s3
- AWS S3에 파일을 저장할 때 필요한 파일들이 포함되어 있다.

### main/resource 패키지
- 관리자 페이지를 위한 템플릿 엔진 HTML 코드가 포함되어 있다.
- Thymeleaf 템플릿 엔진을 사용한다.
- static 폴더에는 BootStrap 코드가 포함되어 있다.
- application.yml은 설정 파일으로, 데이터베이스 커넥션 비밀번호 등이 포함되어 있다.

### test 패키지
- main 코드에 대한 테스트 코드가 포함되어 있다.


