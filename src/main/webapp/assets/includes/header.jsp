<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Inventory Management</title>
    <link rel="shortcut icon" href="<c:url value='/assets/images/logo.jpg'/>">
    <link rel="stylesheet" href="<c:url value='/assets/css/main.css'/> ">
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
</head>

<body>

    <header>
        <img src="<c:url value='/assets/images/logo.jpg'/>"
             alt="Fresh Corn Records Logo" width="58">
        <h1>Inventory Management</h1>
        <h2>Organized And Efficient!</h2>
    </header>
    <nav id="nav_bar">
        <ul>
            <li><a href="<c:url value='/admin'/>">
                    Admin</a></li>
            <li><a href="<c:url value='/userController/deleteCookies'/>">
                    Delete Cookies</a></li>
<%--            <li><a href="<c:url value='/order/showCart'/>">--%>
<%--                    Show Cart</a></li>--%>
        </ul>
    </nav>