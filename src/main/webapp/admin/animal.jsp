<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Animal Management page</title>
    <link href="CSS/test.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type="text/css">
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <section class="home">
        <div class="text">Animal Page</div>
        <h2 class="banner ">Animal Management Table</h2>
        <form class="searchform" action="" method="post">
            <p class="text2">Search Information by:</p>
            <select class="select">
                <option value="1">Tên</option>
                <option value="2">Loài</option>
                <option value="3">Chuồng</option>
                <option value="4">Loại thức ăn</option>
            </select>
            <p class="text2">Type here:</p>
            <div class="searchbar"><input type="search" placeholder='Search'></div>
            <button class="button-search" type="submit">Search</button>
            <button class="button-search" type="reset">Reset</button>
        </form>
        <br>
        <br>
        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>Tên</th>
                        <th>Loài</th>
                        <th>Chuồng</th>
                        <th>Trạng thái</th>
                        <th>Loại thức ăn</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Testing1</td>
                        <td>Testing1</td>
                        <td>Testing1</td>
                        <td>Testing1</td>
                        <td>Testing1</td>
                        <td><a class="bx bxs-edit bx-xs" style="text-decoration:none; color: green" href="">
                            </a>
                            &nbsp &nbsp
                            <a class="bx bxs-trash bx-xs" style="text-decoration:none; color: red " href="">
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>Testing2</td>
                        <td>Testing2</td>
                        <td>Testing2</td>
                        <td>Testing2</td>
                        <td>Testing2</td>
                        <td><a class="bx bxs-edit bx-xs" style="text-decoration:none; color: green" href="">
                            </a>
                            &nbsp &nbsp
                            <a class="bx bxs-trash bx-xs" style="text-decoration:none; color: red " href="">
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>Testing3</td>
                        <td>Testing3</td>
                        <td>Testing3</td>
                        <td>Testing3</td>
                        <td>Testing3</td>
                        <td><a class="bx bxs-edit bx-xs" style="text-decoration:none; color: green" href="">
                            </a>
                            &nbsp &nbsp
                            <a class="bx bxs-trash bx-xs" style="text-decoration:none; color: red " href="">
                            </a>
                        </td>
                    </tr>
                <tbody>
            </table>
        </div>
        </div>
    </section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>