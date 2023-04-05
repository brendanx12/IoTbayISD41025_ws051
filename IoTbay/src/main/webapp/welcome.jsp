<%-- 
    Document   : welcome
    Created on : 22 Mar 2023, 2:52:42 pm
    Author     : Mushini
--%>
<jsp:useBean id='customer1' scope='session' class='IoTbay.Customer' />
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
                    <li><a href="index.html">Index</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="mainPage.jsp">Home</a></li>
                </ul>
            </nav>
        </div>
    <div class="jumbotron mt-3">
      <h1 class="display-4">Welcome to IotBay!</h1>
      <hr class="my-4">
      <h3>Successfully registered</h3>
    </div>

    <form>
      <div class="container">
        <div class="form-group">
          <%= "First name is: "%> <jsp:getProperty property='firstName' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "Middle name is: "%> <jsp:getProperty property='middleName' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "Last name is: "%> <jsp:getProperty property='lastName' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "Email is: "%> <jsp:getProperty property='email' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "Phone Number is: "%> <jsp:getProperty property='mobileNumber' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "Address is: "%> <jsp:getProperty property='address' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "State is: "%> <jsp:getProperty property='state' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "City is: "%> <jsp:getProperty property='city' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "Postcode is: "%> <jsp:getProperty property='postcode' name='customer1'/>
        </div>
        <div class="form-group">
          <%= "Password is: "%> <jsp:getProperty property='password' name='customer1'/>
        </div>
      </div>
    </form>

    <div class="container mt-3">
      <h3>Edit Info</h3>
      <form action="welcome.jsp" method="POST">
        <div class="form-group">
          <label for="firstName">First Name:</label>
          <input type="text" class="form-control" name="firstName" required="true">
        </div>
        <div class="form-group">
          <label for="middelName">Middle Name:</label>
          <input type="text" class="form-control" name="middleName">
        </div>
        <div class="form-group">
          <label for="lastName">Last Name:</label>
          <input type="text" class="form-control">     
        </div>
          <div class="button">
              <input type='submit' name='submit'>
          </div>
            
        </form>
            <a href="mainPage.jsp" class="btn btn-primary mt-3">Continue to Main Page</a>
             
    </body>
    
    
</html>
