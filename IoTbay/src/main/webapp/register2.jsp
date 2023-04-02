<%-- 
    Document   : register2
    Created on : 1 Apr 2023, 5:18:27 pm
    Author     : Mushini
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body class="rAlDisplay">
  <div class="container">
            <nav>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register2.jsp">Register</a></li>
                </ul>
            </nav>
    <div class="title">Registration</div>
    <div class="content">
      <form action="welcome.jsp" method="POST">
        <div class="user-details">
          <div class="input-box">
            <span class="details">First Name</span>
            <input type="text" placeholder="Enter First Name" required name='firstName'>
          </div>
          <div class="input-box">
            <span class="details">Middle Name</span>
            <input type="text" placeholder="Enter Middle Name" name='middleName'>
          </div>
            <div class="input-box">
            <span class="details">Last Name</span>
            <input type="text" placeholder="Enter Last Name" name='lastName' required>
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input type="text" placeholder="Enter your email" name='email' required>
          </div>
          <div class="input-box">
            <span class="details">Mobile Number</span>
            <input type="text" placeholder="Enter your number" name='mobileNumber' required>
          </div>
            <div class="input-box">
            <span class="details">Address</span>
            <input type="text" placeholder="Enter Address" name='address'>
          </div>
            <div class="input-box">
            <span class="details">State</span>
            <input type="text" placeholder="Enter State" name='state'>
          </div>
            
            <div class="input-box">
            <span class="details">City</span>
            <input type="text" placeholder="Enter city" name='city'>
          </div>
            
            <div class="input-box">
            <span class="details">Postcode</span>
            <input type="text" placeholder="Enter postcode" name='postcode'>
          </div>
            
          <div class="input-box">
            <span class="details">Password</span>
            <input type="text" placeholder="Enter your password" name='password' required>
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Register">
        </div>
      </form>
    </div>
  </div>

</body>
</html>
