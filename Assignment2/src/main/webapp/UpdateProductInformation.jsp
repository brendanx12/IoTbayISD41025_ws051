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
            <h1>Update Product Information</h1>
            
            <div class="container mt-3">
         
            <% if (product != null) { %>
            <form action="UpdateProducts" method="post">
                <table width="60%">
                    <tr>
                        <thead>
                            <th></th>
                            <th>Current Product Information</th>
                            <th>New Product Information</th>
                        </thead>
                    </tr>
                    
                    <tr>
                        <td>
                            <label for name="name"><b>Product Name</b></label>
                        </td>
                        <td>
                            <p><%=product.getName()%></p>
                        </td>
                        <td>
                            <input type="text" id="name" name="name" required><br>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <label for name="description"><b>Product Description</b></label>
                        </td>
                        <td>
                            <p><%=product.getDescription()%></p>
                        </td>
                        <td>
                            <input type="text" id="description" name="description" required><br>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <label for name="type"><b>Product Type</b></label>
                        </td>
                        <td>
                            <p><%=product.getType()%></p>
                        </td>
                        <td>
                            <input type="text" id="type" name="type" required><br>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <label for name="price"><b>Product Price</b></label>
                        </td>
                        <td>
                            <p><%=product.getPrice()%></p>
                        </td>
                        <td>
                            <input type="text" id="price" name="price" required><br>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <label for name="stock"><b>Product Stock</b></label>
                        </td>
                        <td>
                            <p><%=product.getStock()%></p>
                        </td>
                        <td>
                            <input type="text" id="stock" name="stock" required><br>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <label for name="image"><b>Product Image Link</b></label>
                        </td>
                        <td>
                            <p><%=product.getImage()%></p>
                        </td>
                        <td>
                            <input type="text" id="image" name="image" required><br>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <div class="button">
                                <input type="submit" value="Update Item">
                            </div>
                        </td>
                    </tr>
                    
                </table>
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
