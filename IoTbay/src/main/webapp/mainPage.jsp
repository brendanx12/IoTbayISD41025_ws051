<%-- 
    Document   : third
    Created on : 1 Apr 2023, 3:59:32 pm
    Author     : Mushini
--%>
<jsp:useBean id='employee' scope='session' class='IoTbay.EmployeesBean' />
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<link rel="stylesheet" href="style_1.css">
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
                    <li><a href="index.html">Home</a></li>
                    <li><a href="logout.jsp">Logout</a></li>
                </ul>
            </nav>
        </div>
        <div class="container mt-3">
            <h1>Main Page</h1>
            <p class="lead">Logged in as: ${customer1.firstName}</p>
            <a href="logout.jsp" class="btn btn-danger">Click here to Log out</a>
        </div>
    </body>
</html>
