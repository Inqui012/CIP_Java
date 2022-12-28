<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>
			상품판매<br />재고관리<br />프로그램
		</h1>
		<nav>
			<ul class="mainMenu">
				<li><a href="sellMag">판매</a>
					<ul class="subMenu">
						<li><a href="sellMeds">일반판매</a></li>
						<li><a href="sellRefund">환불처리</a></li>
					</ul></li>
				<li><a href="prodMag">제품관리</a>
					<ul class="subMenu">
						<li><a href="prodAdd">판매 제품 추가</a></li>
						<li><a href="prodRemove">판매 제품 삭제</a></li>
					</ul></li>
				<li><a href="storeMag">재고 관리</a>
					<ul class="subMenu">
						<li><a href="storeOrder">추가 주문</a></li>
						<li><a href="storeRefund">재고 처리</a></li>
					</ul></li>
				<li><a href="salesMag">매출관리</a>
					<ul class="subMenu">
						<li><a href="salesDate">기간별</a></li>
						<li><a href="salesProd">제품별</a></li>
						<li><a href="salesMade">제조사별</a></li>
					</ul></li>
			</ul>
		</nav>
	</header>
</body>
</html>