<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-tickets-page.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style-add-ticket-order.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/themes/light.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.js"></script>
<title>Chào mừng bạn đến với Sở thú</title>
</head>
<body>
	<jsp:include page="header-not-sticky.jsp"></jsp:include>
	
	<main class="main-container">
		<div class="content-container">
		<c:if test="${not empty listTickets}">
			<h1 class="content-title">${listTickets.get(0).ticket_Type.ticket_Type }</h1>
			<div class="warning-container">
				<!-- <div class="message-container">
					<i class='fa fa-exclamation-circle' style='color:#0F9F6C;font-size:20px;margin-right:20px;'></i>
					<div style="font-size: 16px;">
						Bạn đã có tài khoản? 
						<a href="login">Đăng nhập</a>
						Chưa có tài khoản?
						<a href="#">Đăng ký ngay</a>
					</div>
				</div> -->
				<article >
					<figure class="ticket-detail">
						<img class="ticket-detail-img" src='<c:url value="/resources/images/img3.jpg"></c:url>' alt=""/>
						
					</figure>
					<div class="ticket-detail-desc" style="font-size:20px;">
						${listTickets.get(0).ticket_Type.ticket_Description }
					</div>
				</article>
				<form class="ticket-form">
					<div class="choose-container">
						<h2 class="choose-title">Chọn thông tin vé</h2>
						<div class="choose-date">
							<h3 class="choose-date-label">Chọn ngày</h3>
							<div class="choose-date-picker">
								<input class="choose-date-picker-input" id="basicDate" data-input placeholder="Chọn ngày" />
							</div>
						</div>
						<div class="select-amount">
							<h3 class="choose-date-label">Chọn số lượng vé</h3>
							<div class="tickets">
								<div class="tickets-group">
									<c:forEach var="ticket" items="${listTickets}">
										<div class="ticket-type">
											<div class="ticket-type-desc">
												<div class="ticket-type-desc-title">${ticket.ticket_Age.age_Description }</div>
												<div class="price-container">
													<div class="price-value">
														<c:if test="${ticket.price > 0 }">
															${ticket.price} đ
														</c:if>
														<c:if test="${ticket.price == 0 }">
															Miễn phí
														</c:if>
													</div>
												</div>
											</div>
											<div class="stepper">
												<button id="minus-btn${ticket.ticket_Age.id_Ticket_Age }" class="minus-btn" type="button" disabled onClick="changeCount(${ticket.ticket_Age.id_Ticket_Age}, ${ticket.amount }, 2);">-</button>
												<span id="count${ticket.ticket_Age.id_Ticket_Age }" class="count">0</span>
												<button id="plus-btn${ticket.ticket_Age.id_Ticket_Age }" class="plus-btn" type="button" onClick="changeCount(${ticket.ticket_Age.id_Ticket_Age}, ${ticket.amount }, 1);">+</button>
											</div>
										</div>
			      					</c:forEach>
									
									
								</div>
							</div>
						</div>
							<div id="message" class="message-container" style="background-color: #FDEBD3; display:none;">
								<i class='fa fa-exclamation-circle' style='color:rgb(223, 92, 92);font-size:30px;margin-right:20px;'></i>
								<div style="font-size: 20px;">
									Bạn phải chọn ngày và chọn số lượng vé!!!
								</div>
							</div>
						<div class="btn-container">
							<button class="add-btn" type="submit">Thêm vào giỏ hàng</button>
							<button class="back-btn" type="button" onclick="history.back();">Quay lại</button>
						</div>
					</div>
				</form>
			</div>
			<jsp:include page="cart.jsp"></jsp:include>
			 </c:if>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	
	<script >
	$("#basicDate").flatpickr({
	    enableTime: false,
	    minDate: "today",
	    dateFormat: "Y-m-d"
	});
	$(".ticket-form").submit(function(e){
		e.preventDefault();
		
		if(validateForm()){
			const now = new Date();
			let listTicket = JSON.parse(window.sessionStorage.getItem("listTicket")) || {tickets: [], expiry: now.getTime() + 600000};
	
			let item = listTicket.tickets.filter(ticket => ticket.id === (${listTickets.get(0).ticket_Type.id_Ticket_Type } + $('#basicDate').val()))[0];
			let idCountTicket = "";
			let ticketAge = {};
			if (item && item.date === $('#basicDate').val()) {
				<c:forEach var="ticket" items="${listTickets}">
					ticketAge = item.ticketAges.filter(age => age.id === ${ticket.ticket_Age.id_Ticket_Age })[0];
					idCountTicket = "#count" + ${ticket.ticket_Age.id_Ticket_Age };
					if (Number($(idCountTicket).text()) > 0) {
						if (ticketAge) {
							ticketAge.count = ticketAge.count + Number($(idCountTicket).text());
						} else {
							ticketAge = {
				        		id: ${ticket.ticket_Age.id_Ticket_Age },
				        		name: "${ticket.ticket_Age.age_Description }",
				        		count: Number($(idCountTicket).text()),
				        		price: ${ticket.price }
				        	};
			        		item.ticketAges.push(ticketAge);	
						}
					}
		    	</c:forEach>
			} else {
				item = {
					id: ${listTickets.get(0).ticket_Type.id_Ticket_Type } + $('#basicDate').val(),
				  	ticketType : "${listTickets.get(0).ticket_Type.ticket_Type }",
				  	date : $('#basicDate').val(),
				  	ticketAges: []
				};
				
				<c:forEach var="ticket" items="${listTickets}">
					idCountTicket = "#count" + ${ticket.ticket_Age.id_Ticket_Age };
					if (Number($(idCountTicket).text()) > 0) {
			        	ticketAge = {
			        		id: ${ticket.ticket_Age.id_Ticket_Age },
			        		name: "${ticket.ticket_Age.age_Description }",
			        		count: Number($(idCountTicket).text()),
			        		price: ${ticket.price }
			        	};
		        		item.ticketAges.push(ticketAge);
					}
		    	</c:forEach>
	
				listTicket.tickets.push(item);
			}
			
			window.sessionStorage.setItem("listTicket", JSON.stringify(listTicket));
			
			window.location.replace('/ZooManagement/tickets');
		} else {
			$("#message").css("display", "flex");
		}
	});
	
	function validateForm(){
		let idCountTicket = "";
		let check = false;
		<c:forEach var="ticket" items="${listTickets}">
			idCountTicket = "#count" + ${ticket.ticket_Age.id_Ticket_Age };
			if (Number($(idCountTicket).text()) > 0) {
	        	check = true;
			}
		</c:forEach>
		if ($('#basicDate').val() === "") {
			check = false;
		}
		return check;
	}
	
	function changeCount(id, amount, type){
		let idCount = "#count" + id;
		let idMinusBtn = "#minus-btn" + id;
		let idPlusBtn = "#plus-btn" + id;
		 $(idCount).html(function(i, val) { 
			 	if (type == 1){
			    	val = val*1 + 1;
			 	} else {
			 		val = val*1 - 1;
			 	}
		    	if (val > 0) {
		    		$(idMinusBtn).prop("disabled", false);
		    	} else {
		    		$(idMinusBtn).prop("disabled", true);
		    	}
		    	if (val >= amount) {
		    		$(idPlusBtn).prop("disabled", true);
		    	} else {
		    		$(idPlusBtn).prop("disabled", false);
		    	}
		    	return val;
		 });
	}
	</script>
</body>
</html>