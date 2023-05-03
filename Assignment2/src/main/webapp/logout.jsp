<%-- 
    Document   : logout
    Created on : 1 Apr 2023, 4:26:01 pm
    Author     : Mushini
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
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register2.jsp">Register</a></li>
            </ul>
        </nav>
        
        <div class="container mt-5">
        <h1>You've successfully been logged out!</h1>
        <!--This just invalidates the session-->
        <% session.invalidate();%>
        <a href='index.jsp' class="btn btn-primary mt-3" style="background-color: #333;">Home Page</a>
        </div>  
    </body>
</html>
