<%-- 
    Document   : ManageProducts
    Created on : 5 May 2023, 8:58:18 pm
    Author     : brend
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="IoTbay.Product"%>
<!DOCTYPE html>
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
                    <li><a href="staffMainPage.jsp">Home</a></li>
                    <li><a href="LogOutController">Logout</a></li>
                    <li><a href="staffDetails.jsp">Account Settings</a></li>
                    <li><a href="ManageProducts.jsp">Manage Product Inventory</a></li>
                    <li><a href="StaffProductSearch.jsp">Search</a></li>
                </ul>
            </nav>
        </div>
            <br>
        <div class="container">
            <br>
        <br>
        <br>
        <br>
        <h1>Manage IoTbay Inventory</h1>
        
        <a href="ProductForm.jsp" method="post"> Add Product Item to Inventory<br></a>
        
        <a href="ShowInventoryController" method="post">Show Product Inventory<br></a>
        
        <a href="ProductSearchPage.jsp" method="post">Search Products<br></a>
        </div>
    </body>
</html>
