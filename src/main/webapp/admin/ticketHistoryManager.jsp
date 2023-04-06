<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ticket history</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type="text/css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <%-- Page variables --%>
    <c:set var="myContext" value="${pageContext.request.contextPath}"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <section class="home">
        <div class="text">Ticket history management</div>
        <h2 class="banner ">Ticket history management table</h2>
        <form class="searchform" action="${myContext}/admin/ticket-history" method="get">
            <p class="text2">Find a ticket history:</p>
            <div class="searchbar"><input type="search" name="q" placeholder='Enter a query here...' value='<c:out value="${searchQuery}" />'></div>
            <button class="button-search" type="submit">Search</button>
            <button class="button-search" type="reset">Reset data</button>
        </form>
        <br>
        <br>
        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Purchase Date</th>
                        <th>Amount</th>
                        <th>Ticket Type</th>
                        <th>Ticket Age Description</th>
                        <th>Customer Name</th>
                        <th>Staff Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${ticketHistoryList}">
                        <tr>
                            <td>${item.id_Ticket_History}</td>
                            <td>${item.purchase_Date}</td>
                            <td>${item.amount}</td>
                            <td>${item.ticket.ticket_Type.ticket_Type}</td>
                            <td>${item.ticket.ticket_Age.age_Description}</td>
                            <td>${item.customer.customer_Name}</td>
                            <td>${item.staff.staffName}</td>
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