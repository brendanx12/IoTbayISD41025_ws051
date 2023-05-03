<%-- 
    Document   : index
    Created on : 29 Apr 2023, 4:13:48 pm
    Author     : Mushini
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>index</title>
<!--        <meta charset="windows-1252">-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="css/StyleSheetForNavBar.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register2.jsp">Register</a></li>
            </ul>
        </nav>
        <br>
        <br>
        <h1 align="center">IoT Bay Home Page</h1>
        <!--included-->
        <jsp:include page="/ConnServletIotBay" flush="true"/>
    </body>
    
</html>
