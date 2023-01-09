# Spring FrameWork
수업에서는 이클립스와 Maven을 사용함.  
이클립스의 MarketPlace 에서 Spring Tools 를 설치 후, Spring IO 사이트에서 간단하게 초기화 작업을 진행할 수 있다.  
[Spring IO](https://start.spring.io/)  

### IoC (Inversion of Control)
제어의 역행. 기존의 java 에서는 main() 메소드에서 실행에 필요한 모든 객체의 생성, 호출을 진행하지만 제어의 역행이 적용되는 프로그램은 해당 행위를 다른곳에 위임하는 형태를 취한다.  
스프링의 경우 스프링 컨테이너가 필요한 객체생성, 메소드 호출을 각각 다른곳으로 위임해서 실행하는?  

#### Lombok Lib
Java 사용시 계속해서 반복사용하게 되는 getter/setter 등의 주요 메소드의 사용을 줄여주는 라이브러리. 반복적인 코드들을 어노테이션으로 사용할 수 있게 해준다.  
DI로 jar만 추가해서는 사용할 수 없고 lombok의 jar 파일을 실행시켜서 사용하는 IDE를 지정하여 설치를 진행해주어야 한다.