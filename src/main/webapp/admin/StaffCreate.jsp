<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org">
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
		<div class="text">Staff Creating Page</div>
		<h2 class="banner ">Staff Creating</h2>
		<form:form modelAttribute="staff" class="searchform" action="staffcreate" method="post">
			
			<button style="" class="button-search">Thêm Mới</button>

			<div class="table-wrapper" style="height: 50vh; overflow: auto">
				<table class="fl-table">
					<thead>
						<tr>
							<!-- <th>Mã NV</th> -->
							<th>Tên NV</th>
							<th>Lương</th>
							<th>Loại nhân viên</th>
							<th>Username</th>

						</tr>
						
					</thead>
					<tbody>
						<tr>
							<!-- <th><input type="text"></th> -->
							<th><form:input type="text" path="staffName"/></th>
							<th><form:input type="text" path="salary"/></th>
							<%-- <th>
								<select class="select" name="staffTypeClicked">
									<options items="${staffTypeList}"/>
								</select>
							</th> --%>
							<th>
							
							<select name="staffTypeClicked">
							<c:forEach items="${staffTypeList}" var="stafftypelist" >
									<option value="${stafftypelist.idStaffType}">${stafftypelist.staffType}</option>
									<!-- <option value="2">Nhân viên thú y</option>
									<option value="3">Nhân viên viên vệ sinh</option>
									<option value="4">Nhân viên chăm sóc</option> -->
							</c:forEach>
							</select>
							
							</th>
							<th><form:input type="text" path="username"/></th>

						</tr>
					<tbody>
				</table>
			</div>
		</form:form>


	</section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>