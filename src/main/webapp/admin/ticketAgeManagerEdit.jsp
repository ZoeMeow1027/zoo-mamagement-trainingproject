<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value='${ticketAgeData != null ? "View and edit" : "Add a"}' /> ticket age<c:out value='${ticketAgeData != null ? String.format(" ID = %d", ticketAgeData.id_Ticket_Age) : ""}' /></title>
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
            <a href="${myContext}/admin/tickets/ticket-age"><i class='bx bx-left-arrow-alt' style="border: solid; border-width: 2px; border-radius: 100px;"></i></a>
            <c:out value='${ticketAgeData != null ? "Edit" : "Add"}' /> a ticket age
        </div>
        <form name="editformage" id="editformage" class="searchform" action="${myContext}/admin/tickets/ticket-age/${ticketAgeData == null ? "add" : "edit"}" onsubmit="return validateFormAgeEdit()" method="post">
            <c:if test="${ticketAgeData != null}">
                <p class="text2">ID: </p>
                <div class="searchbar"><input type="text" name="id" readonly value='${ticketAgeData.id_Ticket_Age}'></div>
                <br>
            </c:if>
            <p class="text2">Age description: </p>
            <div class="searchbar"><input type="text" name="desp" value="${ticketAgeData.age_Description == null ? "" : ticketAgeData.age_Description}"></div>
            <br>
            <input class="button-search" type="submit" value="<c:out value='${ticketAgeData != null ? "Save changes" : "Add"}' />">
            <input class="button-search" type="reset" value="Reset data">
        </form>
    </section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
<script src='<c:url value="/resources/js/admin-ticket-manager.js" />'></script>
</html>