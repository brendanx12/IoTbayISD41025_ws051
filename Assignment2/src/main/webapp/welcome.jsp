<%-- 
    Document   : welcome
    Created on : 22 Mar 2023, 2:52:42 pm
    Author     : Mushini
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
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
                    <li><a href="index.html">Index</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </ul>
            </nav>
        </div>
    <div class="jumbotron mt-3">
        <br>
        <br>
      <h1 class="display-4">Welcome to IotBay!</h1>
      <hr class="my-4">
      <% 
        String firstName = (String) session.getAttribute("newCustomer");
        out.print("Glad you joined! " + firstName);
          %>
      <h3>Successfully registered</h3>
      <p><% %></p>
    </div>
             
    </body>
    
    
</html>
