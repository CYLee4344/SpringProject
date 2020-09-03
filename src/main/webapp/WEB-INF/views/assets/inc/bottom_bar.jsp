<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 하단 메뉴바 -->
<div id="bottom_bar">
    <ul>
        <li><a href="#"><img src="assets/image/menu.png"></a></li>
        <li><a href="${pageContext.request.contextPath}/login.do"><img src="assets/image/lock.png"></a></li>
        <li><a href="${pageContext.request.contextPath}/index.do"><img src="assets/image/home.png"></a></li>
        <li><a href="MyHeart.jsp"><img src="assets/image/heart.png"></a></li>
        <li><a href="Order_List.jsp"><img src="assets/image/person.png"></a></li>
    </ul>
</div>

<!-- 카테고리 바 -->
<div id="category_bar">
    <ul>
        <li><a href="Best.jsp">BEST</a></li>
        <li><a href="New.jsp">NEW</a></li>
        <li><a href="Recommend.jsp">RECOMMEND</a></li>
        <li><a href="Top.jsp">TOP</a></li>
        <li><a href="Dress.jsp">DRESS</a></li>
        <li><a href="Pants.jsp">PANTS</a></li>
        <li><a href="Outer.jsp">OUTER</a></li>
        <li><a href="Acc.jsp">ACCESSORY</a></li>
        <li><a href="Announcement.jsp">NOTICE</a></li>
        <li><a href="QnA.jsp">Q&A</a></li>
    </ul>
</div>