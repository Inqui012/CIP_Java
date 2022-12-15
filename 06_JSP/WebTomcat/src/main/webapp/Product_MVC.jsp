<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Of Products</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>코드</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
		<!-- 순회할 리스트 products 는 controller 에서 받아오는 형식 -->
			<c:forEach var="product" items="${ products }" varStatus="i">
				<tr>
					<td>${ product.id }</td>
					<!--
					form 태그 이외에 컨트롤러를 호출할경우 경로에 똑같이 컨트롤러 붙여넣으면 되네
					대신에 이경우는 서블릿에서 받아야할 데이터를 get 형식으로 쿼리스트링을 직접작성함.
					-->
					<td><a href="/WebTomcat/PCont?action=info&code=${ product.id }"> ${ product.name } </a></td>
					<td>${ product.price }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>