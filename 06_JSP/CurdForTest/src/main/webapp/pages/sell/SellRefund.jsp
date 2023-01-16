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
	<section class="sellRefund">
		<div class="wrap">
			<h2>환불처리</h2>
			<table class="sellList">
				<thead>
					<tr>
						<th>판매번호</th>
						<th>판매일자</th>
						<th colspan="3" class="wid-50">판매내용</th>
						<th>결제금액</th>
						<th>상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="sell" items="${sellList}" varStatus="status">
					<tr class="sellmainList">
						<td class="txtCenter">${ sell.sellNo }</td>
						<td>${ sell.sellDate }</td>
						<td colspan="3">${ sell.sellName }</td>
						<td class="txtRight">${ sell.sellTotal }</td>
						<td class="txtCenter">${ sell.sellStatus }</td>
						<td class="oneBtn">
							<button class="btn" onclick="sellRefund(this);">환불</button>
						</td>
					</tr>
						<tr class="dispNone subStlye">
							<th></th>
							<th>제조사</th>
							<th>상품명</th>
							<th>판매가</th>
							<th>판매갯수</th>
							<th>금액</th>
							<th colspan="2"></th>
						</tr>
					<c:forEach var="i" items="${ sell.sellName }" begin="0" end="${sell.sellName.size()}" varStatus="status">
						<tr class="dispNone subStlye">
							<td></td>
							<td>${ sell.sellMadeby.get(status.index) }</td>
							<td>${ sell.sellName.get(status.index) }</td>
							<td class="txtRight">${ sell.sellOut.get(status.index) }</td>
							<td class="txtRight">${ sell.sellQuantity.get(status.index) }</td>
							<td class="txtRight">${ sell.sellQuantity.get(status.index) * sell.sellOut.get(status.index) }</td>
							<td colspan="2"></td>
						</tr>					
					</c:forEach>
				</c:forEach>
				</tbody>
			</table>
			<form method="post" action="sellRefund?refund=Y" class="refundForm">
				<input type="hidden" name="refundNo" value="">
			</form>
		</div>
	</section>
	<c:import url="../Footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery-3.6.3.js"></script>
	<script type="text/javascript" src="js/Meds.js"></script>
</body>
</html>