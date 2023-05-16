<%-- 
    Document   : ListOfProducts
    Created on : 5 May 2023, 8:28:22 pm
    Author     : brend
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="IoTbay.Product"%>
<%@page import="workshop.dao.DBProduct"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: rgba(155,100,214,0.3);
}
</style>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <div>
            <nav>
                <ul>
                    <li><a href="staffMainPage.jsp">Home</a></li>
                    <li><a href="LogOutController">Logout</a></li>
                    <li><a href="staffDetails.jsp">Account Settings</a></li>
                    <li><a href="ManageProducts.jsp">Manage Product Inventory</a></li>
                </ul>
            </nav>
        </div>
        
    </head>
    <body action="ShowInventoryController">
        
        <br>
        <br>
        <br>
        <br>
        <h1>Inventory for IoTBay</h1>
        <br>
        <br>
        <br>
        <br>
        
        
        <table width="60%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Type</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Image</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.ID}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.type}</td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                    <td>${product.image}</td>
                </tr>
            </c:forEach>
            
        </table>
        <br>
        <a href="ManageProducts.jsp">Back to Inventory Management Menu</a><br>
        
    </body>
</html>
