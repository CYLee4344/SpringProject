<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>THE SELECTION</title>
    <link rel="stylesheet" type="text/css" href="assets/css/reset.css" />
</head>
<body>
	<h2>상품목록</h2>
	<table border="1">
		<tr>
			<th>이미지</th>
			<th>브랜드</th>
			<th>상품명</th>
			<th>가격</th>
		</tr>
		<c:forEach var="row" items="${list}">
		<tr>
			<td>
				<img src="${pageContext.request.contextPath}/assets/image/${row.img}" width="50", height="50">
			</td>
			<td>
				${row.brand}
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/ProductDetail.do/${row.product_no}">${row.name}</a>
			</td>
			<td>
				<fmt:formatNumber value="${row.price}" pattern="###,###,###"/>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>