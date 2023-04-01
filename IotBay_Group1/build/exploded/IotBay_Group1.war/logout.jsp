<%-- 
    Document   : logout
    Created on : 1 Apr 2023, 4:26:01 pm
    Author     : Mushini
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<link rel="stylesheet" href="style_1.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>You've successfully been logged out!</h1>
        <% session.invalidate();%>
        <a href='index.html'>Home Page</a>
    </body>
</html>
