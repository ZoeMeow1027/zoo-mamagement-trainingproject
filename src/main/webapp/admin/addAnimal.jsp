<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Animal page</title>
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
						<div class="card-header">Create Animal</div>
						<div class="card-body">
							<form action="addAnimal" method="post">
								<div class="row gx-3 mb-3">
								<div class="col-md-6">
										<label class="small mb-1" for="idCage">ID chuồng</label> <input
											 readonly class="form-control" id="idCage" name="idCage"
											type="text" placeholder=""
											value = "${idCage}">
									</div>
									<div class="col-md-6">
										<label class="small mb-1" for="animalName">Tên động vật</label> <input
											class="form-control" id="animalName" name="animalName"
											type="text" placeholder="Nhập tên động vật">
									</div>
								</div>
								<div class="mb-3">
									<label class="small mb-1" for="status">Trạng thái</label> <input
										class="form-control" id="status" name="status" type="text"
										placeholder="Nhập trạng thái">
								</div>
								<div class="mb-3">
									<label class="small mb-1" for="detail">Thông tin thêm</label> <input
										class="form-control" id="detail" name="detail" type="text"
										placeholder="Nhập thông tin thêm">
								</div>
								<div class="mb-3">
									<label class="small mb-1" for="food">Thức ăn</label> <input
										class="form-control" id="food" name="food" type="text"
										placeholder="Nhập thức ăn">
								</div>
								<br> <label class="small mb-1" for="type">Loài động vật
								</label> <select class="select" id="type" name="type">
									<option value="">-- Chọn loài --</option>
										<c:forEach var="type" items="${typeList}">
										<option value="<c:out value="${type.idAnimalType}"/>">${type.animalType}</option>
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