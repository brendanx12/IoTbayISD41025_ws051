<%-- 
    Document   : CustomerRecords
    Created on : 15 May 2023, 9:16:15 pm
    Author     : shivali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="IoTbay.Customer"%>
<%@page import="workshop.dao.DBManager"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Customers</title>
 <div>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Customer Login</a></li>
                <li><a href="register2.jsp">Customer Sign Up</a></li>
                <li><a href="staff-login.jsp">Staff Login</a></li>
                <li><a href="SystemAdmin.jsp">System Admin</a></li> 

            </ul>
        </nav>
 </div>
  <div class="container">
      <br>
        <br>
    <div class="title">Customer Database</div>
    <div class="content">
    
    <body action="ListCustomerRecords">
       
        <table width="60%">
            <thead>
                <tr>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Mobile Number</th>
                <th>Address</th>
                <th>City</th>
                </tr>
            </thead>
            <c:forEach items="${customers}" var="customer"> 
                     <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.middleName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.mobileNumber}</td>
                    <td>${customer.address}</td>
                    <td>${customer.city}</td>
                    
                </tr>
                
            </c:forEach>
            
        </table>
    </body>
</html>
