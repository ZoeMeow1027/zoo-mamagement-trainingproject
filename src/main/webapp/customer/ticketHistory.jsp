<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-tickets-page.css" />" rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>Chào mừng bạn đến với Sở thú</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<main class="main-container" style="height: 88vh;">
		<div class = "form-search">
			<h1>Lịch sử mua vé</h1>
			<form class="d-flex" role="search" action="/ZooManagement/ticket-history/1" method="get" >
		        <input class="form-control me-2" type="search" placeholder="Nhập để tìm kiếm" aria-label="Search" name="search" value='<c:out value="${searchQuery}" />' />
		        <button class="btn btn-outline-success" type="submit" style="width: 50%;">Tìm kiếm</button>
		    </form>
		</div>
		
		<c:if test="${not empty listHistory}">
			<table class="table table-hover table-bordered" style="margin: 50px 0;">
			  <thead class="table-dark">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Tên vé</th>
			      <th scope="col">Loại vé</th>
			      <th scope="col">Ngày đến</th>
			      <th scope="col">Số lượng</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			  <c:forEach var="history" items="${listHistory}">
			    <tr>
			      <th scope="row">${history.id_Ticket_History }</th>
			      <td>${history.ticket.ticket_Type.ticket_Type }</td>
			      <td>${history.ticket.ticket_Age.age_Description }</td>
			      <td>${history.purchase_Date }</td>
			      <td>${history.amount }</td>
			    </tr>
			   </c:forEach> 
			  </tbody>
			</table>
			<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			    <c:if test="${currentPage > 1}">
			    	<li class="page-item">
				    	<a class="page-link" href="/ZooManagement/ticket-history/${currentPage-1}?search=${searchQuery}">Previous</a>
				    </li>
			    </c:if>
			    <c:if test="${currentPage == 1}">
			    	<li class="page-item disabled">
				    	<a class="page-link">Previous</a>
				    </li>
			    </c:if>

			      <c:forEach var = "i" begin = "1" end = "${totalPages}">
			      	<c:if test="${currentPage != i}">
 					    	<li class="page-item"><a class="page-link" href="/ZooManagement/ticket-history/${i}?search=${searchQuery}">${i}</a></li>
			      	</c:if>
			      	<c:if test="${currentPage == i}">
			      		<li class="page-item active" style="color: #fff;">
					      <a class="page-link" href="/ZooManagement/ticket-history/${i}" >${i}</a>
					    </li>
			      	</c:if>
			      </c:forEach>
			    
			    <c:if test="${currentPage < totalPages}">
			    	<li class="page-item">
				    	<a class="page-link" href="/ZooManagement/ticket-history/${currentPage+1}?search=${searchQuery}">Next</a>
				    </li>
			    </c:if>
			    <c:if test="${currentPage == totalPages}">
			    	<li class="page-item disabled">
				    	<a class="page-link">Next</a>
				    </li>
			    </c:if>
			  </ul>
			</nav>
		</c:if>
		<c:if test="${empty listHistory}">
			<div>Danh sách rỗng</div>
		</c:if>
	</main>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>