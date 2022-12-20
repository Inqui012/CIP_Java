<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="DB_Conn.CIP_Practice_DTO_mon" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="CIP_Practice.css">
</head>
<body>
	<jsp:include page="CIP_Practice_Head.jsp"></jsp:include>
	<section class="sell">
		<h2>회원 매출조회</h2>
		<% List<CIP_Practice_DTO_mon> sellList = (List<CIP_Practice_DTO_mon>) request.getAttribute("sellList"); %>
		<table border="1">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>고객등급</th>
					<th>매출</th>
				</tr>
				<% for(CIP_Practice_DTO_mon sell : sellList) { %>
				<tr>
					<td><%= sell.getCustno() %></td>
					<td><%= sell.getCustname() %></td>
					<td><%= sell.getGrade() %></td>
					<td><%= sell.getTotalPrice() %></td>
				</tr>
				<% } %>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</section>
	<jsp:include page="CIP_Practice_Foot.jsp"></jsp:include>
</body>
</html>