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
</head>
<body>
	<c:import url="Header.jsp"></c:import>
	<section class="prodAdd">
		<div class="wrap">
			<h2>판매 제품 추가</h2>
			<div>
				<form method="post" action="prodAdd?add=Y" class="prodForm">
					<table class="prod">
                        <tr>
                            <th>
                                <label for="prodCode">상품코드</label>
                            </th>
                            <td>
                                <input type="number" id="prodCode" name="prodCode" value="${nextCode}" disabled required>
                                <span>상품코드는 자동으로 생성됩니다.</span>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodName">상품명</label>
                            </th>
                            <td>
                                <input type="text" id="prodName" name="prodName" required>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodMade">제조사</label>
                            </th>
                            <td>
                                <input type="text" id="prodMade" name="prodMade" required>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodIn">구매가</label>
                            </th>
                            <td>
                                <input type="number" id="prodIn" name="prodIn" min="0">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodOut">판매가</label>
                            </th>
                            <td>
                                <input type="number" id="prodOut" name="prodOut"  min="0" required>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodStock">초기재고</label>
                            </th>
                            <td>
                                <input type="number" id="prodStock" name="prodStock" min="0">
                                <span>설정하지 않을경우 0으로 초기화 됩니다.</span>
                            </td>
                        </tr>
                        <tr>
							<td class="btnWrap" colspan="2">
								<button type="reset" class="btn">추가 취소</button>
								<button type="submit" class="btn" onclick="inputSubmit(); return false;">상품 추가</button>
						    </td>
						</tr>                   
					</table>
				</form>
			</div>
		</div>
	</section>
	<c:import url="Footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery-3.6.3.js"></script>
	<script type="text/javascript" src="js/Meds.js"></script>
</body>
</html>