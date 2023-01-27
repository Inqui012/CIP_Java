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

#### @Genarated import 오류.
자동으로 Q클래스를 생성하면서 @Generated 어노테이션을 잘못된 경로에서 import 해와서 오류가 생긴다.
javax.annotation.Generated 가 올바른 경로인데 javax.annotation.proccessing.Generated 에서 가져올때,  
Maven 의 Pom.xml 의 QueryDsl 플러그인을 아래처럼 변경하니 해결됨.  
문제해결에 참조한 github => [java build failed](https://github.com/redhat-developer/vscode-java/issues/2799)  
```xml
<plugin>
  <groupId>com.mysema.maven</groupId>
  <artifactId>apt-maven-plugin</artifactId>
  <version>1.1.3</version>
  <executions>
    <execution>
      <goals>
        <goal>process</goal>
      </goals>
      <configuration>
	      <outputDirectory>target/generated-sources/java</outputDirectory>
	      	<processors>
		    	<processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
		    </processors>
		    <options>
			    <querydsl.generatedAnnotationClass>
                    javax.annotation.Generated
                </querydsl.generatedAnnotationClass>
			</options>
           </configuration>
    </execution>
  </executions>
</plugin>
```


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
1. DispatcherServlet(Front Controller) 에서 우선 HandlerMapping 으로 사용자의 요청에 맞는 컨트롤러를 찾는다.
2. 찾아낸 Controller 는 기능에 맞는 service 객체를 호출하여 아래의 작업을 수행한다.
    1. service 객체로 찾아가 필요할경우 DB와 정보를 주고받을 Repository 객체를 사용한다.
    2. DB에서 받아온 정보를 가공하는 과정을 수행한다. 이것을 비즈니스 로직을 수행한다고 한다.
    3. 가공된 정보를 다시 Controller 에게 넘겨준다.
3. ViewResolver 에서 컨트롤러의 처리결과를 생성할 페이지를 찾아 화면을 생성하여 결과화면을 리턴한다.  
컨트롤러를 조금 더 나눠서 작업하는 느낌?  
스프링 시큐리티는 이 클라이언트와 DispatcherServlet 의 사이에서 요청을 가로채 인증과 인가작업을 하는 서블릿 필터를 거치게 만드는 느낌인가봐. 

### Cookie
사용자(브라우저) 에 저장되는 키와 값으로 되어있는 데이터.  
해당 쿠키가 유효한 기간을 정할 수 있으며, 브라우저에 저장되는 특성상 한 번 브라우저를 종료해도 유지가 된다. 이 쿠키는 브라우저당 300개 까지 저장되며 하나의 도메인당 20개의 값이 한계이다.  
1. 사용자가 페이지를 요청한다.
2. 요청을 받은 서버는 쿠키를 생성하여 정보를 담아 HTTP 헤더에 포함하여 응답.
3. 사용자에게 보이지는 않지만 응답과 함께 받은 쿠키를 브라우저가 로컬PC에 저장한다.
4. 해당 사이트 방문시 로컬에 저장되어 있는 쿠키를 요청과 함께 보내며 서버에서는 이 쿠키를 확인하여 인증을 한다.  

### Session
쿠키와 달리 사용자 정보 파일을 세션ID 를 부여하여 서버에서 관리한다.  
서버에서 관리하기 때문에 브라우저가 서버에 요청을 했을 때 부터 브라우저가 종료될때까지 인증상태를 유지하게 된다. 기본적으로 30분의 제한시간을 가지고 있어 일정시간동안 응답이 없을경우 자동으로 인증을 파기한다.  
쿠키보다는 보안에 강하지만 서버에서 관리하는 특성상 세션을 남발할경우 서버의 부하가 증가할 수 있다.  
1. 사용자가 로그인을 할 경우 서버에서 해당 사용자가 존재하는지를 확인하고, 존재할경우 세션ID를 생성하여 해당 사용자의 정보를 저장한다.
2. 사용자의 쿠키에 세션ID를 저장하도록 한다.
3. 사용자가 서버로 요청을 보낼때, 요청과 함께 보내지는 쿠키를 확인하고, 쿠키에 저장되어 있는 세션ID 와 서버측의 ID를 대조하여 인식한다.

### 연관관계 매핑
DB의 JOIN 문을 스프링에서 처리하는 방식? 엔티티와 엔티티와의 상관관계를 정의하여 JOIN 처럼 사용한다.  
```JAVA
@OneToOne   (일대일)
@OneToMany  (일대다)
@ManyToOne  (다대일)
@ManyToMany (다대다)
```
네 종류가 있는데 다대다의 경우 보통은 중간에 교차용 테이블을 생성하기 때문에 거의 안쓰게 된다.  
  
DB 테이블에서는 항상 양방향 관계를 가지지만 JAVA 등의 객체에서는 단방향, 양뱡향이 동시에 존재한다.  
양방향 관계라는것은 FK 를 이용해서 두개의 테이블에서 동시에 데이터를 조회할 수 있는 상황? 을 말한다. DB에서는 당연한 일이지만 Spring 의 Entity 에서는 따로 설정하지 않는이상 이것이 불가능함.  
자식이 되는 Entity에만 부모와의 관계를 설정하기 때문에 부모Entity 에서 따로 설정하지 않으면 자식 Entity를 참조할 수 없다. 이 상황에서 양방향 관계를 설정하기 위해서는 자식과 부모 양쪽에 관계를 설정해야 하는데, FK는 여전히 하나의 컬럼만을 가지기 때문에 두 엔티티의 어느쪽에서 해당 FK를 관리할지 설정해야한다.  
FK의 관리(등록, 수정, 삭제) 엔티티 = 연관관계의 주인 이라고 하고, 보통 FK를 선언하는 쪽이 관리권한을 가진다.  
주인이 아닌쪽의 엔티티는 mappedBy 속성으로 주인이 누구인지를 표시하고, 이곳에서는 해당 값을 읽을수만 있다.  
  
양방향이 하나의 FK로 두 테이블을 조회할 수 있다고 편하게 생각할 수도 있지만, 모든 엔티티를 양방향으로 구성할경우 너무 많은 테이블이 연관관계를 가지게 되기 때문에 꼭 필요한 경우에만 사용하는것이 좋다.  
  
```java
class A {
    B instance;
}
class B {}
```
위 예시 처럼 한쪽 객체에서 다른쪽 객체를 참조하는데, 다른쪽에서는 그렇지 않을경우를 단방향.  
  
```java
class A {
    B instance;
}
class B {
    A instance;
}
```
위 예시 처럼 서로의 객체를 참조할경우 양뱡향이라고 한다.  
  
### 영속성 전이 Cascade
엔티티의 수정사항을 해당 엔티티와 연관된 다른 엔티티에도 적용하는 옵션. 관계성으로 묶여있는 테이블 사이에서 테이블을 연동시키는... 느낌?  
만약 부모 엔티티가 삭제된다면 해당 엔티티에서 값을 참조해 FK 를 가지고 있는 자식 엔티티를 함께 삭제하는 형식. 서로 연관된 엔티티를 함께... 움직인다? 수정한다?  
해당 속성은 위에서 나온 연관관계 매핑에 사용하는 어노테이션에서 설정한다. 내용을 보니 영속성 컨텍스트(persistance context)에 넣고빼는 등의 행위에 대한 설정을 하는것 같음. sql 쿼리가 같이가는...느낌? 기준이 부모객체가 ~를 할때, 인것을 보면 부모가 되는 객체의 @ 에 설정을 넣어줌.  
종류는 아래와 같은데 무분별하게 사용할경우 테이블이 엉망이 될 수도 있을 것.... 같으니 사용하는 경우는 한정되는듯.  
* PERSIST  
* MERGE    
* REMOVE   
* REFRESH   
* DETACH
* ALL

### 지연로딩
엔티티를 조회할때, 연관관계를 가지고 있는 엔티티를 전부 가져오게 되는것을 즉시로딩이라고 한다. 엔티티의 갯수가 적을때에는 문제가 없지만 양이 늘어날수록 쓸모없는 데이터의 로딩을 하게되어 낭비가 심해진다.  
이를 방지하기 위해 사용하는것이 지연로딩이다. 관계성을 설정한 어노테이션의 속성으로 fetch = FecthType.LAZY 를 설정해주면 되는데, 이러게 할 경우 처음에는 Proxy 라는 가상의 객체를 불러오고, 해당 필드에 지정되어 있는 데이터가 실제로 필요한 시점에 DB로 조회를 시작하여 데이터를 가져온다.
  
### 비동기 통신, Ajax
페이지의 새로고침 없이 서버와의 통신을 통해 화면을 갱신하는것을 비동기 통신이라고 한다.  
자바 스크립트에서 동작하는 Ajax 를 자주 사용하게 된다. 기본형식은 아래와 같고 여러가지 세팅을 통해 세부적인 조정이 가능하다.  
[JQuery 의 Ajax()](https://api.jquery.com/jquery.ajax/)
```javascript
$.ajax({
  url : 요청을 보낼 주소값,
  (settings 여러 설정들)
})
```

### 성능향상을 위한 설정?
```xml
spring.jpa.properties.hibernate.default_batch_fetch_size=1000
```
반복문 안에서 SELECT 로 쿼리를 실행할 때, 리스트가 클 수록 같은 쿼리문을 계속해서 반복하는것이 효율적이지 않다.  
이럴경우 위의 설정을 해주게 되면 쿼리문이 IN (조건) 절로 변경되어 한번의 쿼리문으로 반복적인 실행을 방지할 수 있다.git