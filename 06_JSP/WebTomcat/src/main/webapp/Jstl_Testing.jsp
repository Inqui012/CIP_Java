<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
커스텀 태그를 사용할경우 taglib 지시어로 프리픽스와 uri 를 설정해야함. url 아님...
프로젝트를 maven 으로 변경하면 일일히 라이브러리를 다운로드 받아서 lib 폴더에 저장할 필요 없이 사용가능.
maven 으로 변경하면서 jstl 파일을 지웠는데 Maven pom.xml 설정으로 간단하게 jstl 을 사용할 수 있다.
maven 으로 바꾸고 c: 태그에 노란줄이 안없어지길래 왜지 했더니 taglib 지시어의 @와 taglib 사이의 스페이스 없애니까 사라짐.
뭐지...
-->
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="instance" class="_01_Start.Jstl_TestingClass"/>
	<jsp:setProperty property="name" value="Smith" name="instance"/>
	<jsp:setProperty property="age" value="5" name="instance"/>
	
	<!-- 일반 표현언어. EL. 모양은 Jquary 랑 비슷해보이네. 스크립틀릿보다 간단하게 쓸 수 있다. -->
	<h2>NAME : ${instance.name} </h2>
	<hr>
	
	<!--
	JSTL 태그. set 으로 변수의 이름과 값을 지정해서 만들 수 있음.
	set 의 경우에는 setAttribute() 와 동일한 기능을 가진다. 문자열과 숫자, 배열도 저장 가능함. 기본 scope 는 page
	배열을 저장할경우 이클립스에서 에러가 나는데 이건 무시해도 되는 에러인듯???
	-->
	<c:set var="num" value="9"/>
	<c:set var="null"/>
	<c:set var="tag" value="<b>Strong String</b><br/>"/>
	<c:set var="arr" value="${[1, 2, 3, 4, 5]}"/>
	<!--
	값에 변수명이나 연산을 사용하려면 el 구문을 함께 사용해야되네
	if문은 c:if 사이에 test 로 지정된 조건이 참일경우 표시할 값들을 나열함. else 는 없네.
	-->
	<c:if test="${ num % 2 == 0 }">
		<h4>
			<c:out value="${ num }" default="No Number" escapeXml="true"/>
			Even Number
		</h4>
	</c:if>
	<!--
	escapeXml은 출력하는 문자열을 태그로써 인식할것인지, 아닌지를 판단한다.
	true 일경우 태그로 인식하지 않고 그냥 문자열로 출력함. 기본값이 true 인듯		
	-->
	<c:out value="${ tag }" default="Nothing" escapeXml="true" /><br/>
	<c:out value="${ tag }" default="Nothing" escapeXml="false" />
	<!-- default 설정은 불러오는 변수에 값이 없을경우 나타낼 기본값. -->
	<c:out value="${ null }" default="Nothing" /><br/>
	<c:out value="${ arr[2] }" default="Nothing" />
	<hr>
	
	<!--
	JSTL의 for 문. 다른점은 step은 몇씩 증가할것인지 설정가능 
	var 속성은 순회하면서 찾아낸 아이템을 저장할 변수이고 참조할 아이템은 items=""로 지정한다.
	단순하게 배열을 순회할경우는 varStatus를 사용하고, 객체를 순회할경우는 var 속성으로 객체의 필드나 메소드에 접근하는 방식인가.
	varStatus 속성은 for문의 상태를 저장할 변수명인듯. 현재 몇번째인지, 인덱스번호등을 볼 수 있음? 참조객체와는 상관 없음.
	-->
	<c:forEach var="i" begin="0" end="10" step="1">
		JSTL For : ${ i } <br/>
	</c:forEach>
	<hr>
	<c:forEach var="item" items="${ arr }" begin="0" end="4" varStatus="i">
		Array for : ${ arr[i.index] } <br/>
	</c:forEach>
	<hr>
	
	<!--
	choose 구문. when 과 otherwise 로 이게 더 익숙한 if문에 가까운가  
	else 구현이 가능. switch 처럼 when 을 다중으로 사용할수도 있지만 권장하지 않음.
	-->
	<c:choose>
		<c:when test="${ num % 2 != 0 }">
			<p>${ num } Is Odd Number</p>
		</c:when>
		<c:otherwise>		
			<p>${ num } Is Even Number</p>
		</c:otherwise>
	</c:choose>
	<hr>
	
	<!--
	자바의 StringTokenizer 와 동일. delims 로 지정한 조건을 기준으로 문자열을 나눈다.
	형식 자체는 for문과 동일함. 빈 문자열이 생길경우 무시하는듯.
	인덱스번호의.first, .last 로 해당 인덱스가 처음인지, 마지막인지를 판단가능.
	-->
	<c:set var="TokenString" value="one;two;three;four;five;;"/>
	<c:forTokens var="str" items="${ TokenString }" delims=";" varStatus="i">
		<p> ${str} / Is First? ${i.first} / Is Last? ${i.last} </p>
	</c:forTokens>
</body>
</html>