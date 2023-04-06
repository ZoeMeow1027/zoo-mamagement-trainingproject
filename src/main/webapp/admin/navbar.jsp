<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type="text/css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<c:set var="myContext" value="${pageContext.request.contextPath}"/>

<nav class="sidebar close">
	<header>
		<div class="image-text">
			<span class="image"> <img
				src='<c:url value="/resources/images/eevee.png"></c:url>'>
			</span>
			<div class="text logo-text">
				<span class="name">${username }</span> <span class="profession">Admin
					Site</span>
			</div>
		</div>
		<i class='bx bx-chevron-right toggle'></i>
	</header>
	<div class="menu-bar">
		<div class="menu">
			<ul class="menu-links">
				<li class="nav-link"><a href="${myContext}/"> <i
						class='bx bx-home-alt icon'></i> <span class="text nav-text">Home</span>
				</a></li>
				<li class="nav-link"><a href="${myContext}/showAllCage"> <i
						class='bx bxs-castle icon'></i> <span class="text nav-text">Quản
							lý chuồng</span>
				</a></li>
				<li class="nav-link"><a href="${myContext}/viewInventory"> <i
						class='bx bx-box icon'></i> <span class="text nav-text">Quản
							lý kho</span>
				</a></li>
				<li class="nav-link"><a href="${myContext}/admin/tickets"> <i
						class="bx bxs-coupon icon <c:out value='${param.navToggle == "tickets" ? "active" : ""}' />"></i> <span class="text nav-text">Quản
							lý đặt vé</span>
				</a></li>
				<li class="nav-link"><a href="${myContext}/stafflist"> <i
						class='bx bx-user icon'></i> <span class="text nav-text">Quản
							lý nhân viên</span>
				</a></li>
				<li class="nav-link"><a href="${myContext}/admin/ticket-history"> <i
						class='bx bx-history icon'></i> <span class="text nav-text">Lịch sử bán vé</span>
				</a></li>
				<li class="nav-link"><a href="Revenue.jsp"> <i
						class='bx bx-pie-chart-alt icon'></i> <span class="text nav-text">Doanh
							thu</span>
				</a></li>
			</ul>
		</div>
		<div class="bottom-content">
			<li class=""><a href="${myContext}/logout"> <i class='bx bx-log-out icon'></i>
					<span class="text nav-text">Logout</span>
			</a></li>
			<li class="mode">
				<div class="sun-moon">
					<i class='bx bx-moon icon moon'></i> <i class='bx bx-sun icon sun'></i>
				</div> <span class="mode-text text">Dark mode</span>

				<div class="toggle-switch">
					<span class="switch"></span>
				</div>
			</li>
		</div>
	</div>
</nav>
