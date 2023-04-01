<%-- 
    Document   : login
    Created on : 1 Apr 2023, 9:57:45 pm
    Author     : brend
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="StyleSheetForNavBar.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
       
    </head>
    <body>
        <%
            String firstName = request.getParameter("firstName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
        %>
        
        <div class="container">
            <nav>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register2.jsp">Register</a></li>
                </ul>
            </nav>
    <div class="title">Login</div>
    <div class="content">
      <form action="welcome.jsp" method="POST">
        <div class="user-details">
          <div class="input-box">
            <span class="details">First Name</span>
            <input type="text" placeholder="Enter First Name" required name='firstName'>
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input type="text" placeholder="Enter your email" name='email' required>
          </div>
          <div class="input-box">
            <span class="details">Password</span>
            <input type="text" placeholder="Enter your password" name='password' required>
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Login">
        </div>
      </form>
    </div>
  </div>
    </body>
</html>
