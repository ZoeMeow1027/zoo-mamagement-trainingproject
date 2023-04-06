<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/resources/css/style-cart.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<div class="aside">
	<div class="cart">
		<section class="cart-container">
			<h2 class="cart-title">Chi tiết giỏ hàng</h2>
			<div class="content">
				<p id="empty" class="empty-card">Bạn chưa có hàng nào trong giỏ.</p>
				
			</div>
		</section>
	</div>
</div>

<script>
	const now = new Date();
	let listTicket = JSON.parse(window.sessionStorage.getItem("listTicket"));
	
	if (!listTicket) {
		$("#empty").css("display", "block");
		
	} else {
		if (now.getTime() > listTicket.expiry) {
			localStorage.removeItem("listTicket");
		} else {
			$("#empty").css("display", "none");
			let totalPrice = 0;
			$("#empty").after('<div id="cart">' +
					'<div class="expiry-timer">' +
					'<div class="message-timer">' +
						'<svg class="svg" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" class="clock-icon default svg-icon"><!----><path d="M512 0C229.232 0 0 229.232 0 512c0 282.784 229.232 512 512 512 282.784 0 512-229.216 512-512C1024 229.232 794.784 0 512 0zm0 961.008c-247.024 0-448-201.984-448-449.01 0-247.024 200.976-448 448-448s448 200.977 448 448-200.976 449.01-448 449.01zm32-462V192.002c0-17.664-14.336-32-32-32s-32 14.336-32 32v320c0 9.056 3.792 17.2 9.856 23.007.529.624.96 1.296 1.537 1.887l158.384 158.4c12.496 12.481 32.752 12.481 45.248 0 12.496-12.496 12.496-32.768 0-45.264z"></path></svg>' +
						'<span class="messeage-content">Xóa vé sau 5s nếu bạn không thanh toán</span>' +
					'</div>' +
				'</div>' +
				'<div class="tickets-cart">' +
				'</div>' +
				'<div class="total-price">' +
					'<section class="total-due">' +
						'<h3 class="total-title">Tổng tiền</h3>' +
						'<div class="price-wrapper total-value">0</div>' +
					'</section>' +
				'</div>' +
				'<div class="action">' +
					'<div class="pay-btn-wrapper">' +
						'<button type="submit" class="purchase">Hoàn thành thanh toán</button>' +
					'</div>' +
				'</div>' +
			'</div>');
			let ticketID = "";
			listTicket.tickets.forEach(ticket => {
				$(".tickets-cart").append('<div class="cart-ticket-wrapper">' +
						'<div id="remove'+ ticket.id +'" class="cart-item-remove" style="display: none">' +
							'<p class="remove-message">Remove item</p>' +
							'<div class="action">' +
								'<button class="cancel-remove-btn" onClick="handleCancelRemove(\''+ ticket.id +'\');">Cancel</button>' +
								'<button class="confirm-btn" onClick="handleRemove(\''+ ticket.id +'\');">Confirm</button>' +
							'</div>' +
						'</div>' +
						'<div class="cart-ticket-item">' +
						'<header class="cart-item-header">' +
							'<figure class="cart-item-figure">' +
								'<img class="cart-ticket-img" src=\'<c:url value="/resources/images/img3.jpg"></c:url>\' alt=""/>' +
								
							'</figure>' + 
							'<div class="header-content">' +
								'<h4 class="title">'+ ticket.ticketType +'</h4>' +
								'<div class="ticket-date">'+ ticket.date +'</div>' +
							'</div>' +
							'<div class="action">' +
								'<button type="button" class="remove-btn" onClick="showRemove(\''+ticket.id+'\');">' +
									'<svg width="20px" height="20px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" stroke="#df5c5c"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round" stroke="#CCCCCC" stroke-width="0.624"></g><g id="SVGRepo_iconCarrier"> <g id="Interface / Trash_Full"> <path id="Vector" d="M14 10V17M10 10V17M6 6V17.8C6 18.9201 6 19.4798 6.21799 19.9076C6.40973 20.2839 6.71547 20.5905 7.0918 20.7822C7.5192 21 8.07899 21 9.19691 21H14.8031C15.921 21 16.48 21 16.9074 20.7822C17.2837 20.5905 17.5905 20.2839 17.7822 19.9076C18 19.4802 18 18.921 18 17.8031V6M6 6H8M6 6H4M8 6H16M8 6C8 5.06812 8 4.60241 8.15224 4.23486C8.35523 3.74481 8.74432 3.35523 9.23438 3.15224C9.60192 3 10.0681 3 11 3H13C13.9319 3 14.3978 3 14.7654 3.15224C15.2554 3.35523 15.6447 3.74481 15.8477 4.23486C15.9999 4.6024 16 5.06812 16 6M16 6H18M18 6H20" stroke="#df5c5c" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path> </g> </g></svg>' +										
								'</button>' +
							'</div>' +
						'</header>' +
						'<div class="content-wrapper">' +
							'<div class="tickets-content">' +
								'<div class="ticket-types'+ ticket.id +'">' +
			
								'</div>' +
							'</div>' +
						'</div>' +
						
					'</div>' +
				'</div>');
				ticketID = ".ticket-types" + ticket.id;
				ticket.ticketAges.forEach(ticketAge => {
					$(ticketID).append('<div class="cart-ticket-type">' +
							'<div class="type-count">' +
							'<span class="ticket-count">'+ ticketAge.count +'</span>' +
							'<span class="cross">x</span>' + 
							'<span class="name">'+ ticketAge.name +'</span>' +	
						'</div>' +
						'<div class="price-wrapper">' +
							+ (ticketAge.count * ticketAge.price) +' đ' +
						'</div>' +
					'</div>');
					totalPrice = totalPrice + ticketAge.count * ticketAge.price;
				});
			});
			
			$(".total-value").text(totalPrice + " đ");
		}
	}
	
	function showRemove(id){
		let idRemove = "#remove" + id;
		$(idRemove).css("display", "inline-block");
	}
	
	function handleCancelRemove(id) {
		let idRemove = "#remove" + id;
		$(idRemove).css("display", "none");
	}
	
	function handleRemove(id) {
		listTicket.tickets = listTicket.tickets.filter(ticket => ticket.id !== id);
		if (listTicket.tickets.length === 0){
			window.sessionStorage.removeItem("listTicket");
		} else {
			window.sessionStorage.setItem("listTicket", JSON.stringify(listTicket));
		}
		location.reload();
	}
</script>