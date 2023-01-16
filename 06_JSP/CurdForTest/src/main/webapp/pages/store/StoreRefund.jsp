<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>@@약국 판매관리 페이지</title>
	<link rel="stylesheet" href="css/Meds.css" />
</head>
<body>
	<c:import url="../Header.jsp"></c:import>
	<section class="storeRefund">
		<div class="wrap">
			<h2>재고 반품</h2>
			<div class="flexWrapper">
                <table class="productList">
					<thead>
						<tr>
							<th>제품명</th>
							<th>제조사</th>
							<th>구매가</th>
							<th>반품가</th>
							<th>현재고</th>
							<th class="oneBtn"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="med" items="${meds}" varStatus="status">
						<tr>
							<td>${ med.name }</td>
							<td>${ med.madeby }</td>
							<td class="txtRight">${ med.inprice }</td>
							<td class="txtRight">${ med.inprice * 0.6 }</td>
							<td class="txtRight">${ med.stored }</td>
							<td class="quantInput">
								<p class="dispNone">${ med.code }</p>
								<input type="number" name="refundQuant" min="0" max="${ med.stored }">
								<button class="btn" type="button" onclick="storeRefund(this);">반품</button>
							</td>
						</tr>					
					</c:forEach>
					</tbody>
				</table>
				<form method="post" action="storeRefund?refund=Y" class="hiddenForm dispNone">
					<input type="hidden" name="prodcode" value="">
					<input type="hidden" name="refundQuant" value="">
				</form>
			</div>
		</div>
	</section>
	<c:import url="../Footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery-3.6.3.js"></script>
	<script type="text/javascript" src="js/Meds.js"></script>
</body>
</html>