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
	<section class="prodEdit">
		<div class="wrap">
			<h2>판매 제품 추가</h2>
			<div class="insideWrapper">
                <table class="productList">
					<thead>
						<tr>
							<th>제품명</th>
							<th>제조사</th>
							<th>판매가</th>
							<th>구매가</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="med" items="${meds}" varStatus="status">
						<tr>
							<td>${ med.name }</td>
							<td>${ med.madeby }</td>
							<td class="txtRight">${ med.outprice }</td>
							<td class="txtRight">${ med.inprice }</td>
						</tr>					
					</c:forEach>
					</tbody>
				</table>
				<form method="post" action="prodEdit?edit=Y" class="prodForm">
					<table class="prod">
                        <tr>
                            <th>
                                <label for="prodName">상품명</label>
                            </th>
                            <td>
                                <input type="text" id="prodName" name="prodName" value="" required>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodMade">제조사</label>
                            </th>
                            <td>
                                <input type="text" id="prodMade" name="prodMade" value="" required>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodOut">판매가</label>
                            </th>
                            <td>
                                <input type="number" id="prodOut" name="prodOut" value="" min="0" required>
                            </td>
                        <tr>
                        <tr>
                            <th>
                                <label for="prodIn">구매가</label>
                            </th>
                            <td>
                                <input type="number" id="prodIn" name="prodIn" value="" min="0">
                            </td>
                        </tr>
							<td class="btnWrap" colspan="2">
								<button type="reset" class="btn">추가 취소</button>
								<button type="submit" class="btn" onclick="inputSubmit(); return false;">상품 추가</button>
						    </td>
						</tr>                   
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