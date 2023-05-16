<%@page import="IoTbay.Product"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="workshop.*"%>
<%@page import="IoTbay.*"%>
<%@page import="controller.*"%>
<%@ page import="java.sql.*" %>
<%@ page import="workshop.dao.*" %>

<%@ page language="java" import="java.util.*" %>

<%@ page import="java.sql.*" %>
<%@page import="workshop.*"%>
<%@page import="IoTbay.*"%>
<%@page import="controller.*"%>
<%@ page import="workshop.dao.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" import="java.util.*" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/OrderPageStyle.css">



<html>
<head>
    <title>Cart</title>
    <style>
        th, td {
                padding-left: 40px;
                padding-right: 40px;
                padding-bottom: 5px;
               }
        
    </style>
</head>
<body>

            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register2.jsp">Register</a></li>
                    <li><a href="orderHomePage.jsp">Order Page</a></li>
                </ul>
            </nav>
        </div>


        <div class="container">
            <br>
            <br>
            <div class="title">Cart</div>
    
    <table>
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Price</td>
            <td>Remove Product</td>      
        </tr>
        
        <tr>
            <td></td>
        </tr>
        <%
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    if (cart != null && !cart.isEmpty()) {
        for (Product product : cart) {
        %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getType() %></td>
            <td><%= product.getPrice() %></td>
            <td>
            <form action="RemovefromCart" method="get">
                <input type="hidden" name="productID" value="<%= product.getID() %>">
                <button type="submit">Remove item</button>
            </form>
            </td>    
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5">No products in the cart</td>
        </tr>
        <%
        }
        %>
    </table>
        
        <form action="submitOrder.jsp" method="post">
            <button type="submit">Submit Order</button>
        </form>
        
    
        
        <form action="ClearCart" method="post">
            <button type="submit">Clear Cart</button>
        </form>
        
            
        </div>
    
    
    
</body>
</html>
