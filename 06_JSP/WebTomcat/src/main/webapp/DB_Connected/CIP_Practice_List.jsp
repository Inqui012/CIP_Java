<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="DB_Conn.CIP_Practice_DTO_mem" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="CIP_Practice.css">
</head>
<body>
	<jsp:include page="CIP_Practice_Head.jsp"></jsp:include>
	<section class="list">
		<h2>회원 목록조회 / 수정</h2>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<% 
				List<CIP_Practice_DTO_mem> list = (List<CIP_Practice_DTO_mem>) request.getAttribute("memList");
				for (CIP_Practice_DTO_mem mem : list) {
			%>
			<tr>
				<td><a href="update?custno=<%= mem.getCustno() %>"><%= mem.getCustno() %></a></td>
				<td><%= mem.getCustname() %></td>
				<td><%= mem.getPhone() %></td>
				<td><%= mem.getAddress() %></td>
				<td><%= mem.getJoindate() %></td>
				<td><%= mem.getGrade()%></td>
				<td><%= mem.getCity()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</section>
	<jsp:include page="CIP_Practice_Foot.jsp"></jsp:include>
</body>
</html>