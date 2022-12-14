<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="_01_Start.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Calculation by Bean</h1>
	<jsp:useBean id="instance" class="_01_Start.BeanClass" />
	<!-- 
	Bean 객체를 생성해서 값을 넣는건 아마도 submit 하고 난 다음 페이지 가 새로고침 되면서 데이터를 보낸 다음인듯.
	한 페이지에서 해결할경우 실행할 메소드에 값이 null 일경우의 오류 처리를 하지 않으면 실행 안됨
	property에 들어가는 값은 html 태그의 name 이 가지고 있는 값들이고, 이걸 일치하는 java 변수명의 에 자동으로 값을 입력함. 
	태그의 name : 태그의 값 => name과 일치하는 이름의 변수 : 태그의 값
	name값과 변수의 이름이 일치하지 않으면 값이 안들어감... java 의 변수는 null 이 유지되고 넣고싶었던 값은 어딘가로...사라지..네?
	-->	
	<jsp:setProperty property="*" name="instance"/>
	
	<form method="post" action="UsingBean.jsp">
		<input type="text" name="firstNum" size="10"/>
		<select name="optio">
			<option> + </option>
			<option> - </option>
			<option> * </option>
			<option> / </option>
			<option> % </option>
		</select>
		<input type="text" name="secondNum" size="10"/>
		<input type="submit" value="Doit"/>
	</form>
	<br>
	<h1>
	<%=instance.calcResult() %>	
	</h1>
	
	<hr>
	<!-- 
	jsp 지시어인 인클루드와 하는 기능은 똑같으나 여기서는 param 을 이용해서 원하는 값을 파라미터에 실어 보낼 수 있다.
	아래 구문은 including.jsp 에 paramName 이라는 이름으로 data transport 라는 값을 넘겨준다.
	넘어간 데이터는 해당 jsp 에서 request 객체를 통해 받아볼 수 있음.
	 -->
	<jsp:include page="Including.jsp">
		<jsp:param value="data transport" name="paramName"/>
	</jsp:include>
	
	<!--
	포워딩과 리다이렉트 둘다 페이지를 이동하는 기능은 같으나 파라미터 값을 가지고 가느냐 마냐의 차이
	아래 선택문으로 둘중 하나를 선택해서 실행하는데 포워딩의 경우 중간jsp 를 거친 후에 include로 진행하지만 주소값을 보게되면 여전히 중간.jsp 으로 찍혀있음.
	그리고 현재 페이지에서 설정된 파라메터 forward 값과, 중간jsp 에서 설정한 paramName2 를 동시에 가져가서 출력한다.
	반대로 리다이렉트의 경우 아무런 파라메터 없이 바로 include로 진행하고, 주소값도 include로 변경된다. html 의 a태그랑 비슷...한가?
	-->
	<form method="post" action="Forward_Redirect.jsp">
		<label>
		<input type="radio" name="action" id="forward" value="forward">
		Doing Forward		
		</label>
		<label>
		<input type="radio" name="action" id="redirect" value="redirect">
		Doing Redirect		
		</label>
		<input type="submit" value="forward">
	</form>

</body>
</html>