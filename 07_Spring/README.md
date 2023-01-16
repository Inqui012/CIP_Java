# Spring FrameWork
수업에서는 이클립스와 Maven을 사용함.  
이클립스의 MarketPlace 에서 Spring Tools 를 설치 후, Spring IO 사이트에서 간단하게 초기화 작업을 진행할 수 있다.  
[Spring IO start](https://start.spring.io/)  

### IoC (Inversion of Control)
제어의 역행. 기존의 java 에서는 main() 메소드에서 실행에 필요한 모든 객체의 생성, 호출을 진행하지만 제어의 역행이 적용되는 프로그램은 해당 행위를 다른곳에 위임하는 형태를 취한다.  
스프링의 경우 스프링 컨테이너가 필요한 객체생성, 메소드 호출을 각각 다른곳으로 위임해서 실행하는?  
```java
Object obj = new Object();
```
일반적인 방법으로 객체를 사용하려면 new 키워드로 객체를 생성하는 과정이 매번 필요하게 되지만 이렇게 되면 유지보수면에서 불리하고, 객체지향적 개발에서 권장하는 '개방 폐쇠 원칙(OCP)(코드의 확장에는 편리하고, 기존 코드의 수정에는 닫혀있다)' 과 모순되기 때문에 나타난 개념이다.  
객체가 필요한 곳에서 생성하는것이 아닌 이미 생성되어 있는 객체를 필요에 의해 가져와서 사용하는 방식.  
이 객체를 생성하고 관리하고 있는곳이 APP의 실행과 함께 생성되는 Spring Container 이다.  
이렇게 컨테이너에서 관리하고 있는 객체들을 Bean 이라고 함. 보통은 자동으로 되는것 같은데, 수동으로 컨테이너에 관리할 객체를 추가할경우 @Bean, @Configuration 어노테이션을 사용한다.  
하나의 클래스에서 여러개의 @Bean을 사용할경우 싱글톤(단 한개만의 객체를 생성하여 사용)을 보장하기 위해서는 @Configuration 을 명시해야 함. 보통 두개를 같이 쓴다고 생각하면 된다.  

### Lombok Lib
Java 사용시 계속해서 반복사용하게 되는 getter/setter 등의 주요 메소드의 사용을 줄여주는 라이브러리. 반복적인 코드들을 어노테이션으로 사용할 수 있게 해준다.  
DI로 jar만 추가해서는 사용할 수 없고 lombok의 jar 파일을 실행시켜서 사용하는 IDE를 지정하여 설치를 진행해주어야 한다.

### H2 DB
가볍네. 웹에서 바로 보이는듯? 테스트운용으로 자주 쓰이는듯하다.  
[H2 DataBase](https://www.h2database.com/html/main.html)  

### MySql
오라클과는 조금씩 다름. 스키마(Database)를 생성하고, 해당 스키마를 생성하기 위해 use 커맨드를 사용.

### ORM (Object Relational Mapping)
DTO, DAO 가 데이터베이스의 형태나, 가져오는 데이터에 의존적임을 극복하기 위해서 나온 방법. 객체와 데이터베이스를 자동으로 매핑해주는 기술? 대표적으로 JPA가 있다.  
사용하는 데이터베이스에 따른 SQL의 변화등을 단순한 설정만으로도 간단하게 변환 가능하다.

### JPA
@Entity 로 선언한 클래스가 DTO의 역할을 대신하는 엔티티 클래스이다.  
어플리케이션 실행시 하나의 Entity Manager Factory 를 생성(Static)하고 요청이 있을경우 이곳에서 Entity Manager 를 생성한다.  
Entity Manager 는 요청이 있을때마다 다수 생성될 수 있으며 Entity 를 실제로 저장하고 있는 영속성 컨텍스트(Persistence Context)로 접근하여 DB작업을 실행한다.  
Persistence Context 는 엔티티를 영구 저장하는 장소.  
이처럼 쿼리문의 처리를 EMF가 대신 해주기 때문에 DAO의 사용에도 변화가 있다.  
[Spring Data JPA API](https://docs.spring.io/spring-data/jpa/docs/current/api/index.html)  

#### 엔티티의 생명주기

영속성 컨텍스트를 크게 두가지 구역으로 나뉘어서 생각하면 편하다.  
엔티티객체를 저장하는 1차캐시 저장소, 쿼리문 저장소.  
```java
EntityClass box = new EntityClass();
```
비영속 상태. 단순히 new 선언으로 엔티티 객체를 생성.  
  
```java
EntityManager.persist(box);
EntityTransaction.commit();
```
영속 상태. 비영속으로 생성만 되어 있던 객체를 엔티티 매니저가 영속상태로 변환한다.  
실제 실행은 commit() 에서 하고, 명령문을 준비하는 단계?  
컨텍스트에 객체를 저장하게 되면 캐시 저장소에 해당 객체를, 쿼리문 저장소에 Insert문을 준비.  
commit 이나 flush 가 실행되기 전까지는 데이터를 쌓아놓는 느낌이다.  
DB에서 Select 문으로 가져오는 값들도 엔티티로 저장되어진다.  
  
```java
EntityManager.close();
EntityManager.detach(box);
EntityManager.clear();
```
준영속 상태. 조금씩 다르지만 결과적으로는 모두 엔티티를 비활성 상태로 바꾼다. 영속성 컨텍스트에 저장되어 있는 엔티티를 비활성화로 바꾼다고 생각하면 편한가.  
컨텍스트 내부에서 삭제되는것은 아니고 분리만 시켜놓고 있는 상태. 비활성화 상태라 영속성 컨텍스트가 제공하는 기능을 사용하지 못한다. 비영속과의 차이점으로는 식별자의 존재여부?  
detach 는 특정 객체만을 영속성 컨텍스트에서 준영속 상태로 만든다.  
clear 는 영속성 컨텍스트가 가지고 있는 모든 엔티티를 준영속 상태로 만든다.
close 는 영속성 컨텍스트가 사라지는 개념. 엄밀히 말하면 엔티티 매니저를 종료하는 개념이다.  
이 상태의 엔티티들을 .merge()로 다시 영속상태로 바꿀 수 있음.  

```java
EntityManager.remove(box);
```
삭제. 영속성 컨텍스트에서 해당 객체를 삭제한다. DB의 데이터는 남아있네.  
persist 와 같은 개념. 영속성 컨텍스트에서 객체를 삭제하고 DB에서도 삭제하기 위한 Delete 쿼리문을 준비하고 있게 된다. 이 이후에 commit을 사용하면 DB에서도 해당 객체가 저장했던 데이터가 삭제된다.

### JpaRepository<엔티티 객체, pk데이터타입>
JPA에서 DAO의 역할을 담당하는 클래스이다. DB작업이 필요한 엔티티에 맞추어 인터페이스를 생성하고, 해당 클래스를 상속받아 사용하게 된다.  

### JPQL
리포지토리 에서 상속받아 네이밍규칙을 사용하면 간단하게 Sql 문을 메소드 형태로 사용할 수 있지만, 메소드명이 점점 길어긴다는 단점이 존재한다. 이런 단점을 보완하기 위해 사용하는 방법.  
쿼리문을 사용할 메소드에 @Query() 로 선언하며, 괄호 안에 문자열로 직접 사용할 쿼리문을 작성한다.

#### Querydsl
JPQL 을 사용하여 쿼리를 실행할시, 오류를 발견하기 위해서는 컴파일 시점까지 진행할 수밖에 없다. 이런 단점을 보완하고 빠르게 오류를 발견하기 위해 사용하는것이 QueryDsl이다. 의존성과 플러그인을 삽입하면 자동으로 각 엔티티에 맞춘 클래스를 생성해준다.  
[Querydsl API](http://querydsl.com/static/querydsl/latest/reference/html/index.html)  

### Thymeleaf
화면을 동적으로 만들기 위해서 사용하는 템플릿 엔진. 서버와의 통신을 통해 바로 View를 업데이트하는 React 같은 방식을 사용하기 위한 엔진인가?  
여러가지 엔진이 존재하지만 Spring 에서는 Thymeleaf 를 권장한다. JSTL과 비슷한 느낌?

### Bootstrap
스프링에서 사용할 수 있는 UI 라이브러리? 앞단을 편하게 만들 수 있게 도와준다.  
디자인을 편하게 할 수 있는 CSS 와 JS의 모음이라고 생각하면 좋을듯. 이미 디자인이 적용된 클래스명을 이용해서 간편하게 디자인을 만들어낼 수 있다.  
[Bootstrap](https://getbootstrap.com/)  

### 스프링 시큐리티
어플리케이션에서 사용하는 인증/인가 등의 보안 솔루션을 제공하는 라이브러리?  
인증은 리소스에서 작업을 실행할 수 있는지 사용자의 신원을 확인하는 작업이고, 인가는 인증과정 후에 일어나는 사용자의 권한을 확인하는 작업이다.  
시큐리티를 설치하고 따로 설정하지 않는 이상 모든 페이지에 접속하기 위해서는 우선 로그인창이 자동으로 생성된다. 기본 아이디는 user 이며, 비밀번호는 콘솔창에 표시된다.  

#### 스프링 시큐리티 필터
시큐리티에서 제공하는 서블릿 필터. 클라이언트의 요청에 대해 우선적으로 실행하게 되는... 무언가. 하나 이상으 필터를 순차적으로 연결하여 filter chain 을 구성한다.  
시큐리티 필터체인은 종류가 다양하지만 수업에서는 UsernamePassword AutherticaionFilter 만 사용하는듯.

##### UsernamePassword AutherticaionFilter
1. 사용자가 로그인정보(아이디, 비밀번호)와 함께 인증요청(로그인)을 한다.
2. servlet 으로 향하는 요청을 filter가 가로채어 로그인정보를 이용해 Token 을 생성하여 ProviderManager 로 전달한다.
3. ProviderManager 에서는 해당 정보를 등록된 Provider 에 조회하여 인증을 요구한다.
4. UserDetailsService 를 상속받은 Service 객체에서 받아온 정보를 통해 DB를 조회하고, 해당하는 사용자가 있을경우 해당 정보로 UserDetails 객체를 생성하여 반환한다.
5. Provider 에서 반환받은 UserDetails 를 로그인정보와 비교하여 인증을 진행하고, 완료되었을 경우 해당 정보를 담은 Authentication 객체를 반환한다.
...

### 스프링의 MVC
기본적으로는 Client > View <-> Controller > Model(DAO) > DB 의 MVC2 형태를 가지지만 스프링에서는 컨트롤러가 조금더 세분화해서 나눠진다.  
DispatcherServlet(Front Controller) 에서 우선 HandlerMapping 으로 클라이언트의 요청에 맞는 컨트롤러를 찾는 과정, 해당 컨트롤러에서 작업을 실행하는 과정, ViewResolver 에서 컨트롤러의 처리결과를 생성할 페이지를 찾는 과정 을 거쳐서 이후에 View 에 화면을 생성하여 결과화면을 리턴한다. 컨트롤러를 조금 더 나눠서 작업하는 느낌?  
스프링 시큐리티는 이 클라이언트와 DispatcherServlet 의 사이에서 요청을 가로채 인증과 인가작업을 하는 서블릿 필터를 거치게 만드는 느낌인가봐. 

