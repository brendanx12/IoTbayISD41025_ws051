<%-- 
    Document   : customerInformation
    Created on : 13 May 2023, 2:53:50 am
    Author     : shivali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="IoTbay.Customer"%>
<!DOCTYPE html>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Customer Registration</title>
    </head>
    <body>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="login.jsp">Customer Login</a></li>
            <li><a href="register2.jsp">Customer Sign Up</a></li>
            <li><a href="staff-login.jsp">Staff Login</a></li>
            <li><a href="SystemAdmin.jsp">System Admin</a></li> 
            
        </ul>
    </nav>
  <div class="container">
      <br>
        <br>
        
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Edit Customer Details</h3>
        
        <form action="updateCustomerShivali" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">First Name</span>
            <input type="text" placeholder="Enter First Name" required name='firstName' required>
          </div>
          <div class="input-box">
            <span class="details">Middle Name</span>
            <input type="text" placeholder="Enter Middle Name" name='middleName' required>
          </div>
            <div class="input-box">
            <span class="details">Last Name</span>
            <input type="text" placeholder="Enter Last Name" name='lastName' required>
          </div>
          <div class="input-box">
            <span class="details">Mobile Number</span>
            <input type="text" placeholder="Enter your number" name='mobileNumber' required>
          </div>
            <div class="input-box">
            <span class="details">Address</span>
            <input type="text" placeholder="Enter Address" name='address' required>
          </div>
            <div class="input-box">
            <span class="details">State</span>
            <input type="text" placeholder="Enter State" name='state' required>
          </div>
            
            <div class="input-box">
            <span class="details">City</span>
            <input type="text" placeholder="Enter city" name='city' required>
          </div>
            
            <div class="input-box">
            <span class="details">Postcode</span>
            <input type="text" placeholder="Enter postcode" name='postcode' required>
          </div>
            
          <div class="input-box">
            <span class="details">Password</span>
            <input type="text" placeholder="Enter your password" name='password' required>
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Submit Changes">
        </div>
          </div>
          <form align="center">
        </form>
        
    </body>
</html>
