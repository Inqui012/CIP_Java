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
        <div class="board_title">
            <strong>자유게시판</strong>
            <p>자유게시판 입니다.</p>
        </div>
        <form method="post" action="update?board_no=${board.board_no}" class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" name="title" placeholder="제목 입력" value="${board.title}"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><input type="text" name="user_id" placeholder="글쓴이 입력" value="${board.user_id}"></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea placeholder="내용 입력" name="content">
                    ${board.content}
                    </textarea>
                </div>
            </div>
            <div class="bt_wrap">
                <button type="submit">수정</button>
                <button type="reset" onclick="location.href='list'">취소</button>
            </div>
        </form>
    </div>
    <script>
	  <c:if test="${error != null}">
	    alert("${error}");
	  </c:if>
	</script>
</body>
</html>