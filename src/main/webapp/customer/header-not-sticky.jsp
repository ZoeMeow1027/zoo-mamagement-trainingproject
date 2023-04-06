<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link href="<c:url value="/resources/css/style-header.css" />" rel="stylesheet">
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/ZooManagement/">
    	 <img src='<c:url value="/resources/images/logo.jpg"></c:url>' alt="Logo" width="80" height="70" />
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="/ZooManagement/">Trang chủ</a>
        <a class="nav-link" href="/ZooManagement/tickets">Mua vé</a>
        <a class="nav-link" href="/ZooManagement/map">Về chúng tôi</a>
        <div class="nav-item dropdown ml-3">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <img src='<c:url value="/resources/images/person-4.png"></c:url>' alt="person" width="30" height="30" />
          </a>
          <ul class="dropdown-menu dropdown-menu-end">
            <c:if test="${not empty username}">
	            <li><a class="dropdown-item" href="/ZooManagement/ticket-history/1">Lịch sử đặt vé</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="logout">Đăng xuất</a></li>
	        </c:if>
	        <c:if test="${empty username}">
	            <li><a class="dropdown-item" href="login">Đăng nhập</a></li>
	        </c:if>
          </ul>
        </div>
      </div>
    </div>
  </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>

