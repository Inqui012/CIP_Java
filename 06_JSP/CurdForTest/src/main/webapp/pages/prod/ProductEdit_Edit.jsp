<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>@@약국 판매관리 페이지</title>
	<link rel="stylesheet" href="css/Meds.css" />
</head>
<body>
	<c:import url="../Header.jsp"></c:import>
	<section class="prodEdit_Edit">
		<div class="wrap">
			<h2>판매 제품 수정</h2>
			<div class="flexWrapper">
				<form method="post" action="prodEdit?edit=Y" class="prodForm">
					<table class="prod">
                        <tr>
                            <th>
                                <label for="prodCode">상품코드</label>
                            </th>
                            <td>
                                <input type="number"value="${Selected.code}" disabled required>
                                <input type="hidden" class="dispNone" id="prodCode" name="prodCode" value="${Selected.code}" required>
                                <span>상품코드는 변경할 수 없습니다.</span>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodName">상품명</label>
                            </th>
                            <td>
                                <input type="text" id="prodName" name="prodName" value="${Selected.name}" required>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodMade">제조사</label>
                            </th>
                            <td>
                                <input type="text" id="prodMade" name="prodMade" value="${Selected.madeby}" required>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodIn">구매가</label>
                            </th>
                            <td>
                                <input type="number" id="prodIn" name="prodIn" value="${Selected.inprice}" min="0">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="prodOut">판매가</label>
                            </th>
                            <td>
                                <input type="number" id="prodOut" name="prodOut" value="${Selected.outprice}" min="0" required>
                            </td>
                        </tr>
                        <tr>
							<td class="txtCenter" colspan="2">
								<button type="reset" class="btn">변경 취소</button>
								<button type="submit" class="btn" onclick="prodEdit_Edit(); return false;">정보 변경</button>
						    </td>
						</tr>                   
					</table>
				</form>
			</div>
		</div>
	</section>
	<c:import url="../Footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery-3.6.3.js"></script>
	<script type="text/javascript" src="js/Meds.js"></script>
</body>
</html>