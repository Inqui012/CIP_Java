<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>@@약국 판매관리 페이지</title>
</head>
<body>
	<header>
		<h1>
			<a href="/Meds">상품판매<br />재고관리<br />프로그램</a>
		</h1>
		<nav>
			<ul class="mainMenu">
				<li><a href="/Meds">판매</a>
					<ul class="subMenu">
						<li><a href="sellMeds">일반판매</a></li>
						<li><a href="sellRefund">환불처리</a></li>
					</ul></li>
				<li><a href="prodMag">제품관리</a>
					<ul class="subMenu">
						<li><a href="prodAdd">판매 제품 추가</a></li>
						<li><a href="prodEdit">판매 제품 수정</a></li>
						<li><a href="prodRemove">판매 제품 삭제</a></li>
					</ul></li>
				<li><a href="storeMag">재고 관리</a>
					<ul class="subMenu">
						<li><a href="storeOrder">추가 주문</a></li>
						<li><a href="storeRefund">재고 처리</a></li>
					</ul></li>
			</ul>
		</nav>
	</header>
</body>
</html>