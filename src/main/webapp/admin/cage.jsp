<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cage Management page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='<c:url value="/resources/css/style-page-admin.css" />'
	rel="stylesheet" type="text/css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>
	<jsp:include page="navbar.jsp"/>
	<section class="home">
		<div class="text">Cage Page</div>
		<h2 class="banner ">Cage Management Table</h2>
		<form class="searchform"
			action="searchCage" method="post">
			<p class="text2">Search Information by:</p>
			<select class="select" id="option" name="option">
				<option>Mã chuồng</option>
				<option>Tên chuồng</option>
				<option>Người chăm sóc</option>
			</select>
			<p class="text2">Type here:</p>
			<div class="searchbar">
				<input type="search" id="option" name="search" placeholder='Search'>
			</div>
			<button class="button-search" type="submit">Search</button>
			<button class="button-search" type="reset">Reset</button>

		</form>
		<br> <br> <a href="<%=request.getContextPath()%>/showStaff" style="text-decoration: none">
			<button style="margin-left: 70px" class="button-search">Thêm
				chuồng</button>
		</a>
		<div class="table-wrapper">
			<table class="fl-table" style="overflow-y: auto;">
				<thead>
					<tr>
						<th>Mã chuồng</th>
						<th>Tên chuồng</th>
						<th>Giới hạn</th>
						<th>Người chăm sóc</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cage}" var="item">
						<tr>
							<td><c:out value="${item.idCage}" /></td>
							<td><c:out value="${item.nameCage}" /> <a
								class="bx bxs-message-edit bx-xs"
								style="text-decoration: none; color: blue" href="<%=request.getContextPath()%>/getAnimalbyIDCage?idCage=${item.idCage}"> </a> &nbsp
								&nbsp</td>
							<td><c:out value="${item.limit}" /></td>
							<td><c:out value="${item.staffs.staffName}" /></td>
							<td><a class="bx bxs-edit bx-xs"
								style="text-decoration: none; color: green"
								href="<%=request.getContextPath()%>/showCageInfo?idCage=${item.idCage}">
							</a> &nbsp &nbsp <a class="bx bxs-trash bx-xs"
								style="text-decoration: none; color: red" href="#"
								onclick="confirmDelete(${item.idCage})"> </a></td>
						</tr>
					</c:forEach>
				<tbody>
			</table>
		</div>
	</section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
<script>
function confirmDelete(cageId) {
	  if (confirm("Bạn có chắc muốn xóa cage này không?")) {
	    window.location.href = "deleteCage?idCage=" + cageId;
	  }
	}      
</script>
</html>