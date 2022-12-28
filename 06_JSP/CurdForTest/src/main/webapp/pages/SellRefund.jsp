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
			<h2>환불처리</h2>
			<div class="insideWrapper">
				<table class="productList">
					<thead>
						<tr>
							<th>매출번호</th>
							<th>매출일자</th>
							<th>매출내용</th>
							<th>결제금액</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="sell" items="${sells}" varStatus="status">
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
				<form method="post" action="" class="cartForm">
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