<%-- 
    Document   : ProductSearchPage
    Created on : 8 May 2023, 6:52:24 pm
    Author     : brend
--%>

<%@page import ="IoTbay.Product"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
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
            String updated = (String) session.getAttribute("found");
            Product product = (Product) session.getAttribute("product");
        %>
        
        <br>
        <div class="container">
        <br>
        <br>
        <br>
        <br>
        
        <h1>Search Product</h1>
        
        <form action="SearchProduct" method="post">
            <label for="id">Product Name: </label>
            <input type="text" name="name">
            <div class="button">
                <input type="submit" value="Search Product">
            </div>
        </form><br>
        
        <% if(product !=null) {  %>
        <table width="60%">
            <tr>
                <td>
                    <b>Product ID: </b>
                </td>
                <td>
                    <p><%=product.getID()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Product Name: </b>
                </td>
                <td>
                    <p><%=product.getName()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Product Description: </b>
                </td>
                <td>
                    <p><%=product.getDescription()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Product Type: </b>
                </td>
                <td>
                    <p><%=product.getType()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Product Stock: </b>
                </td>
                <td>
                    <p><%=product.getStock()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Product Price: </b>
                </td>
                <td>
                    <p><%=product.getPrice()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Product Image </b>
                </td>
                <td>
                    <p><%=product.getImage()%></p>
                </td>
            </tr>
            
        </table>
        
        <a href="UpdateProductInformation.jsp">Update Product</a>
        <a href="RemovalOfProduct.jsp">Delete Product</a>
        
        <% } %>

        <a href="ManageProducts.jsp">Back to Manage Products</a>
        </div>
         </body>   
     
        
        
        
</html>
