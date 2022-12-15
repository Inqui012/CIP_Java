<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Information Of Products</h1>
	<hr>
	<ul>
		<li>CODE : ${ product.id }</li>
		<li>CODE : ${ product.name }</li>
		<li>CODE : ${ product.maker }</li>
		<li>CODE : ${ product.price }</li>
		<li>CODE : ${ product.date }</li>
	</ul>
</body>
</html>