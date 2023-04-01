<%-- 
    Document   : third
    Created on : 1 Apr 2023, 3:59:32 pm
    Author     : Mushini
--%>
<jsp:useBean id='employee' scope='session' class='IoTbay.EmployeesBean' />
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<link rel="stylesheet" href="style_1.css">
<link rel="stylesheet" href="StyleSheetForNavBar.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
         </nav>
    </head>
    <body>
        <h1>Main Page</h1>
        <%= "Logged in as: "%>${customer1.firstName}
        <br>
        <a href='logout.jsp'>Click here to Log out</a>
    </body>
</html>
