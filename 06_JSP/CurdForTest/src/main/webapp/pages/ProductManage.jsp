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
	<section class="prodManage">
		<div class="wrap">
			<div class="flexWrapper btnMenu">
				<div class="cards">
					<a href="prodAdd">
						<span class="material-symbols-outlined">add_comment</span>
						<p>판매 제품 추가</p>
					</a>
				</div>				
                <div class="cards">
					<a href="prodEdit">
						<span class="material-symbols-outlined">sms</span>
						<p>판매 제품 수정</p>
					</a>
				</div>
				<div class="cards">
					<a href="prodRemove">
                        <span class="material-symbols-outlined">sms_failed</span>
						<p>판매 제품 삭제</p>
					</a>
				</div>
			</div>
		</div>
	</section>
	<c:import url="Footer.jsp"></c:import>
</body>
</html>