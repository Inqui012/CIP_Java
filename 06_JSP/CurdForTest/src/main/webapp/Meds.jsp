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
	<c:import url="pages/Header.jsp"></c:import>
	<section class="saleProduct">
		<div class="wrap">
			<h2>판매</h2>
			<div class="insideWrapper">
				<div class="cards">
					<i class="fa-solid fa-cart-shopping"></i>
				</div>
				<div class="cards">
					
				</div>
			</div>	
		</div> 
		<form method="get" action="">
			<input type="text" name="test">
			<input type="text" name="test">
			<input type="text" name="test">
			<input type="text" name="test">
			<input type="text" name="test">
			<input type="submit">
		</form>
	</section>
	<c:import url="pages/Footer.jsp"></c:import>
</body>
</html>