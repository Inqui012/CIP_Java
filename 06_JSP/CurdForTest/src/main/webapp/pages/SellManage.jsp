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
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,700,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,700,1,0" />
</head>
<body>
	<c:import url="Header.jsp"></c:import>
	<section class="sellManage">
		<div class="wrap">
			<div class="flexWrapper btnMenu">
				<div class="cards">
					<a href="sellMeds">
						<span class="material-symbols-outlined">shopping_cart</span>
						<p>판매</p>
					</a>
				</div>
				<div class="cards">
					<a href="sellRefund">
						<span class="material-symbols-outlined">remove_shopping_cart </span>
						<p>환불</p>
					</a>
				</div>
			</div>
		</div>
	</section>
	<c:import url="Footer.jsp"></c:import>
</body>
</html>