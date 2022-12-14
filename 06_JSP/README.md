# JSP
#### 용어
* Web Server
해당 서버가 가동하고 있는 물리적 컴퓨터  
클라이언트로부터 HTTP 요청을 받고 컨텐츠를 제공하는 컴퓨터 프로그램의 기능  
  
* WAS
HTTP 프로토콜을 통해 DB조회, 로직을 처리하는 등의 기능을 수행하는 미들웨어.  
Web Container / Servlet Container 라고도 한다.  
Container 는 JSP, Servlet을 실행시킬 수 있는 소프트웨어를 지칭함.  
  
### 지시어 (Page, Include, Taglib ...)
```
<%@ page 
language="스크립트언어" 
contentType="파일형식 response HTTP헤더정보" 
pageEncoding="컨테이너에서 사용할 캐릭터 인코딩" 
import="파일 내에서 직접사용할 java 클래스" 
errorPage="에러가 발생했을 경우 처리할 페이지"
>
```
해당 JSP 페이지를 컨테이너(서블릿) 에서 처리할 때 필요한 각종 속성을 입력한다.

```
<%@ include 
file="파일경로"
>
```
해당 JSP 에 다른 파일을 포함한다.  
컨터이너에서 해당 JSP 를 처리할때 포함된 다른 모든 파일을 합쳐서 하나로 인식한다.  

### 스크립트 요소
JSP 에서 JAVA 와 HTML 을 동시에 사용할 수 있게 해주는 코드. 현재는 거의 사용하고 있지 않음.  
```
<%! JAVA 변수선언 %>
<%= 메소드호출, 출력, 연산 %>
<% 모든 JAVA 코드 %>
<!-- HTML 주석. 화면의 소스에만 보임 -->
<%-- JSP 주석. 화면의 소스에도 보이지 않음. --%>
```
