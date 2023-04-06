<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cage Management page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type="text/css">
	<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<section class="home">
		<canvas class="myChart" id="myChart" style="width: 100%; max-width: 1000px;"></canvas>
	</section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
<script src='<c:url value="/resources/js/revenue.js" />'></script>
</html>