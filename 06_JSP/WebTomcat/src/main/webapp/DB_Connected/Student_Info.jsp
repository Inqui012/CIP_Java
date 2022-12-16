<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Student List & Insert</h1>
	<hr>
	<!--
	메소드를 포스트로 해야 action 에 설정한 파라메터를 읽어올 수 있네.
	겟으로 하면 가져가는 input들 데이터로 파라메터가 바뀌어서 action 값을 읽을수가 없음.
	-->
	<form method="post" action="/WebTomcat/Student_Controller?action=insert">
		<label>
			USERNAME : 
			<input type="text" name="username">
		</label>
		<br/>		
		<label>
			UNIVERSICY : 
			<input type="text" name="univ">
		</label>
		<br/>
		<label>
			BIRTH : 
			<input type="text" name="birth" placeholder="yyyy-mm-dd">
		</label>
		<br/>		
		<label>
			EMAIL : 
			<input type="email" name="email">
		</label>
		<br/>
		<button type="submit">INSERT</button>
	</form>
	<br/>
	<c:if test="${ err == true }">
		<h2>Wrong</h2>
	</c:if>
	<br/><br/>
	<table border="1">
		<thead>
			<tr>
				<th>학생번호</th>
				<th>학생이름</th>
				<th>학생대학</th>
				<th>학생생일</th>
				<th>학생메일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="Stu" items="${ StuList }">
				<tr>
					<td>${ Stu.id }</td>
					<td>${ Stu.username }</td>
					<td>${ Stu.univ }</td>
					<td>${ Stu.birth }</td>
					<td>${ Stu.email }</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>