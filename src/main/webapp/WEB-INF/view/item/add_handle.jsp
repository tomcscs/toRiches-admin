<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>거래의 달인 - 관리자 모드</title>
</head>
<body>
	<div>
		<h1>거.래.의.달.인 - 관리자 모드</h1>
		<p>판매 상품 등록 처리 결과입니다.</p>
		<c:choose>
			<c:when test="${saveResult }">
				<p>
					<b>${savedItem.name }</b> 이/가 <span style="color: green">신규 상품으로 등록</span>되었습니다. 등록코드는 ${savedItem.code }
					입니다.
				</p>
			</c:when>
			<c:otherwise>
				<p>
					상품코드 ${existItem.code }는 이미 ${existItem.name } (으)로 등록되어있습니다. <br />
					<span style="color:red">다른 상품코드</span>를 사용해주세요.
				</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
