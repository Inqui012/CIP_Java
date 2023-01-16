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
	<section class="prodEdit_List">
		<div class="wrap">
			<h2>판매 제품 수정</h2>
			<div class="flexWrapper">
                <table class="productList">
					<thead>
						<tr>
							<th>제품명</th>
							<th>제조사</th>
							<th>판매가</th>
							<th>구매가</th>
							<th class="oneBtn"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="med" items="${meds}" varStatus="status">
						<tr>
							<td>${ med.name }</td>
							<td>${ med.madeby }</td>
							<td class="txtRight">${ med.outprice }</td>
							<td class="txtRight">${ med.inprice }</td>
							<td class="oneBtn">
								<p class="dispNone">${ med.code }</p>
								<button class="btn" type="button" onclick="prodEdit_List(this);">수정</button>
							</td>
						</tr>					
					</c:forEach>
					</tbody>
				</table>
				<form method="post" action="prodEdit?edit=N" class="editCode dispNone">
					<input type="hidden" name="prodcode" value="">
				</form>
			</div>
		</div>
	</section>
	<c:import url="../Footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery-3.6.3.js"></script>
	<script type="text/javascript" src="js/Meds.js"></script>
</body>
</html>