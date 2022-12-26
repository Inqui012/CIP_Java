<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="Meds.css"/>
	<script src="https://code.jquery.com/jquery-3.6.3.slim.js" integrity="sha256-DKU1CmJ8kBuEwumaLuh9Tl/6ZB6jzGOBV/5YpNE2BWc=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="Meds.js"></script>
</head>
<body>
	<c:import url="Meds_Header.jsp"></c:import>
	<section>
		<h2>제품 판매</h2>
		<table class="productList" border="1">
			<thead>
				<tr>
					<th>제품명</th>
					<th>판매가</th>
					<th>판매갯수</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="productName">테스트제품</td>
					<td class="productPrice">500</td>
					<td>
						<input type="number" name="orderQuant">
					</td>
					<td>
						<button type="button">추가</button>
					</td>
				</tr>
			</tbody>
		</table>
		<hr>
		<table class="customerCart" border="1">
			<thead>
				<tr>
					<th>제품명</th>
					<th>판매갯수</th>
					<th>판매가</th>
					<th>합계</th>
					<th>선택삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td>
						<input type="number" name="listedQuant">
					</td>
					<td></td>
					<td></td>
					<td>
						<input type="checkbox" name="listedDelete">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3">계</th>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</section>
	<c:import url="Meds_Footer.jsp"></c:import>
</body>
</html>