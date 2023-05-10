<%-- 
    Document   : login
    Created on : 1 Apr 2023, 9:57:45 pm
    Author     : brend
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/StyleSheetForNavBar.css">
<link rel="stylesheet" href="css/bootstrap.css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Staff Login</title>
       
    </head>
    <body>
        <div>
        <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Customer Login</a></li>
                <li><a href="register2.jsp">Customer Sign Up</a></li>
                    
                    <li><a href="staff-register.jsp">Staff Register</a></li>
                </ul>
        </nav>
        </div>
            <br>
        <div class="container">
            <br>
        <br>
        <br>
        <br>
            <div class="title">Login</div>
            <div class="content">
                <form action="StaffLoginIotBay" method="post">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="text" placeholder="Enter your email" name='email' required>
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" placeholder="Enter your password" name='password' required>
                        </div>
                        <% 
         String passIsCorrect = (String) session.getAttribute("passIsCorrect");
         if(passIsCorrect != null){
                            out.print("Incorrect login details");
                            }
          %>
                    </div>
                    <div class="button">
                        <input type="submit" value="Login">
                    </div>
                    <form align="center">
                        <label for="register">Don't have an account: <a href="register2.jsp">Click here</a></label>
                    </form>
                </form>
            </div>
        </div>
       
    </body>
</html>
