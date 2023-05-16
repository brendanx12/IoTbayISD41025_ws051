<%-- 
    Document   : UpdateProductInformation
    Created on : 6 May 2023, 10:00:58 pm
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
        <title>Update Product Information Page</title>
    </head>
        
        <%
            Product product = (Product) session.getAttribute("product");
            String updated = (String) session.getAttribute("updated");
        %>
       
        <body>
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
            
            <br>
            <br>
            <br>
            <h1>Update Product Information</h1>
            
            <br>
            <div class="container">
            <br>
            
         
            <% if (product != null) { %>
            <form action="UpdateProducts" method="post">
                <table width="50%">
                    <tr>
                        <thead>
                            <th>Product Field Names</th>
                            <th>Product Fields</th>
                        </thead>
                    </tr>
            
            <input type="hidden" name="id" value="${product.ID}">
            
            <tr><td><label for="name">Name:</label></td>
            <td><input type="text" name="name" value="${product.name}"></td>
            <br></tr>
            
            <tr><td><label for="description">Description:</label></td>
            <td><input type="text" name="description" value="${product.description}"></td>
            <br></tr>
            <tr><td><label for="type">Type:</label></td>
            <td><input type="text" name="type" value="${product.type}"></td>
            <br></tr>
            <tr><td><label for="price">Price:</label></td>
            <td><input type="text" name="price" value="${product.price}"></td>
            <br></tr>
            <tr><td><label for="stock">Stock:</label>
            <td><input type="text" name="stock" value="${product.stock}"></td>
            <br></tr>
            <tr><td><label for="image">Image:</label>
            <td><input type="text" name="image" value="${product.image}"></td>
            <br></tr>
         </table>
            
            <div class="button">
            <input type="submit" value="Update">
            </div>
        </form>
                <% } else {%>
                <span><%=(updated != null ? updated : "")%></span>
                <% } %>
                <br>
                <a href="ProductSearchPage.jsp">Back to Product Search</a>
                <a href="ManageProducts.jsp">Back to manage products page</a><br>
                
            </div>
            </body>    
</html>
