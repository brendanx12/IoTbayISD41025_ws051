<%-- 
    Document   : third
    Created on : 1 Apr 2023, 3:59:32 pm
    Author     : Mushini
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="workshop.*"%>
<%@page import="IoTbay.*"%>
<%@page import="controller.*"%>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html>
<link rel="stylesheet" href="style_1.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%
            Customer loggedInCustomer = (Customer) session.getAttribute("Customer");
        %>
            <nav>
                <ul>
                    <li><a href="mainPage.jsp">Home</a></li>
                    <li><a href="CustomerProductSearch.jsp">Search</a></li>
                    <li><a href="LogOutController">Logout</a></li>
                    <li><a href="customerDetails.jsp">Account Settings</a></li>
                </ul>
            </nav>
        </div>
        <div class="container mt-3">
            <br>
        <br>
            <h1>Main Page</h1>
            <p class="lead"><%= "Logged in as: " + loggedInCustomer.getFirstName()%></p>
            <a href="LogOutController" class="btn btn-danger">Click here to Log out</a>
        </div>
    </body>
</html>
