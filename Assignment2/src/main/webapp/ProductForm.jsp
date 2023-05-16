<%-- 
    Document   : FormProduct
    Created on : 3 May 2023, 9:27:43 pm
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
    <body action="AddProduct">
        
        <%
            String added = (String)session.getAttribute("added");
        %>
        
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
            <div class="title">Add a Product</div>
            <div class="content">
                <form action="AddProduct" method="post">
                    <div class="product-details">
                        <div class="input-box">
                            <span class="details">Id</span>
                            <input type="text" placeholder="Enter in an id" name='id' required>
                        </div>
                        <div class="input-box">
                            <span class="details">Name</span>
                            <input type="text" placeholder="Enter in a name" name='name' required>
                        </div>
                        <div class="input-box">
                            <span class="details">Description</span>
                            <input type="text" placeholder="Enter in a description" name='description' required>
                        </div>
                        <div class="input-box">
                            <span class="details">Type</span>
                            <input type="text" placeholder="Enter in a type" name='type' required>
                        </div>
                        <div class="input-box">
                            <span class="details">Price</span>
                            <input type="text" placeholder="Enter in the price" name='price' required>
                        </div>
                        <div class="input-box">
                            <span class="details">Stock</span>
                            <input type="text" placeholder="Enter in stock" name='stock' required>
                        </div>
                        <div class="input-box">
                            <span class="details">Image Link</span>
                            <input type="text" placeholder="Enter in the image link" name='image' required>
                        </div>
                        
                    </div>
                    <div class="button">
                        <input type="submit" value="Add Product"></input>
                    </div>
                   
                </form>
                <br>
                <a href="ManageProducts.jsp">Back to Inventory Management Menu</a><br>
                <span><%= (added != null ? added : "")%></span
            </div>
        </div>
       
    </body>
</html>