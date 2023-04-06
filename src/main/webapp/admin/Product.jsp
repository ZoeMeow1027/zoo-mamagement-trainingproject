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
 <jsp:include page="navbar.jsp"/>

    <section class="home">
        		<div class="text">Product Page In <c:out value="${inventory}" /></div>
        <h2 class = "banner ">Product Management Table</h2>
          <c:url value="/SearchInventory" var="SearchInventory"/>
 		<form:form class = "searchform" action="searchProduct" method="post">
					<p class = "text2" >Search Information by:</p>
    								<select name="op" class="select">
      									 <option value="Product_Name">Tên sản phẩm</option>
      									 <option value="Supplier_Name">Nhà cung cấp</option>
      									 <option value="Price">Đơn Giá</option>
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
            <th>Tên sản phẩm</th>
            <th>Số lượng tồn kho</th>
            <th>Nhà cung cấp</th>
            <th>Đơn Giá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${product}" var="item">
        <tr>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.name}" />
            	&nbsp &nbsp
  				<a class = "bx bxs-box bx-xs" style="text-decoration:none; color: blue " href = "">
  					</a></td>
            <td><c:out value="${item.amount}" /></td>
            <td><c:out value="${item.supplier.name}" /></td>
            <td><c:out value="${item.price}" /></td>
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