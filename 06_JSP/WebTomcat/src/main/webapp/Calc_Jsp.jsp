<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter"%>
    <!-- jsp에서 직접 doGet 메소드를 작성하면 되는듯? 실행과정에서 자동으로 service 를 실행하면서 response, requset 매개변수를 생성해서 인식한다. -->
    <!-- 서블릿 doGet 메소드 안의 코드를 그대로 복사해 온 모양임. -->
    <!-- 지금은 귀찮아서 그냥 한 파일안에서 해결했는데 일반적으로는 로직을 실행하는 jsp 하고 그걸 불러오는 jsp 두개가 있는듯 -->
<%
	response.setContentType("text/html; charset=utf-8");
	PrintWriter output = response.getWriter();
	String operator = request.getParameter("option");		
	try {
		int firstNum = Integer.parseInt(request.getParameter("firstNum"));
		int secondNum = Integer.parseInt(request.getParameter("secondNum"));			
		long result;
		switch (operator) {
		case "+":
			result = firstNum + secondNum;
			output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
			.append(String.valueOf(result) + "</h1>");
			break;
		case "-":
			result = firstNum - secondNum;
			output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
			.append(String.valueOf(result) + "</h1>");
			break;
		case "*":
			result = firstNum * secondNum;
			output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
			.append(String.valueOf(result) + "</h1>");
			break;
		case "/":
			result = firstNum / secondNum;
			output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
			.append(String.valueOf(result) + "</h1>");
			break;
		case "%":
			result = firstNum % secondNum;
			output.append("<h1 style=\"color:blue\">" + firstNum + " " + operator + " " + secondNum + " = ")
			.append(String.valueOf(result) + "</h1>");
			break;
		}
		output.append("<div style=\"width:120px;height: 50px;background-color:blue;text-align: center;line-height: 50px;\">")
		.append("<a href=\"/WebTomcat/Calc_Servlet.html\" style=\"color: white; text-decoration: none;\">Do next</a></div>");
	} catch (Exception e) {
		output.append("<h1 style=\"color:red\">!! Wrong Input !!</h1>")
		.append("<div style=\"width:120px;height: 50px;background-color:red;text-align: center;line-height: 50px;\">")
		.append("<a href=\"/WebTomcat/Calc_Servlet.html\" style=\"color: white; text-decoration: none;\">Go back</a></div>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Calculation by Jsp</h1>
	<!-- jsp로 작성할 경우 로직을 처리할 jsp 파일을 생성하고 해당 jsp 파일 경로를 설정해주면 됨. -->
	<form method="post" action="Calc_Jsp.jsp">
		<input type="text" name="firstNum" size="10"/>
		<select name="option">
			<option> + </option>
			<option> - </option>
			<option> * </option>
			<option> / </option>
			<option> % </option>
		</select>
		<input type="text" name="secondNum" size="10"/>
		<input type="submit" value="Doit"/>
	</form>
</body>
</html>