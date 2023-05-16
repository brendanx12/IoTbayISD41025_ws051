<%-- 
    Document   : SystemAdmin
    Created on : 16 May 2023, 10:55:40 pm
    Author     : brend
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>

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
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="createCustomer.jsp">Add Customer</a></li>
                    <li><a href="customerInformation.jsp">View Customer Information</a></li>
                    <li><a href="CustomerRecords.jsp">Customer Records</a></li>
                </ul>
            </nav>
        </div>
            <br>
        <div class="container">
            <br>
        <br>
        <br>
        <br>
        <h1>System Admin</h1>
        
        <a href="createCustomer.jsp" method="post">Add Customer<br></a>
        
        <a href="customerInformation.jsp" method="post">View Customer Information<br></a>
        
        <a href="CustomerRecords.jsp" method="post">View Customer Records<br></a>
        </div>
    </body>
</html>
