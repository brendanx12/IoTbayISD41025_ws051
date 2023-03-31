<%-- 
    Document   : register
    Created on : 22 Mar 2023, 2:25:27 pm
    Author     : Mushini
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
  <label for="firstName">First Name: </label><br>
  <input type="text" name="firstName"><br>
  
  <label for="middelName">Middle Name: </label><br>
  <input type="text" name="middleName"><br>
  
  <label for="lastName">Last Name: </label><br>
  <input type="text" name="lastName"><br>
  
  <label for="address">Address: </label><br>
  <input type="text" name="address"><br>
  
  <label for="state">State: </label><br>
  <input type="text" name="state"><br>
  
  <label for="city">City: </label><br>
  <input type="text" name="city"><br>
  
  <label for="postCode">Postcode: </label><br>
  <input type="text" name="postCode"><br>
  
   <label for="email">Email:</label><br>
  <input type="text" name="email"><br>
  
  <label for="password">Password:</label><br>
  <input type="password" name="password"><br>
  
  
  
  
</form>
        
        <form align="center">
            <input type="submit" value="submit" formaction="welcome.jsp" method="POST">
        </form>
        
        <form align="center">
           <label for="login">Already have an account: <a href="login.jsp">Click here</a></label>
        </form>
        
    </body>
</html>
