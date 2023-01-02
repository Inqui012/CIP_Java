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
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,700,1,0" />
</head>
<body>
	<c:import url="Header.jsp"></c:import>
	<section class="saleManage">
		<div class="wrap">
			<div class="flexWrapper btnMenu">
				<div class="cards">
					<a href="salesDate">
						<span class="material-symbols-outlined">alarm</span>
						<p>기간별</p>
					</a>
				</div>
				<div class="cards">
					<a href="salesProd">
						<span class="material-symbols-outlined">medication_liquid</span>
						<p>제품별</p>
					</a>
				</div>
				<div class="cards">
					<a href="salesMade">
						<span class="material-symbols-outlined">warehouse</span>
						<p>제조사별</p>
					</a>
				</div>
			</div>
		</div>
	</section>
	<c:import url="Footer.jsp"></c:import>
</body>
</html>