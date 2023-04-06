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
		<div class="text">Staff Updating Page</div>
		<h2 class="banner ">Staff Updating</h2>
		<form:form modelAttribute="staffupdate" class="searchform" action="processupdatestaff" method="post">
			
			<button style="" class="button-search">Cập Nhật</button>

			<div class="table-wrapper" style="height: 50vh; overflow: auto">
				<table class="fl-table">
					<thead>
						<tr>
							<th>Mã NV</th>
							<th>Tên NV</th>
							<th>Lương</th>
							<th>Hợp đồng</th>
							<th>Loại nhân viên</th>
							<th>Username</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${staffList}" var="stafflist" >
					<tr>
						<td><form:input type="text" path="idStaff" value = "${stafflist.idStaff}" readonly="true"/></td>
						<td><form:input type="text" path="staffName" value="${stafflist.staffName}"/></td>
						<td><form:input type="text" path="salary" value="${stafflist.salary}"/></td>
						<td><a class="bx bx-notepad bx-xs"
							style="text-decoration: none; color: green" href="">${stafflist.idContract} </a></td>
							
						<%-- <c:forEach items="${staffTypeList}" var="stafftypelist">
						<c:if test="${stafflist.idStaffType == stafftypelist.idStaffType}">
						<td>${stafftypelist.staffType}</td>
						</c:if>
						</c:forEach> --%>
						
						<td>
						<select name="staffTypeClicked">
						<c:forEach items="${staffTypeList}" var="stafftypelist">
						<c:if test="${stafflist.idStaffType == stafftypelist.idStaffType}">
						<option value="${stafftypelist.idStaffType}" selected >${stafftypelist.staffType}</option>
						</c:if>
						<option value="${stafftypelist.idStaffType}">${stafftypelist.staffType}</option>
						</c:forEach>
						</select>
						</td>
						
						<td><form:input type="text" path="username" value="${stafflist.username}"/></td>
						
					</tr>
					</c:forEach>
				<tbody>
				</table>
			</div>
		</form:form>


	</section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>