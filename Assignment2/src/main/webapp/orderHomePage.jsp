<%-- 
    Document   : orderHomePage
    Created on : 6 May 2023, 10:46:20 pm
    Author     : danielhoang
--%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Home Page</title>
    </head>
    
    <body>        
        
        <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register2.jsp">Register</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    
                </ul>
        </nav>
        </div>
        
       
        <div class="container">
            <br>
            <br>
            <div class="title">Order</div>
        
            
            <%  DBConnector dbConnector = new DBConnector();
    Connection conn = dbConnector.openConnection();
    DBProductDao productDao = new DBProductDao(conn);
    List<Product> products = productDao.getAllProducts();
            %>
            
            
         <!--   
            <% // String noStockMessage; %>  
            <% //if (noStockMessage != null && !noStockMessage.isEmpty()) { %>
            <div class="row">
                <div class="column">
                    <div class="error-message">
                        <%//= noStockMessage %>
                    </div>
                </div>
            </div>
            <% //} %>
         -->   
            

            
            
            <%
                if (!products.isEmpty())    {
                    for (Product p : products)  {  
            %>
                        <div class="row">
                            <div class = "column">   
                                <div class="card" style="width: 18rem;">
                                    <form action="AddtoCart" method="get">
                                    <div class="card-body">
                                   
                                        <h5 class="card-title"><%= p.getName() %></h5>
                                        <p class="card-text">Price: $ <%= p.getPrice() %> </p>
                                            <input type="hidden" name="productID" value="<%= p.getID() %>">
                                            <button type="submit">Add to Cart</button>
                                        
                                    </div>
                                    </form>                                   
                                </div>
                            </div>
                        </div>
                        
                 <%   }   
                }   %>
            
                
              
            

    </div> 
    
    
                
    
    </body>
    
</html>
