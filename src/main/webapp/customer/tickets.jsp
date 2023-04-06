<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-tickets-page.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Chào mừng bạn đến với Sở thú</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header-not-sticky.jsp"></jsp:include>
	
	<main class="main-container">
		<div class="content-container">
			<h1 class="content-title">Chọn loại vé</h1>
			<div class="warning-container">
				<div class="tickets-list">
				<c:if test="${not empty ticketTypeList}">
			      <c:forEach var="ticketType" items="${ticketTypeList}">
						<article class="ticket">
							<a href="tickets/${ticketType.id_Ticket_Type }" class="ticket-img-link">
								<figure>
									<img class="ticket-img" src='<c:url value="/resources/images/img3.jpg"></c:url>' alt=""/>
									
								</figure>
							</a>
							<a href="tickets/${ticketType.id_Ticket_Type }" class="ticket-name">
								<h2 class="ticket-name-content">${ticketType.ticket_Type}</h2>
							</a>
							<div class="ticket-desc">
								${ticketType.ticket_Description }
							</div>
							<a href="tickets/${ticketType.id_Ticket_Type }" class="ticket-link">Chọn</a>
						</article>
			      </c:forEach>
			    </c:if>
				</div>
			</div>
			<jsp:include page="cart.jsp"></jsp:include>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>