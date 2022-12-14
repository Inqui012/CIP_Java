<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	switch(request.getParameter("action")){
	case "forward":
	%>
		<jsp:forward page="Including.jsp">
			<jsp:param value="data transport2222" name="paramName1"/>	
		</jsp:forward>
	<%
		break;
	case "redirect":
		response.sendRedirect("Including.jsp");
		break;
	}	
	%>

</body>
</html>