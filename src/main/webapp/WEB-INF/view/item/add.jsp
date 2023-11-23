<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>거래의 달인 - 관리자 모드</title>
</head>
<body>
	<div>
		<div><fmt:formatDate value="${date }" pattern="yyyy.MM.dd HH:mm:ss"/></div>
		<h1>거.래.의.달.인 - 관리자 모드</h1>
		<p>판매 상품을 추가하세요!</p>
	</div>
	<div>
		<form
			action="${pageContext.servletContext.contextPath }/item/add_handle"
			autocomplete="off" method="post">
			<div>
				<div>
					<b>상품코드(*)</b>
				</div>
				<div>
					<input type="number" name="code" />
				</div>
			</div>
			<div>
				<div>
					<b>상품이름(*)</b>
				</div>
				<div>
					<input type="text" name="name" />
				</div>
			</div>
			<div>
				<div>
					<b>상품초기가격(*)</b>
				</div>
				<div>
					<input type="number" name="price" />
				</div>
			</div>
			<div>
				<div>
					<b>상품 변동 폭(*)</b>
				</div>
				<div>
					최소 <input type="number" name="minRate" step="0.01" /> ~ 최대 <input
						type="number" name="maxRate" step="0.01" />
				</div>
			</div>
			<button type="submit">신규 상품 등록</button>
		</form>
	</div>

</body>
</html>
