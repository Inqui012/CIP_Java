<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Title</title>
</head>
<body>
	<h1>Starting JSP</h1>
	<hr>
	The time is 
	<%-- 서버와 연동한 jsp 파일에서는 <%= 자바 코드 %> 로 html 에 자바를 직접 띄울 수 있다. --%>
	<%=java.time.LocalDateTime.now()  %>
	<hr>
	<%! 
		int num;
		int calc(int a, int b) {
			return a + b;
		}
	%>
	<span> 
		calc(10,10) is = <%= calc(10,10) %> 
	</span><br/>
	<span>
		<%= num = 20 %>
	</span><br/>
	<span>
		<%= num += 10 %>
	</span>
	<hr>
	<!-- 메소드나 함수를 불러올때는 =을, 직접 코드를 작성할 경우에는 없이 그냥 쓰는듯? -->
	<!-- 대괄호를 jsp 스크립트 요소로 감싸서 html 태그와 조합하여 사용할 수 있다.  -->
	<!-- 그냥 for 문 안에서 println 으로 모든 태그를 스트링 형식으로 입력해놓을 수도 있음-->
	<ul>
	<% for(int j = 1; j < 10; j++){ %>
	    <li><%= j %></li>  
	<% }%>	
	</ul>
	<hr>
	<!-- 인클루드로 jsp 를 불러오면 meta, title 태그도 같이 가져오네. 나머지는 없고. -->
	<%@ include file="/Including.jsp" %>
	<hr>
	<!-- page 의 import 로 사용하고 싶은 java 클래스를 불러와서 스크립트 요소에서 사용할 수 있음. -->
	<%@ page import="java.util.ArrayList" %>
	<% 
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			list.add("Adding " + i + " to list");
		}
	%>
	<ul>
		<%
			for(String str : list){
				out.println("<li>" + str + "</li>");
			}
		%>
	</ul>
	
</body>
</html>