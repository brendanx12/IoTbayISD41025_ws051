<%-- 
    Document   : welcome
    Created on : 22 Mar 2023, 2:52:42 pm
    Author     : Mushini
--%>
<jsp:useBean id='customer1' scope='session' class='IotBay_Group1.customer' />
<jsp:setProperty name='customer1' property='firstName'/>
<jsp:setProperty name='customer1' property='lastName'/>
<jsp:setProperty name='customer1' property='middleName'/>
<jsp:setProperty name='customer1' property='email'/>
<jsp:setProperty name='customer1' property='mobileNumber'/>
<jsp:setProperty name='customer1' property='address'/>
<jsp:setProperty name='customer1' property='state'/>
<jsp:setProperty name='customer1' property='city'/>
<jsp:setProperty name='customer1' property='postcode'/>
<jsp:setProperty name='customer1' property='password'/>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<link rel="stylesheet" href="style_1.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <div><h1>Welcome to IotBay!</h1>
        <br>
        <h3>Successfully registered</h3>
        </div>
        
        <br>
        <form>
            <br>
        <div class="container">
        <%= "First name is: "%> <jsp:getProperty property='firstName' name='customer1'/>
        <br>
        <%= "Middle name is: "%> <jsp:getProperty property='middleName' name='customer1'/>
        <br>
         <%= "Last name is: "%> <jsp:getProperty property='lastName' name='customer1'/>
        <br>
        <%= "Email is: "%> <jsp:getProperty property='email' name='customer1'/>
        <br>
        <%= "Phone Number is: "%> <jsp:getProperty property='mobileNumber' name='customer1'/>
        <br>
         <%= "Address is: "%> <jsp:getProperty property='address' name='customer1'/>
        <br>
        <%= "State is: "%> <jsp:getProperty property='state' name='customer1'/>
        <br>
         <%= "City is: "%> <jsp:getProperty property='city' name='customer1'/>
        <br>
        <%= "Postcode is: "%> <jsp:getProperty property='postcode' name='customer1'/>
        <br>
         <%= "Password is: "%> <jsp:getProperty property='password' name='customer1'/>
        <br>
        </form>
        <br>
        <h3>Edit Info</h3>
        <form action='welcome.jsp'method='POST'>
        <label for="firstName">First Name: </label><br>
        <input type="text" name="firstName" required="true"><br>
  
        <label for="middelName">Middle Name: </label><br>
        <input type="text" name="middleName"><br>
  
        <label for="lastName">Last Name: </label><br>
        <input type="text" name="lastName">
        <br><br>
        <input type='submit' name='submit'>
        
        </form>
        <br>
        <a href="mainPage.jsp">Continue to Main Page</a>
        </div>
    </body>
</html>
