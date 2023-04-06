<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Cage page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='<c:url value="/resources/css/style-page-admin.css" />'
	rel="stylesheet" type="text/css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>
	<jsp:include page="navbar.jsp"/>
	<section class="home">
		<div class="container-xl px-4 mt-4">
			<hr class="mt-0 mb-4">
			<div class="row">
				<div class="col-xl-8">
					<!-- Account details card-->
					<div class="card mb-4">
						<div class="card-header">Create Cage</div>
						<div class="card-body">
							<form action="addCage" method="post">
								<div class="row gx-3 mb-3">
									<div class="col-md-6">
										<label class="small mb-1" for="cageName">Tên chuồng</label> <input
											class="form-control" id="cageName" name="cageName"
											type="text" placeholder="Nhập tên chuồng">
									</div>
								</div>
								<div class="mb-3">
									<label class="small mb-1" for="limit">Giới hạn</label> <input
										class="form-control" id="limit" name="limit" type="text"
										placeholder="Nhập giới hạn">
								</div>
								<br> <label class="small mb-1" for="staffName">Người
									chăm sóc</label> <select class="select" id="staffName" name="staffName">
									<option value="">-- Select a staff --</option>
									<c:forEach var="staff" items="${staffList}">
										<option value="<c:out value="${staff.idStaff}"/>">${staff.staffName}</option>
									</c:forEach>
								</select> <br> <br>
								<button class="button-search" type="submit">Save</button>
							</form>
							<br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>