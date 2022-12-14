<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		section {margin: 0 auto; width: 100%; height: 200px; display:flex; justify-content:space-between;}
		div {width: 20%; height: 100%; font-size: 50px; color: white; text-align: center; line-height: 200px;
		text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;}
	</style>
</head>
<body>
	<%@page import="java.util.ArrayList, java.util.Collections" %>
	<%! 
		ArrayList<Integer> nums = new ArrayList<>();
		String getColor(){
			return "#" + Integer.toHexString((int)Math.floor(Math.random() * 16777215));
		}
		int getNum(){
			int num = (int) (Math.random() * 20) + 1;
			nums.add(num);
			return num;
		}
		boolean findDup(ArrayList<Integer> nums){
			for(Integer num : nums){
				if(Collections.frequency(nums, num) > 1){
					nums.clear();
					return true;
				}
			}
			nums.clear();
			return false;
		}
	%>
	<section>
		<div style="background-color:<%=getColor()%>"><%=getNum() %></div>
		<div style="background-color:<%=getColor()%>"><%=getNum() %></div>
		<div style="background-color:<%=getColor()%>"><%=getNum() %></div>
		<div style="background-color:<%=getColor()%>"><%=getNum() %></div>
		<div style="background-color:<%=getColor()%>"><%=getNum() %></div>
	</section>
	<%
		if(findDup(nums)){
			out.println("<h1 style=\"text-align: center;\"> There is Duplicate Number </h1>");
		} else {
			out.println("");
		}
	%>
</body>
</html>