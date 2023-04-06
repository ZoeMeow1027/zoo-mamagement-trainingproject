<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value='${ticketData != null ? "Edit" : "Add a"}' /> ticket<c:out value='${ticketData != null ? String.format(" ID = %d", ticketData.id_Ticket) : ""}' /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type="text/css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <%-- Page variables --%>
    <c:set var="myContext" value="${pageContext.request.contextPath}"/>
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <section class="home">
        <div class="text">
            <a href="${myContext}/admin/tickets"><i class='bx bx-left-arrow-alt' style="border: solid; border-width: 2px; border-radius: 100px;"></i></a>
            <c:out value='${ticketData != null ? "Edit" : "Add"}' /> a ticket
        </div>
        <form name="editform" id="editform" class="searchform" action="${myContext}/admin/tickets/${ticketData == null ? "add" : "edit"}" onsubmit="return validateFormEdit()" method="post">
            <c:if test="${ticketData != null}">
                <p class="text2">ID: </p>
                <div class="searchbar"><input type="text" name="id" readonly value='${ticketData.id_Ticket}'></div>
                <br>
            </c:if>
            <p class="text2">Ticket type (hover option for description):</p>
            <select class="select" name="typeid">
                <c:forEach var="item" items="${ticketTypeList}">
                    <option value="${item.id_Ticket_Type}" title="${item.ticket_Description}" <c:out value='${item.id_Ticket_Type == ticketData.ticket_Type.id_Ticket_Type ? "selected" : ""}' />>${item.ticket_Type}</option>
                </c:forEach>
            </select>
            <br>
            <p class="text2">Ticket age:</p>
            <select class="select" name="typeageid">
                <c:forEach var="item" items="${ticketAgeList}">
                    <option value="${item.id_Ticket_Age}" title="${item.age_Description}" <c:out value='${item.id_Ticket_Age == ticketData.ticket_Age.id_Ticket_Age ? "selected" : ""}' />>${item.age_Description}</option>
                </c:forEach>
            </select>
            <br>
            <p class="text2">Amount: </p>
            <div class="searchbar"><input type="text" name="amount" value="${ticketData.amount == null ? "" : ticketData.amount}"></div>
            <br>
            <p class="text2">Price: </p>
            <div class="searchbar"><input type="text" name="price" value="${ticketData.price == null ? "" : ticketData.price}"></div>
            <br>
            <input class="button-search" type="submit" value="<c:out value='${ticketData != null ? "Save changes" : "Add"}' />">
            <input class="button-search" type="reset" value="Reset data">
        </form>
    </section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
<script src='<c:url value="/resources/js/admin-ticket-manager.js" />'></script>
</html>