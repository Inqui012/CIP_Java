<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="Board.css">
</head>
<body>
    <div class="wrap">
        <table class="board_list">
            <caption>자유 게시판</caption>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
            	<!-- JSTL을 사용할경우 리퀘스트에 붙어있는 attribute를 가져올때는 벼다른 구문없이 바로 가져올 수 있다.  -->
            	<c:forEach var="board" items="${boardList}" varStatus="status">
                <tr>
                    <td>${board.board_no}</td>
                    <td class="board_title"><a href="view?board_no=${board.board_no}">${board.title}</a></td>
                    <td>${board.user_id}</td>
                    <td>${board.reg_date}</td>
                    <td>${board.views}</td>
                </tr>            	
            	</c:forEach>
            </tbody>
        </table>
        <div class="bt_wrap bt_list">
            <a href="write">글쓰기</a>
        </div>
        <div class="board_page">
            <a href="" class="bt first">&lt;&lt;</a>
            <a href="" class="bt prev">&lt;</a>
            <a href="" class="num on">1</a>
            <a href="" class="num">2</a>
            <a href="" class="num">3</a>
            <a href="" class="num">4</a>
            <a href="" class="num">5</a>
            <a href="" class="bt next">&gt;</a>
            <a href="" class="bt last">&gt;&gt;</a>
        </div>
    </div>
    <script>
	  <c:if test="${error != null}">
	    alert("${error}");
	  </c:if>
	</script>
</body>
</html>