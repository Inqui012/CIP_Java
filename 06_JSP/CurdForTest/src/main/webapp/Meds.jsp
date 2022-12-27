<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Meds.css" />
<script type="text/javascript" src="jquery-3.6.3.slim.js"></script>
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
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>테스트제품</td>
					<td>500</td>
					<td>
						<input type="number">
						<button type="button" class="addToCart">추가</button>
					</td>
				</tr>
			</tbody>
		</table>
		<hr>
		<table class="customerCart" border="1">
			<thead>
				<tr>
					<th>제품명</th>
					<th>판매가</th>
					<th>판매갯수</th>
					<th>합계</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td>
						<input type="number" name="listedQuant">
						<button type="button" class="changeCart">변경</button>
						<button type="button" class="deleteCart">삭제</button>
					</td>
					<td></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3">계</th>
					<td></td>
				</tr>
			</tfoot>
		</table>
	</section>
	<c:import url="Meds_Footer.jsp"></c:import>
</body>
</html>