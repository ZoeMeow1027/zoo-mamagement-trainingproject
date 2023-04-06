<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory Management page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type ="text/css"> 
 <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
 <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp" />

    <section class="home">
<div class="container-xl px-4 mt-4">
    <!-- Account page navigation-->
    <div class="row">
        <div class="col-xl-8">
            <div class="card mb-4">
                <div class="card-header">Insert Supplier with Contract</div>
                <div class="card-body">
                	<c:choose>
    					<c:when test="${supplier.name==null}">
		    				<form:form class = "searchform" action="addSupplier" method="post">
		                    	<br/>
		                        <!-- Form Row-->
		                        <div class="row gx-3 mb-3">
		                            <!-- Form Group (first name)-->
		                            <div class="col-md-6">
		                                <label class="small mb-1" for="Title">Tên nhà cung cấp</label>
		                                <input class="form-control" value="${supplier.name}" name="name" type="text" >
		                            </div>
		                            <!-- Form Group (last name)-->
		                            <div class="col-md-6">
		                                <label class="small mb-1" for="Brief">Loại sản phẩm cung cấp</label>
		                                <select name="op" class="form-control">
		                                	<c:forEach items="${supplierType}" var="item">
		     									 <option value="${item.id}"><c:out value="${item.supplierType}" /></option>
		     								</c:forEach>
		    								</select>
		                            </div>
		                        </div>
		                        <br/>
		                        <!-- Form Group (email address)-->
		                        <div class="mb-3">
		                            <label class="small mb-1" for="Content">Chi tiết hợp đồng</label>
		                            <textarea name="detail" class="form-control" rows="10" cols="50">${supplier.contracts.details}</textarea>
		                        </div>
		                        <!-- Save changes button-->
		                        <br>
		                        <button class="button-search" type="submit">Save</button>
		                    </form:form>
    					</c:when>   
    					 
    					<c:otherwise>
    						<form:form class = "searchform" action="updateSupplier" method="post">
		                    	<br/>
		                        <!-- Form Row-->
		                        <div class="row gx-3 mb-3">
		                            <!-- Form Group (first name)-->
		                            <div class="col-md-6">
		                                <label class="small mb-1" for="Title">Tên nhà cung cấp</label>
		                                <input class="form-control" value="${supplier.name}" name="name" type="text" >
		                            </div>
		                            <!-- Form Group (last name)-->
		                            <div class="col-md-6">
		                                <label class="small mb-1" for="Brief">Loại sản phẩm cung cấp</label>
		                                <select name="op" class="form-control">
		                                	<c:forEach items="${supplierType}" var="item">
		     									 <option value="${item.id}"><c:out value="${item.supplierType}" /></option>
		     								</c:forEach>
		    								</select>
		                            </div>
		                            <input style="display: none;" class="form-control" value="${supplier.id}" name="idSupplier" type="text" >
		                            <input style="display: none;" class="form-control" value="${supplier.contracts.id}" name="idContracts" type="text" >
		                        </div>
		                        <br/>
		                        <!-- Form Group (email address)-->
		                        <div class="mb-3">
		                            <label class="small mb-1" for="Content">Chi tiết hợp đồng</label>
		                            <textarea name="detail" class="form-control" rows="10" cols="50">${supplier.contracts.details}</textarea>
		                        </div>
		                        <!-- Save changes button-->
		                        <br>
		                        <button class="button-search" type="submit">Edit</button>
		                    </form:form>
    					</c:otherwise>  					
					</c:choose>                   
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>
    </section>

</body>
    <script src = '<c:url value="/resources/js/js-page-admin.js" />' ></script>
</html>