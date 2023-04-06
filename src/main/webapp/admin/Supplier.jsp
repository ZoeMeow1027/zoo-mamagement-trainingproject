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
</head>
<body>
<jsp:include page="navbar.jsp" />

    <section class="home">
        		<div class="text">Supplier Page</div>
        <h2 class = "banner ">Supplier Management Table</h2>
        <div class = "banner">
			<a href="<%=request.getContextPath()%>/showAddSupplier" class="button-search" role="button">Add Supplier</a>
		</div>
          <c:url value="/SearchInventory" var="SearchInventory"/>
 		<form:form class = "searchform" action="SearchSupplier" method="post">
					<p class = "text2" >Search Information by:</p>
    								<select name="op" class="select">
      									 <option value="Supplier_Name">Tên</option>
      									 <option value="ID_Supplier_Type">Loại</option>
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
            <th>STT</th>
            <th>Tên nhà cung cấp</th>
            <th>Loại sản phẩm cung cấp</th>
            <th>Hợp đồng</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${supplier}" var="item">
        <tr>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.name}" /></td>
  			<td><c:out value="${item.supplierType.supplierType}" /></td>
            <td><c:out value="${item.contracts.details}" /></td>
            <td><a class = "bx bxs-edit bx-xs" style="text-decoration:none; color: green" href = "<%=request.getContextPath()%>/showEditSupplier?id=<c:out value="${item.id}" />">
  					</a>
  					&nbsp &nbsp
            <a class = "bx bxs-trash bx-xs" style="text-decoration:none; color: red " href = "<%=request.getContextPath()%>/deleteSupplier?id=<c:out value="${item.id}" />">
  					</a>
  					</td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
        </div>
    </section>

</body>
    <script src = '<c:url value="/resources/js/js-page-admin.js" />' ></script>
</html>