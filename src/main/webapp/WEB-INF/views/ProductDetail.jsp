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
	<h2>상품 상세정보</h2>
	<table border="1">
		<tr>
			<td>이미지</td>
			<td><img src="${pageContext.request.contextPath}/assets/image/${product.img}" width="50", height="50"></td>
		</tr>
		<tr>
			<td>브랜드</td>
			<td>${product.product_no}</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td>${product.name}</td>
		</tr>
		<tr>
			<td>상품가격</td>
			<td>${product.price}</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>${product.dscr}</td>
		</tr>
	</table>

</body>
</html>