# Spring FrameWork
수업에서는 이클립스와 Maven을 사용함.  
이클립스의 MarketPlace 에서 Spring Tools 를 설치 후, Spring IO 사이트에서 간단하게 초기화 작업을 진행할 수 있다.  
[Spring IO](https://start.spring.io/)  

### IoC (Inversion of Control)
제어의 역행. 기존의 java 에서는 main() 메소드에서 실행에 필요한 모든 객체의 생성, 호출을 진행하지만 제어의 역행이 적용되는 프로그램은 해당 행위를 다른곳에 위임하는 형태를 취한다.  
스프링의 경우 스프링 컨테이너가 필요한 객체생성, 메소드 호출을 각각 다른곳으로 위임해서 실행하는?  

### Lombok Lib
Java 사용시 계속해서 반복사용하게 되는 getter/setter 등의 주요 메소드의 사용을 줄여주는 라이브러리. 반복적인 코드들을 어노테이션으로 사용할 수 있게 해준다.  
DI로 jar만 추가해서는 사용할 수 없고 lombok의 jar 파일을 실행시켜서 사용하는 IDE를 지정하여 설치를 진행해주어야 한다.

### H2 DB
가볍네. 웹에서 바로 보이는듯? 테스트운용으로 자주 쓰이는듯하다.

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