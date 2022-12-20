<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="DB_Conn.CIP_Practice_DTO_mem" %>
<% 
	request.setCharacterEncoding("UTF-8");
	CIP_Practice_DTO_mem mem = (CIP_Practice_DTO_mem) request.getAttribute("mem");
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
	<section class="update">
		<h2>홈쇼핑 회원 정보 수정</h2>
		<form method="post" action="update?modifyno=<%= mem.getCustno() %>&modify=true" name="upFrm">
			<input type="hidden" id="spec" value="updating">
			<table border="1">
				<tr>
					<th>
						<label for="custno">회원번호</label>
					</th>
					<td>
						<input type="text" id="custno" name="custno" value="<%=mem.getCustno() %>">
					</td>
				</tr>
				<tr>
					<th>
						<label for="custname">회원성명</label>
					</th>
					<td>
						<input type="text" id="custname" name="custname" value="<%=mem.getCustname() %>">
					</td>
				</tr>
				<tr>
					<th>
						<label for="phone">회원전화</label>
					</th>
					<td>
						<input type="text" id="phone" name="phone" value="<%=mem.getPhone() %>">
					</td>
				</tr>
				<tr>
					<th>
						<label for="address">회원주소</label>
					</th>
					<td>
						<input type="text" id="address" name="address" value="<%=mem.getAddress() %>">
					</td>
				</tr>
				<tr>
					<th>
						<label for="joindate">가입일자</label>
					</th>
					<td>
						<input type="text" id="joindate" name="joindate" value="<%=mem.getJoindate() %>">
					</td>
				</tr>
				<tr>
					<th>
						<label for="grade">고객등급 [A:VIP, B:일반, C:직원]</label>
					</th>
					<td>
						<input type="text" id="grade" name="grade" value="<%=mem.getGrade() %>">
					</td>
				</tr>
				<tr>
					<th>
						<label for="city">도시코드</label>
					</th>
					<td>
						<input type="text" id="city" name="city" value="<%=mem.getCity() %>">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" onclick="submitFunc(); return false;">수 정</button>
						<button type="button">조 회</button>
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="CIP_Practice_Foot.jsp"></jsp:include>
</body>
</html>