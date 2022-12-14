<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Testing For Include</h1>
	<%
		String param = request.getParameter("paramName");
		String param1 = request.getParameter("paramName1");
		String param2 = request.getParameter("action");
		out.println(param + "<br/>");
		out.println(param1 + "<br/>");
		out.println(param2 + "<br/>");
	%>
	<hr>
	
</body>
</html>