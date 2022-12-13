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
	<!-- 메소드나 함수를 불러올때는 =을, 직접 코드를 작성할 경우에는 없이 그냥 쓰는듯? -->
	<%
	for(int i=2; i<10; i++){
	    for(int j=1; j<10; j++){
	        out.println(i+" * "+j+" = "+i*j + "<br>");
	    }
	}
	%>
</body>
</html>