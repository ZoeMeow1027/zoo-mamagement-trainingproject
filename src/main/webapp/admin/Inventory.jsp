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

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp" />

    <section class="home">
        		<div class="text">Inventory Page</div>
        <h2 class = "banner ">Inventory Management Table</h2>
        <div class = "banner">
			<a href="<%=request.getContextPath()%>/viewSupplier" class="btn btn-info button-search" role="button">View Supplier</a>
			<a href="<%=request.getContextPath()%>/viewBillDetail" class="btn btn-info button-search" role="button">View Bill</a>
		</div>
          <c:url value="/SearchInventory" var="SearchInventory"/>
 		<form:form class = "searchform" action="SearchInventory" method="post">
					<p class = "text2" >Search Information by:</p>
    								<select name="op" class="select">
     									 <option value="ID_Inventory">Mã kho</option>
      									 <option value="Inventory_Name">Tên kho</option>
      									 <option value="Inventory_Address">Địa chỉ</option>
      									 <option value="ID_Inventory_Type">Loại kho</option>
    								</select>
                	<p class = "text2" >Type here:</p>
  						<div class="searchbar"><input name="search" type="search" placeholder='Search' /></div>
  						<button class = "button-search" type = "submit">Search</button>
                		<button class = "button-search" type = "reset">Reset</button>

        </form:form>
<br>
<br>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Mã kho</th>
            <th>Tên kho</th>
            <th>Địa chỉ</th>
            <th>Loại kho</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${inventory}" var="item">
        <tr>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.name}" />
            	&nbsp &nbsp
  				<a class = "bx bxs-box bx-xs" style="text-decoration:none; color: blue " href = "<%=request.getContextPath()%>/viewProduct?id=<c:out value="${item.id}-${item.name}" />">
  					</a></td>
            <td><c:out value="${item.address}" /></td>
            <td><c:out value="${item.productType.name}" /></td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
        </div>
    </section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>