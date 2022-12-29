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
	<section class="prodRemove">
		<div class="wrap">
			<h2>판매 제품 삭제</h2>
			<div class="insideWrapper">
                <span>
                    !! 재고가 존재하지 않는 상품만 판매 리스트에서 삭제 가능합니다. !!<br/>
                    !! 리스트에 상품이 없을경우 재고 처리를 먼저 진행해주세요. !!
                </span>
				<table class="productList">
					<thead>
						<tr>
							<th>제품명</th>
							<th>제조사</th>
							<th colspan="2">현재고</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="med" items="${stockZero}" varStatus="status">
						<tr>
							<td>${ med.name }</td>
							<td>${ med.madeby }</td>
							<td class="txtRight">${ med.stored }</td>
							<td>
                                <p class="dispNone">${ med.code }</p>
								<button type="button" class="btn" onclick="prodRemove(this);">삭제</button>
							</td>
						</tr>					
					</c:forEach>
					</tbody>
				</table>
                <form method="post" action="prodRemove?remove=Y" class="removeForm">
					<input type="hidden" name="prodRemove" value="">
				</form>
			</div>
		</div>
	</section>
	<c:import url="Footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery-3.6.3.js"></script>
	<script type="text/javascript" src="js/Meds.js"></script>
</body>
</html>