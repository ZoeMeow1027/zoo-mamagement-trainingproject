<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link href="<c:url value="/resources/css/style-header.css" />" rel="stylesheet">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="img-container">
        <img src='<c:url value="/resources/images/zoo.jpg"></c:url>' alt="person" width="70%" height="550px"/>
	</div>
	<div class="text-container">
		<div>SỞ THÚ MỞ CỬA TẤT CẢ CÁC NGÀY TRONG TUẦN - BAO GỒM LỄ TẾT TỪ 9h - 17h </div>
		<div>VỚI GIÁ VÉ CỔNG VÀ GIÁ TẤT CẢ DỊCH VỤ KHÁC NHƯ NGÀY THƯỜNG</div>
	</div>
	<div class="first-container">
		<h2>Mua vé cổng trực tuyến - Khỏi lo xếp hàng</h2>
		<div class="step-container">
			<div class="step-detail">
			    <img src='<c:url value="/resources/images/buy-ticket.webp"></c:url>' alt="person" width="80" height="80"/>
			    <div class="">Mua vé</div>
			</div>
			<div >
				<i class='fas fa-long-arrow-alt-right' style='font-size:70px;color:#E78F8F'></i>
			</div>
			<div class="step-detail">
			    <img src='<c:url value="/resources/images/payment.png"></c:url>' alt="person" width="80" height="80"/>
			    <div>Thanh toán</div>
			</div>
			<div >
				<i class='fas fa-long-arrow-alt-right' style='font-size:70px;color:#E78F8F'></i>
			</div>
			<div class="step-detail">
			    <img src='<c:url value="/resources/images/ticket-icon.webp"></c:url>' alt="person" width="80" height="80"/>
			    <div>Nhận mã</div>
			</div>
			<div>
				<i class='fas fa-long-arrow-alt-right' style='font-size:70px;color:#E78F8F'></i>
			</div>
			<div class="step-detail">
			    <img src='<c:url value="/resources/images/done.png"></c:url>' alt="person" width="80" height="80"/>
			</div>
		</div>
		<a href="#" class="book-btn">Đặt vé ngay</a>
	</div>
	<div class="second-container">
		<div class="sub-container">
			<div class="card-container">
				<div class="img-card-container">
					<img class="img-card" src='<c:url value="/resources/images/animals.jpg"></c:url>' alt="animals"/>
				</div>
				<div>7 lớp với hơn 1000 cá thể gồm hàng chục loài có vú, hàng chục giống chim, nhiều giống bò sát và giống có cánh các loại,  như: khỉ, gấu ngựa, gấu chó, hổ Đông Dương, hổ Bengal, báo hoa mai, báo lửa, sư tử, tinh tinh, ngựa vằn, linh dương, hươu,  nai, heo rừng, mang, nhím, rùa, rái cá, voi châu Á, tê giác trắng, cá sấu hoa cà, cá sấu nước ngọt, trăn đất, công, bò tót, hà mã, báo đốm Mỹ , hươu cao cổ…</div>
			</div>
			<div class="card-container">
				<div class="img-card-container">
					<img class="img-card" src='<c:url value="/resources/images/forest.jpg"></c:url>' alt="animals"/>
				</div>				
				<div>Thực vật có 1.800 cây gỗ thuộc 260 loài, 23 loài lan nội địa, 33 loài xương rồng, 34 loại bonsai và thảm cỏ xanh trên diện tích 20 ha. Trong đó có những cây cổ thụ hàng trăm năm tuổi, vào hàng quý hiếm nhất Việt nam</div>
			</div>
		</div>
		<div align="center" style="margin-top: 30px;">
			<a href="#" class="book-btn">Xem bản đồ</a>
		</div>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
