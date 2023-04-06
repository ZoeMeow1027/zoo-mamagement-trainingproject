<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-home-page.css" />" rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>Chào mừng bạn đến với Sở thú</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<main>
		<section class="hero-landing">
			<img class="img-back" src='<c:url value="/resources/images/tiger-in-zoo-trail.webp"></c:url>' alt="tiger-in-zoo"/>
			<span class="background-overlay"></span>
			<img class="landing-left" src='<c:url value="/resources/images/hero-landing-left-3.webp"></c:url>' alt="landing-left"/>
			<img class="landing-right" src='<c:url value="/resources/images/hero-landing-right-3.webp"></c:url>' alt="landing-right"/>
			<div class="landing-heading">
				<h1 class="heading1">Tham quan Sở thú</h1>
				<p class="heading2">Đặt vé ngay và nhận ưu đãi</p>
			</div>
		</section>
		<section class="main-section">
			<div class="pricing-tabel__inner">
				<div class="pricing-tabel__heading">Mua vé trực tuyến - Khỏi lo xếp hàng</div>
				<div class="pricing-tabel__left">
					<div class="pricing-tabel__img-container">
						<img class="pricing-tabel__img" src='<c:url value="/resources/images/monkey.webp"></c:url>' alt="monkey"/>
						
					</div>
				</div>
				<div class="pricing-tabel__right">
					<h3 class="pricing-tabel__right-heading">Vé tham quan và vui chơi</h3>
					<div>
						<div class="pricing-tabel__ticket">
							<span class="pricing-tabel__type">Người lớn (trên 12 tuổi)</span>
							<span class="pricing-tabel__price">60.000đ - 100.000đ</span>
						</div>
						<div class="pricing-tabel__ticket">
							<span class="pricing-tabel__type">Trẻ em (từ 2-11 tuổi)</span>
							<span class="pricing-tabel__price">40.000đ - 80.000đ</span>
						</div>
						<div class="pricing-tabel__ticket">
							<span class="pricing-tabel__type">Trẻ em (dưới 2 tuổi)</span>
							<span class="pricing-tabel__price">Miễn phí</span>
						</div>
					</div>
					<a href="tickets" class="link">
						<span>Mua vé ngay</span>
						<i class='fa fa-chevron-circle-right' style='color:rgba(223, 92, 92);'></i>
					</a>
					<hr style='color:rgba(223, 92, 92);border-bottom-width: 2px; border-bottom-style: solid;'/>
				</div>
			</div>
		</section>
		
		<section class="animals">
			<div class="img-right">
				<svg style="fill: #109e6c;" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="none" viewBox="0 0 737 700" class="callout-color__body-shape callout-color__body-shape--green"><path d="M23.745 700H737V0H31L0 155.137 44.354 299l-28.59 288.214L23.745 700z"></path></svg>
			</div>
			<div class="img-left">
				<svg style="fill: #ffc959;" aria-hidden="true" viewBox="0 0 54.477 603.316" xmlns="http://www.w3.org/2000/svg" class="base-symbol callout-color__image-shape callout-color__image-shape--green"><use xlink:href="/wp-content/themes/philadelphia-zoo/dist/svgs/symbol-callout-color-left.svg#icon"></use></svg>
			</div>
			<div class="main-img">
				<img class="img-back" src='<c:url value="/resources/images/bao.webp"></c:url>' alt="kingkong"/>
			</div>
			<div class="animals-detail-container">
				<div class="animals-detail-card">
					<div class="animals-detail">
						<h2 class="animals-detail-title">7 lớp động vật</h2>
						<p class="animals-detail-content">
							Hơn 1000 cá thể gồm hàng chục loài có vú, hàng chục giống chim, nhiều giống bò sát và giống có cánh các loại
						</p>
						<a class="btn-animals-detail" href="/ZooManagement/map">Khám phá động vật</a>
					</div>
				</div>
			</div>
		</section>
		
		<section class="link-cards">
			<div class="link-cards__inner">
				<div class="link-cards__left">
					<h2 class="link-cards__heading">Khám phá sở thú</h2>
					<div class="link-cards__wrapper">
						<a href="/ZooManagement/map" class="link-cards__link">
							<div class="link-cards__img-wrapper">
								<img class="link-cards__img" src='<c:url value="/resources/images/img1.webp"></c:url>' alt=""/>
							</div>
							<span class="link-cards__label">Zoo360</span>
						</a>
					</div>
				</div>
				<div class="link-cards__right">
					<div class="link-cards__wrapper2">
						<a href="/ZooManagement/map" class="link-cards__link">
							<div class="link-cards__img-wrapper2">
								<img class="link-cards__img" src='<c:url value="/resources/images/img2.webp"></c:url>' alt=""/>
							</div>
							<span class="link-cards__label">Zoo Map</span>
						</a>
					</div>
				</div>
			</div>
		</section>
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