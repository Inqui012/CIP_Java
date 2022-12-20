<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int nextNo = 0;
	nextNo = (Integer) request.getAttribute("custno");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="CIP_Practice.css">
	<script type="text/javascript" src="CIP_Practice.js"></script>
</head>
<body>
	<jsp:include page="CIP_Practice_Head.jsp"/>
	<section class="add">
		<h2>홈쇼핑 회원 등록</h2>
		<form method="post" action="insert?actv=true" name="insFrm">
			<input type="hidden" id="spec" value="inserting">
			<table border="1">
				<tr>
					<th>
						<label for="custno">회원번호(자동발생)</label>
					</th>
					<td>
						<input type="text" id="custno" name="custno" value="<%= nextNo %>" disabled>
					</td>
				</tr>
				<tr>
					<th>
						<label for="custname">회원성명</label>
					</th>
					<td>
						<input type="text" id="custname" name="custname">
					</td>
				</tr>
				<tr>
					<th>
						<label for="phone">회원전화</label>
					</th>
					<td>
						<input type="text" id="phone" name="phone">
					</td>
				</tr>
				<tr>
					<th>
						<label for="address">회원주소</label>
					</th>
					<td>
						<input type="text" id="address" name="address">
					</td>
				</tr>
				<tr>
					<th>
						<label for="joindate">가입일자</label>
					</th>
					<td>
						<input type="text" id="joindate" name="joindate">
					</td>
				</tr>
				<tr>
					<th>
						<label for="grade">고객등급 [A:VIP, B:일반, C:직원]</label>
					</th>
					<td>
						<input type="text" id="grade" name="grade">
					</td>
				</tr>
				<tr>
					<th>
						<label for="city">도시코드</label>
					</th>
					<td>
						<input type="text" id="city" name="city">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" onclick="submitFunc(); return false;">등 록</button>
						<button type="button" onclick="location='update'">조 회</button>
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="CIP_Practice_Foot.jsp"></jsp:include>
</body>
</html>