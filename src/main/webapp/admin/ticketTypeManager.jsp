<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ticket type manager</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type="text/css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <%-- Page variables --%>
    <c:set var="myContext" value="${pageContext.request.contextPath}"/>
</head>
<body>
    <jsp:include page="navbar.jsp">
        <jsp:param name="navToggle" value="tickets"/>
    </jsp:include>
    <section class="home">
        <div class="text">
            <a href="${myContext}/admin/tickets"><i class='bx bx-left-arrow-alt' style="border: solid; border-width: 2px; border-radius: 100px;"></i></a>
            Ticket type management
        </div>
        <h2 class="banner ">Ticket type management table</h2>
        <form class="searchform" action="${myContext}/admin/tickets/ticket-type" method="get">
            <p class="text2">Find a ticket type:</p>
            <div class="searchbar"><input type="search" name="q" placeholder='Enter a query here...' value='<c:out value="${searchQuery}" />'></div>
            <button class="button-search" type="submit">Search</button>
            <button class="button-search" type="reset">Reset data</button>
        </form>
        <br>
        <br>
        <%-- TODO: Add a ticket here --%>
        <a href="${myContext}/admin/tickets/ticket-type/add" style="text-decoration: none;">
            <button style="margin-left: 70px" class="button-search">Add a ticket type</button>
        </a>
        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${ticketType}">
                        <tr>
                            <td>${item.id_Ticket_Type}</td>
                            <td>${item.ticket_Type}</td>
                            <td>${item.ticket_Description}</td>
                            <td>
                                <%-- <form action="${myContext}/admin/tickets/delete?id=${item.id_Ticket}" method="post"> --%>
                                    <a class="bx bxs-edit bx-xs" style="text-decoration:none; color: green" href="${myContext}/admin/tickets/ticket-type/edit?id=${item.id_Ticket_Type}"></a>
                                    &nbsp &nbsp
                                    <button onclick="deleteTypeConfirm(${item.id_Ticket_Type})" class="bx bxs-trash bx-xs" style="text-decoration:none; color: red; border: none; background-color: transparent; cursor: pointer;"></button>
                                <%-- </form> --%>
                            </td>
                        </tr>
                    </c:forEach>
                <tbody>
            </table>
        </div>
        </div>
        <form id="deleteForm" action="${myContext}/admin/tickets/ticket-type/delete" method="post">
            <input type="text" name="id" id="deleteFormId" style="display: none;">
        </form>
    </section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
<script src='<c:url value="/resources/js/admin-ticket-manager.js" />'></script>
</html>