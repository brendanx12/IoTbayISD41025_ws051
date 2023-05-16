<%-- 
    Document   : welcomeBack
    Created on : 2 Apr 2023, 4:29:42 pm
    Author     : brend
--%>

<!--Getting the session's Student Attribute that was passed to this page after logging in-->

<!DOCTYPE html>
<%@page import="workshop.*"%>
<%@page import="IoTbay.*"%>
<%@page import="controller.*"%>
<%@ page language="java" import="java.util.*" %>
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
            <nav>
                <ul>
                    <li><a href="mainPage.jsp">Home</a></li>
                    <li><a href="LogOutController">Logout</a></li>
                    <li><a href="CustomerProductSearch.jsp">Search</a></li>
                    <li><a href="customerDetails.jsp">Account Settings</a></li>
                    <li><a href="orderHomePage.jsp">Order Home Page</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                </ul>
            </nav>
        </div>
    <div class="jumbotron mt-3">
        <br>
        <%
            Customer loggedInCustomer = (Customer) session.getAttribute("Customer");
        %>
        <br>
      <h1 class="display-4">Welcome to IotBay!</h1>
      <hr class="my-4">
      <h3>Welcome Back <%=loggedInCustomer.getFirstName()%>!</h3>
    </div>
    <form>
      <div class="container">
        <div class="form-group">
      
        </div>
      </div>
    </form>
            
        </form>
            <a href="mainPage.jsp" class="btn btn-primary mt-3">Continue to Main Page</a>
             
    </body>
    
    
</html>
