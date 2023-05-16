<%-- 
    Document   : index
    Created on : 29 Apr 2023, 4:13:48 pm
    Author     : Mushini
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IotBay</title>
<!--        <meta charset="windows-1252">-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="css/StyleSheetForNavBar.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
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
                <li><a href="SystemAdmin.jsp">System Admin</a></li> 
                
            </ul>
        </nav>
        <br>
        <br>
        <h1 align="center">IoT Bay Home Page</h1>
        <!--included-->
        <jsp:include page="/ConnServletIotBay" flush="true"/>
    </body>
    
</html>
