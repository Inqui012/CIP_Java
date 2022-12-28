<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/Meds.css" />
</head>
<body>
	<c:import url="Header.jsp"></c:import>
	<section class="saleProduct">
		<div class="wrap">
			<h2>제품 판매</h2>
			<div class="insideWrapper">
				<table class="productList">
					<thead>
						<tr>
							<th>제품명</th>
							<th>판매가</th>
							<th>판매갯수</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="med" items="${meds}" varStatus="status">
						<tr>
							<td>${ med.name }</td>
							<td>${ med.outprice }</td>
							<td><input type="number" min="0">
								<button type="button" class="btn" onclick="addToCart(this);">추가</button>
							</td>
						</tr>					
					</c:forEach>
					</tbody>
				</table>
				<form method="post" action="sellMeds?sell=Y" class="cartForm">
					<table class="customerCart">
						<thead>
							<tr>
								<th>제품명</th>
								<th>판매가</th>
								<th>판매갯수</th>
								<th>합계</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
						<tfoot>
							<tr>
								<th colspan="3">계</th>
								<td></td>
							</tr>
							<tr>
								<td colspan="4">
									<button type="reset" class="btn" onclick="cartReset(); return false;">주문 취소</button>
									<button type="submit" class="btn" onclick="cartSubmit(); return false;">주문 확정</button>
								</td>
							</tr>
						</tfoot>
					</table>
				</form>
			</div>
		</div>
	</section>
	<c:import url="Footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery-3.6.3.js"></script>
	<script type="text/javascript" src="js/Meds.js"></script>
</body>
</html>