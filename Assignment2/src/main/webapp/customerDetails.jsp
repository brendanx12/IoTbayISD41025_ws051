<%-- 
    Document   : customerDetails
    Created on : 3 May 2023, 7:06:56 pm
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
        <title>Account Details</title>
    </head>
    <body>
        <div>
            
            <nav>
                <ul>
                    <li><a href="mainPage.jsp">Home</a></li>
                    <li><a href="CustomerProductSearch.jsp">Search</a></li>
                    <li><a href="pay.jsp">Payment Settings</a></li>
                    <li><a href="LogOutController">Logout</a></li>
                    <li><a href="orderHomePage.jsp">Order Home Page</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                </ul>
            </nav>
        </div>
        <div class="container mt-3">
            <br>
        <br>
            <h1>Account Settings</h1>
            <p class="lead"></p>
<%
Customer customerDetails = (Customer) session.getAttribute("Customer");
%>
<!--
The idea is that they all go into the same singular servlet and the servlet checks if the atribute is null or not
if it isn't null then we're going to edit the data
-->
<h2>Account Details for: <%=customerDetails.getFirstName()%>!</h2>
<div>
           <table>
		<tbody>
			<tr>
                            <td><strong>First Name:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getFirstName()%></td>
			</tr>
                        <tr>
                            <td><strong>Middle Name:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getMiddleName()%></td>
			</tr>
                        <tr>
                            <td><strong>Last Name:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getLastName()%></td>
			</tr>
                        <tr>
                            <td><strong>Email:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getEmail()%></td>
			</tr>
                        <tr>
                            <td><strong>Mobile Number:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getMobileNumber()%></td>
			</tr>
                        <tr>
                            <td><strong>Address:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getAddress()%></td>
			</tr>
                        <tr>
                            <td><strong>State:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getState()%></td>
			</tr>
                        <tr>
                            <td><strong>City:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getCity()%></td>
			</tr>
                        <tr>
                            <td><strong>Postcode:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getPostcode()%></td>
			</tr>
                        <tr>
                            <td><strong>Password:</strong>&nbsp;<br> </td>
                            <td><%=customerDetails.getPassword()%></td>
			</tr>	
		</tbody>
	</table> 
        </div>  
                        <br>
                        <div class="button">
                             <a href="accessLogsJsp.jsp" class="btn btn-primary">view access logs</a>
                        </div>
                        <br>
                        <div class="button">
                             <a href="deleteAccount" class="btn btn-danger">Delete Account</a>
                        </div>
                         
                        
                        <br>
                        <h3>Edit Details:</h3>
<form action="customerUpdate" method="post">
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
        </div>
        
    </body>
</html>
