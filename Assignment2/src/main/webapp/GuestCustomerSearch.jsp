<%-- 
    Document   : GuestCustomerSearch
    Created on : 15 May 2023, 7:34:11 pm
    Author     : brend
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<%@page import="IoTbay.Product"%>
<%@page import="workshop.dao.DBProduct"%>
<%@page import="java.util.List"%>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Customer Search List</title>
        <style>
        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            grid-gap: 20px;
        }

        .product-card {
            border: 1px solid #ccc;
            padding: 10px;
        }

        .product-card h3 {
            margin-top: 0;
        }
    </style>
    
    <div>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Customer Login</a></li>
                    <li><a href="register2.jsp">Customer Sign Up</a></li>
                    <li><a href="staff-login.jsp">Staff Login</a></li>
                    <li><a href="staff-register.jsp">Staff Sign Up</a></li>
                    <li><a href="GuestCustomerSearch.jsp">Search</a></li>
                    <li><a href="orderHomePage.jsp">Order Home Page</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                </ul>
            </nav>
    </div>
    </head>
    <body>
        <div class="container">
        <h1>Search</h1>
        
        <form action="GuestCustomerSearch" method="post">
            <label for="searchType">Search By:</label>
            <select id="searchType" name="searchType">
                <option value="name">Product Name</option>
                <option value="type">Product Type</option>
            </select>
            
            <br><br>
            
            <label for="keyword">Keyword:</label>
            <input type="text" id="keyword" name="keyword">
            
            <br><br>
            
            <input type="submit" value="Search">
            
            
        </form>
        
        <% List<Product> productList = (List<Product>) session.getAttribute("productList");%>
        <% if(productList != null && !productList.isEmpty()) { %>
        <div class="product-list">
            <% for(Product product : productList) { %>
            <div class="product-card">
                <h3><%= product.getName()%></h3>
                <p><%= product.getDescription()%></p>
                <p>Price: <%= product.getPrice()%></p>
                <p>Stock: <%= product.getStock()%></p>
            </div>
                <% } %>
        </div>
     <% } else { %>
     <p>No product results could be returned</p>
     <% } %>
     <br>
     <a href="index.jsp">Home</a>
     </div>
</html>
