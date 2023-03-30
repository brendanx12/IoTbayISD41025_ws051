<%-- 
    Document   : login
    Created on : 30 Mar 2023, 8:18:17 pm
    Author     : brend
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <form align="center">
            <label for="email">Email</label><br>
            <input type="email" name="email"><br>
            <br>
            
            <label for="password">Password:</label><br>
            <input type="password" name="password"><br>
            <br>
        </form>
        
        <form align="center">
            <input type="submit" value="login" formaction="welcome.jsp" method="POST">
        </form>
        
        <form align="center">
            <label for="register">Don't have an account: <a href="login.jsp">Click here</a></label>
        </form>
        
        
    </body>
    
</html>
