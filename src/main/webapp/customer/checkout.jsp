<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-tickets-page.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style-add-ticket-order.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style-payment.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Chào mừng bạn đến với Sở thú</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header-not-sticky.jsp"></jsp:include>
	
	<main class="main-container">
		<div >
			<form:form id="form-checkout" method="post" modelAttribute="customer" class="content-container" onsubmit = "return(validate());">
			<h1 class="content-title">Thông tin thanh toán</h1>
			<div class="warning-container">
			<div class="form-wrapper">
				<!-- <div class="message-container">
					<i class='fa fa-exclamation-circle' style='color:#0F9F6C;font-size:20px;margin-right:20px;'></i>
					<div style="font-size: 16px;">
						Bạn đã có tài khoản? 
						<a href="login">Đăng nhập</a>
						Chưa có tài khoản?
						<a href="#">Đăng ký ngay</a>
					</div>
				</div> -->
				<div class="payment">
					<h2 class="title-section">Thanh toán qua VNPAY</h2>
					<div class="payment-detail">
						Thanh toán trực tuyến qua VNPAY – Xác nhận tức thời – An toàn – Nhanh chóng
						</br>Hỗ trợ: Thanh toán quét mã VNPAY – Thẻ ATM và tài khoản ngân hàng – Thẻ thanh toán quốc tế VISA/Master Card – Ví điện tử VNPAY
					</div>
				</div>
				<div class="purchase-details">
					<h2 class="title-section">Thông tin khách hàng</h2>
					<div class="identity-form">
						<div class="form-input-group">
							<label class="form-input">
								<span class="label">Họ và tên</span>
								<form:input path="customer_Name" type="text" name="name" id="name" class="input"/>
								<span id="name-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường họ tên không được để trống.</span>
							</label>
							<label class="form-input">
								<span class="label">Địa chỉ</span>
								<form:input path="address" type="text" name="address" id="address" class="input"/>
								<span id="address-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường địa chỉ không được để trống.</span>
							</label>
							<label class="form-input">
								<span class="label">Số điện thoại</span>
								<form:input path="phone" type="text" name="phone" id="phone" class="input"/>
								<span id="phone-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường số điện thoại không được để trống và phải đúng định dạng.</span>
								
							</label>
							<label class="form-input">
								<span class="label">Email</span>
								<form:input path="email" type="email" name="email" id="email" class="input"/>
								<span id="email-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường email không được để trống và phải đúng định dạng.</span>
								
							</label>
						</div>
					</div>
					
				</div>
				<div class="btn-container flex-end">
					<button class="back-btn" type="button" onclick="history.back();">Quay lại</button>
				</div>
			</div>
			</div>
			<jsp:include page="cartCheckout.jsp"></jsp:include>
			</form:form>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script>			
		const validatePhone = (phone) => {
		  return phone.match(
		    /^(0|\(84\)\+)(90|91)[0-9]{7}$/
		  );
		};	
		
		const validateEmail = (email) => {
		  return email.match(
			  /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
		  );
		};
	
		function validate() {
			let check;
			
			if( document.getElementById("name").value == "" ) {
	            document.getElementById("name").classList.add("is-invalid");
	            document.getElementById("name-invalid").style.display = "block";
	            check = false;
	         } else {
	            document.getElementById("name").classList.remove("is-invalid");
	            check = true;
	         }
			
			if( document.getElementById("address").value == "" ) {
	            document.getElementById("address").classList.add("is-invalid");
	            document.getElementById("address-invalid").style.display = "block";
	            check = false;
	         } else {
	            document.getElementById("address").classList.remove("is-invalid");
	            check = true;
	         }
			
			if( document.getElementById("phone").value == "" || !validatePhone(document.getElementById("phone").value)) {
	            document.getElementById("phone").classList.add("is-invalid");
	            document.getElementById("phone-invalid").style.display = "block";
	            check = false;
	         } else {
	            document.getElementById("phone").classList.remove("is-invalid");
	            check = true;
	         }
			
			if( document.getElementById("email").value == "" || !validateEmail(document.getElementById("email").value)) {
	            document.getElementById("email").classList.add("is-invalid");
	            document.getElementById("email-invalid").style.display = "block";
	            check = false;
	         } else {
	            document.getElementById("email").classList.remove("is-invalid");
	            check = true;
	         }
			
			return check;
		}
		
		$("#form-checkout").submit(function(e){
			e.preventDefault();
			
			if(validate()) {
				let listTicket = JSON.parse(window.sessionStorage.getItem("listTicket"));
				let data = {};
				data["ticket-amount"] = listTicket.tickets.length;
				listTicket.tickets.forEach((ticket, id1) => {
					let idTicket = ticket.id[0];
					let date = ticket.date;
					data["age-amount"+ date + (id1 + 1)] = ticket.ticketAges.length;
					ticket.ticketAges.forEach((age, id) => {
						data["idTicket" + date + (id1+1)] = idTicket;
						data["date" + (id1+1)] = date;
						data["idTicketAge" + date + (id1+1) + (id+1)] = age.id;
						data["amount"+ date + (id1+1) + (id+1)] = age.count;
					});
				});
				data["customer_Name"] = $("#name").val();
				data["address"] = $("#address").val();
				data["phone"] = $("#phone").val();
				data["email"] = $("#email").val();
				
				$.ajax({
					type: "GET",
					contentType: "application/json; charset=utf-8",
					url: "/ZooManagement/insertTicketHistory",
					data : data,
					dataType : 'json',
					success: function(result) {	
						window.sessionStorage.removeItem("listTicket");
						window.location.replace('/ZooManagement/' + result.responseText);
					},
					error: function(e) {
						window.sessionStorage.removeItem("listTicket");
						window.location.replace('/ZooManagement/' + e.responseText);
					}
				});
			}
		});
	</script>
</body>
</html>