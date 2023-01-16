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
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,700,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,700,1,0" />
</head>
<body>
	<c:import url="../Header.jsp"></c:import>
	<section class="storeManage">
		<div class="wrap">
			<div class="flexWrapper btnMenu">
				<div class="cards">
					<a href="storeOrder">
						<span class="material-symbols-outlined">add_location_alt</span>
						<p>추가 주문</p>
					</a>
				</div>
				<div class="cards">
					<a href="storeRefund">
						<span class="material-symbols-outlined">wrong_location</span>
						<p>재고 처리</p>
					</a>
				</div>
			</div>
		</div>
	</section>
	<c:import url="../Footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery-3.6.3.js"></script>
	<script type="text/javascript" src="js/Meds.js"></script>
</body>
</html>