<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Information Of Products</h1>
	<hr>
	<!--
	MVC의 특징. 화면을 구성하는 view 위치의 jsp는 아무런 기능을 직접 가지고 있지 않는다.
	어떤 서블릿으로 이동하는지도 써져있지 않고 그냥 데이터를 받아와서 표시만 하는 페이지.
	-->
	<ul>
		<li>CODE : ${ product.id }</li>
		<li>NAME : ${ product.name }</li>
		<li>MAKER : ${ product.maker }</li>
		<li>PRICE : ${ product.price }</li>
		<li>DATE : ${ product.date }</li>
	</ul>
</body>
</html>