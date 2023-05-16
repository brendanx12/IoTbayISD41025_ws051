<%-- 
    Document   : RemovalOfProduct
    Created on : 10 May 2023, 2:02:00 pm
    Author     : brend
--%>

<%@page import="IoTbay.Product"%>
<%@page import="workshop.dao.DBProduct"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<link rel="stylesheet" href="style_1.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">
<html>
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
        
        <% 
            Product product = (Product) session.getAttribute("product");
            String removed = (String) session.getAttribute("removed");
        %>
        <br>
        <div class="container">
        <br>
        <br>
        <br>
        <br>
        
        <h1>Remove Product</h1>
        <% if (product !=null) { %>
        <form action="RemoveProduct" method="post">
            <table width="60%">
                <input type="hidden" name="name" value="${product.getName()}">
                <tr>
                    <td>Product ID: </td>
                    <td><p><%=product.getID()%></p></td>
                </tr>
                
                <tr>
                    <td>Product Name: </td>
                    <td><p><%=product.getName()%></p></td>
                </tr>
                
                <tr>
                    <td>Product Description: </td>
                    <td><p><%=product.getDescription()%></p></td>
                </tr>
                
                <tr>
                    <td>Product Type: </td>
                    <td><p><%=product.getType()%></p></td>
                </tr>
                
                <tr>
                    <td>Product Price: </td>
                    <td><p><%=product.getPrice()%></p></td>
                </tr>
                
                <tr>
                    <td>Product Stock: </td>
                    <td><p><%=product.getStock()%></p></td>
                </tr>
                
                <tr>
                    <td>Product Image: </td>
                    <td><p><%=product.getImage()%></p></td>
                </tr>
        
            </table>
                
                <p>Are you sure you want to remove this product</p>
                <div class="button">
                    <input type="submit" value="Delete">
                </div>
        </form>
        <% } else { %>
        <span><%=(removed != null ? removed : "") %></span>
        <% } %>
        <a href="ProductSearchPage.jsp">Back to search page</a>
    </body>
</html>
