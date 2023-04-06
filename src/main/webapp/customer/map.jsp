<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-home-page.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style-tickets-page.css" />" rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>Chào mừng bạn đến với Sở thú</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<main class="main-container">
		<h1>Zoo Map</h1>
		<img class="map" src='<c:url value="/resources/images/zoo_map.png" ></c:url>' alt="landing-left"/>
		
	</main>
	
	<div class="footer-top">
		<div class="footer-inner">
			<p class="footer-title">Bắt đầu chuyến tham quan</p>
			<ul class="footer-list">
				<li class="footer-item">
					<a href="login" class="footer-link">Đăng nhập</a>
				</li>
				<li class="footer-item">
					<a href="tickets" class="footer-link">Mua vé ngay</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="footer-bottom">
		
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>